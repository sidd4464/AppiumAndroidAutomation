package com.appium.appium_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.ConfigureCapabilites;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.internal.Config;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AppiumBasics {

    protected AndroidDriver driver;
    protected AppiumDriverLocalService serviceBuilder;

    public static String getConfigFilePath() {
        String ConfigFilePath = "src/resources/Config.json";
        return ConfigFilePath;
    }

    public static String  getURL() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/resources/config.properties");
        properties.load(fileInputStream);
        String URL = properties.getProperty("URL");
        return URL;
    }

    public static String getServicePath() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/resources/config.properties");
        properties.load(fileInputStream);
        String servicePath = properties.getProperty("service_path");
        return servicePath;
    }

    public static String getIpAddress() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/resources/config.properties");
        properties.load(fileInputStream);
        String ipAddress = properties.getProperty("ipAddress");
        return ipAddress;
    }

    public static int getPortNum() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/resources/config.properties");
        properties.load(fileInputStream);
        return Integer.parseInt(properties.getProperty("port"));
    }

    public static String getAppPath() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/resources/config.properties");
        properties.load(fileInputStream);
        return properties.getProperty("App_Path");
    }



    @BeforeSuite(alwaysRun = true)
    public void appiumStart() {


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ConfigureCapabilites config = objectMapper.readValue(new File(getConfigFilePath()), ConfigureCapabilites.class);
            // Set Desired Capabilities
             serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File(getServicePath())).
                    withIPAddress(getIpAddress()).usingPort(getPortNum()).build();
            serviceBuilder.start();
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(config.getDeviceName());
            options.setApp(getAppPath());
            options.setAutomationName(config.getAutomationName());
            options.setNoReset(config.isNoReset());

             driver = new AndroidDriver(new URL(getURL()), options);
            if (driver.isDeviceLocked()) {
                driver.unlockDevice();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


            // Perform Actions (Example: Click a Button)
            System.out.println("App launched successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
            }

    @AfterSuite(alwaysRun = true)
    public void tearDown()
    {
            driver.quit();
            serviceBuilder.close();

    }


}




