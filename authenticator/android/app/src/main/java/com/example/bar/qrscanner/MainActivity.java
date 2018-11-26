package com.example.bar.qrscanner;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String GET_IP_URL = "http://api.ipify.org/?format=json";
    private static final String POST_AUTHENTICATION_URL = "http://142.93.173.131:8888/api/services/controller/authentication/update";

    private static final int REQUEST_CAMERA_PERMISSION_ID = 1001;
    private static final int VIBRATION_DURATION = 250;

    private SurfaceView cameraPreview;
    private TextView barcodeInfo;
    private CameraSource cameraSource;
    private RequestQueue requestQueue;

    private String employeeMobilePhoneId = null;
    private boolean qrCodeReadable;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSION_ID: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this,
                            android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                        return;

                    try {
                        cameraSource.start(cameraPreview.getHolder());
                    } catch (IOException exception) {
                        handleException(exception);
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestQueue = Volley.newRequestQueue(this);

        employeeMobilePhoneId = new SecureIdVendor(getContentResolver()).get();
        qrCodeReadable = true;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraPreview = (SurfaceView) findViewById(R.id.cameraPreview);

        barcodeInfo = (TextView) findViewById(R.id.status_text);
        barcodeInfo.setVisibility(View.INVISIBLE);

        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(this)
            .setBarcodeFormats(Barcode.QR_CODE)
            .build();
        cameraSource = new CameraSource
            .Builder(this, barcodeDetector)
            .setRequestedPreviewSize(640, 480)
            .build();

        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(MainActivity.this, new String [] {
                        Manifest.permission.CAMERA
                    }, REQUEST_CAMERA_PERMISSION_ID);

                try {
                    cameraSource.start(cameraPreview.getHolder());
                } catch (IOException exception) {
                    handleException(exception);
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {

            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrcodes = detections.getDetectedItems();

                if (qrcodes.size() != 0 && qrCodeReadable) {
                    final String authenticationId = qrcodes.valueAt(0).displayValue;
                    qrCodeReadable = false;

                    barcodeInfo.post(new Runnable() {

                        @Override
                        public void run() {
                            getIpThenPostAuthentication(authenticationId);
                        }
                    });
                }
            }
        });
    }

    private void getIpThenPostAuthentication(final String authenticationId) {
        JsonObjectRequest getIpRequest = new JsonObjectRequest(Request.Method.GET, GET_IP_URL,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String authenticationIp = null;

                try {
                    authenticationIp = response.getString("ip");
                } catch (JSONException exception) {
                    handleException(exception);
                }

                postAuthentication(authenticationId, authenticationIp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                handleException(volleyError);
            }
        });

        requestQueue.add(getIpRequest);
    }

    private void postAuthentication(final String authenticationId, final String authenticationIp) {
        final String postAuthenticationUrl = POST_AUTHENTICATION_URL +
                "?id=" + authenticationId +
                "&ip=" + authenticationIp +
                "&mobilePhoneId=" + employeeMobilePhoneId;

        StringRequest postAuthenticationRequest = new StringRequest(Request.Method.POST,
                postAuthenticationUrl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                showSuccessDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                handleException(volleyError);
            }
        });

        requestQueue.add(postAuthenticationRequest);
    }

    private void showSuccessDialog() {
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(VIBRATION_DURATION);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Success");
        builder.setMessage("QR Code is successfully read!")
                .setCancelable(false)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        qrCodeReadable = true;
                    }
                });

        builder.create().show();
    }

    private void handleException(Exception exception) {
        exception.printStackTrace();
        System.exit(0);
    }
}
