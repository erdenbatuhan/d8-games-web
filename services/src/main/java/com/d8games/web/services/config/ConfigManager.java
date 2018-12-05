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

    private static String voucherNotApplicable;

    private static String voucherLocationOffice;
    private static String voucherLocationHome;

    private static String voucherTypeIn;
    private static String voucherTypeOut;

    private static String nightHoursStart;
    private static String nightHoursEnd;

    private static int integerNightHoursStart;
    private static int integerNightHoursEnd;

    private static int voucherNoOutPunishment;

    private static int authenticationTimeout;

    private static String contactDepartmentName;

    private static String countryCode;

    private static String gmailUsername;
    private static String gmailPassword;

    public ConfigManager() throws IOException {
        Properties properties = getProperties();

        ConfigManager.officeIp = properties.getProperty("officeIp");

        ConfigManager.voucherNotApplicable = properties.getProperty("voucherNotApplicable");

        ConfigManager.voucherLocationOffice = properties.getProperty("voucherLocationOffice");
        ConfigManager.voucherLocationHome = properties.getProperty("voucherLocationHome");

        ConfigManager.voucherTypeIn = properties.getProperty("voucherTypeIn");
        ConfigManager.voucherTypeOut = properties.getProperty("voucherTypeOut");

        ConfigManager.nightHoursStart = properties.getProperty("nightHoursStart");
        ConfigManager.nightHoursEnd = properties.getProperty("nightHoursEnd");

        ConfigManager.integerNightHoursStart = Integer.parseInt(properties.getProperty("integerNightHoursStart"));
        ConfigManager.integerNightHoursEnd = Integer.parseInt(properties.getProperty("integerNightHoursEnd"));

        ConfigManager.authenticationTimeout = Integer.parseInt(properties.getProperty("authenticationTimeout"));

        ConfigManager.voucherNoOutPunishment = Integer.parseInt(properties.getProperty("voucherNoOutPunishment"));

        ConfigManager.contactDepartmentName = properties.getProperty("contactDepartmentName");

        ConfigManager.countryCode = properties.getProperty("countryCode");

        ConfigManager.gmailUsername = properties.getProperty("gmailUsername");
        ConfigManager.gmailPassword = properties.getProperty("gmailPassword");
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

    public static String getVoucherNotApplicable() {
        return voucherNotApplicable;
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

    public static String getNightHoursStart() {
        return nightHoursStart;
    }

    public static String getNightHoursEnd() {
        return nightHoursEnd;
    }

    public static int getIntegerNightHoursStart() {
        return integerNightHoursStart;
    }

    public static int getIntegerNightHoursEnd() {
        return integerNightHoursEnd;
    }

    public static int getVoucherNoOutPunishment() {
        return voucherNoOutPunishment;
    }

    public static int getAuthenticationTimeout() {
        return authenticationTimeout;
    }

    public static String getContactDepartmentName() {
        return contactDepartmentName;
    }

    public static String getCountryCode() {
        return countryCode;
    }

    public static String getGmailUsername() {
        return gmailUsername;
    }

    public static String getGmailPassword() {
        return gmailPassword;
    }
}
