package com.d8games.web.services.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
@PropertySource("classpath:application.properties")
public class ConfigManager {

    private static final String PROPERTIES_FILE_NAME = "config.properties";
    private InputStream inputStream;

    /* --------------- Config Properties --------------- */
    private static String officeIp;

    private static String voucherLocationOffice;
    private static String voucherLocationHome;

    private static String voucherTypeIn;
    private static String voucherTypeOut;

    private static String nightHoursStartAsString;
    private static String nightHoursEndAsString;

    private static int nightHoursStart;
    private static int nightHoursEnd;

    private static int voucherNoOutPunishment;

    private static String contactDepartmentName;

    private static String countryCode;

    private static int authenticationTimeout;

    public ConfigManager() throws IOException {
        Properties properties = getProperties();

        ConfigManager.officeIp = properties.getProperty("officeIp");

        ConfigManager.voucherLocationOffice = properties.getProperty("voucherLocationOffice");
        ConfigManager.voucherLocationHome = properties.getProperty("voucherLocationHome");

        ConfigManager.voucherTypeIn = properties.getProperty("voucherTypeIn");
        ConfigManager.voucherTypeOut = properties.getProperty("voucherTypeOut");

        ConfigManager.nightHoursStartAsString = properties.getProperty("nightHoursStart");
        ConfigManager.nightHoursEndAsString = properties.getProperty("nightHoursEnd");

        ConfigManager.nightHoursStart = Integer.parseInt(properties.getProperty("nightHoursStart"));
        ConfigManager.nightHoursEnd = Integer.parseInt(properties.getProperty("nightHoursEnd"));

        ConfigManager.voucherNoOutPunishment = Integer.parseInt(properties.getProperty("voucherNoOutPunishment"));

        ConfigManager.contactDepartmentName = properties.getProperty("contactDepartmentName");

        ConfigManager.countryCode = properties.getProperty("countryCode");

        ConfigManager.authenticationTimeout = Integer.parseInt(properties.getProperty("authenticationTimeout"));
    }

    private Properties getProperties() throws IOException {
        Properties properties = new Properties();

        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + PROPERTIES_FILE_NAME + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }

        return properties;
    }

    public static String getOfficeIp() {
        return officeIp;
    }

    public static String getVoucherLocationOffice() {
        return voucherLocationOffice;
    }

    public static String getVoucherLocationHome() {
        return voucherLocationHome;
    }

    public static String getVoucherTypeIn() {
        return voucherTypeIn;
    }

    public static String getVoucherTypeOut() {
        return voucherTypeOut;
    }

    public static String getNightHoursStartAsString() {
        return nightHoursStartAsString;
    }

    public static String getNightHoursEndAsString() {
        return nightHoursEndAsString;
    }

    public static int getNightHoursStart() {
        return nightHoursStart;
    }

    public static int getNightHoursEnd() {
        return nightHoursEnd;
    }

    public static int getVoucherNoOutPunishment() {
        return voucherNoOutPunishment;
    }

    public static String getContactDepartmentName() {
        return contactDepartmentName;
    }

    public static String getCountryCode() {
        return countryCode;
    }

    public static int getAuthenticationTimeout() {
        return authenticationTimeout;
    }
}
