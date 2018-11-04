//
//  ViewController.swift
//  D8 Games Mobile Authenticator
//
//  Created by Batuhan Erden on 03/11/2018.
//  Copyright © 2018 Batuhan Erden. All rights reserved.
//

import UIKit
import AVFoundation

class ViewController: UIViewController, AVCaptureMetadataOutputObjectsDelegate {
    
    var authenticationId = ""
    var video = AVCaptureVideoPreviewLayer()
    
    @IBOutlet weak var square: UIImageView!
    @IBOutlet weak var uuidLabel: UILabel!
    
    func getAuthenticationIp(url: String) -> String {
        var errorOccured = false
        var authenticationIp = ""
        
        let urlConfig = URLSessionConfiguration.default
        let urlSession = URLSession(configuration: urlConfig)
        let url = URL(string: url)!
        
        let task = urlSession.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print(error!.localizedDescription)
                errorOccured = true
            } else {
                do {
                    if let jsonResult = try JSONSerialization.jsonObject(with: data!, options: []) as? NSDictionary {
                        authenticationIp = jsonResult["ip"]! as! String
                    }
                } catch let error as NSError {
                    print(error.localizedDescription)
                    errorOccured = true
                }
            }
        }
        
        task.resume()
        
        while !errorOccured && authenticationIp == "" {
            /* Wait for the data to be read */
        }
        
        return authenticationIp
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let authenticationIp = getAuthenticationIp(url: "https://api.ipify.org/?format=json")
        print(authenticationIp)
        
        if let uuid = UIDevice.current.identifierForVendor?.uuidString {
            authenticationId = uuid
            uuidLabel.text = authenticationId
        }
        
        let session = AVCaptureSession()
        let captureDevice = AVCaptureDevice.default(for: AVMediaType.video)
        
        do {
            let input = try AVCaptureDeviceInput(device: captureDevice!)
            session.addInput(input)
        } catch {
            print ("An error occured!")
        }
        
        let output = AVCaptureMetadataOutput()
        session.addOutput(output)
        
        output.setMetadataObjectsDelegate(self, queue: DispatchQueue.main)
        output.metadataObjectTypes = [AVMetadataObject.ObjectType.qr]
        
        video = AVCaptureVideoPreviewLayer(session: session)
        video.frame = view.layer.bounds
        
        view.layer.addSublayer(video)
        
        self.view.bringSubview(toFront: square)
        self.view.bringSubview(toFront: uuidLabel)
        
        session.startRunning()
    }
    
    func metadataOutput(_ output: AVCaptureMetadataOutput, didOutput metadataObjects: [AVMetadataObject], from connection: AVCaptureConnection) {
        if metadataObjects != nil && metadataObjects.count != 0 {
            if let object = metadataObjects[0] as? AVMetadataMachineReadableCodeObject {
                if object.type == AVMetadataObject.ObjectType.qr {
                    let alert = UIAlertController(title: "QR Code", message: object.stringValue, preferredStyle: .alert)
                    
                    alert.addAction(UIAlertAction(title: "Retake", style: .default, handler: nil))
                    alert.addAction(UIAlertAction(title: "Copy", style: .default, handler: { (nil) in
                        UIPasteboard.general.string = object.stringValue
                    }))
                    
                    present(alert, animated: true, completion: nil)
                }
            }
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

