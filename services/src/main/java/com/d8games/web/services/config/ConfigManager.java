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
    private static String officeIp;
    private static String locationOffice;
    private static String locationHome;
    private static String contactDepartmentName;
    private static String countryCode;
    private static int authenticationTimeout;

    private InputStream inputStream;

    public ConfigManager() throws IOException {
        Properties properties = getProperties();

        ConfigManager.officeIp = properties.getProperty("officeIp");
        ConfigManager.locationOffice = properties.getProperty("locationOffice");
        ConfigManager.locationHome = properties.getProperty("locationHome");
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

    public static String getLocationOffice() {
        return locationOffice;
    }

    public static String getLocationHome() {
        return locationHome;
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
