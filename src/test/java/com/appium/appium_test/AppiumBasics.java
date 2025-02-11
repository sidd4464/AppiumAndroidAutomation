package com.appium.appium_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.ConfigureCapabilites;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.internal.Config;
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

    @BeforeSuite(alwaysRun = true)
    public void appiumStart() {
         driver = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ConfigureCapabilites config = objectMapper.readValue(new File(getConfigFilePath()), ConfigureCapabilites.class);
            // Set Desired Capabilities
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName(config.getPlatformName());
            options.setDeviceName(config.getDeviceName());  // Replace with your device name
            options.setUdid(config.getUdid());  // Replace with your device's UDID
            options.setAppPackage(config.getAppPackage());
            options.setAppActivity(config.getAppActivity());
            options.setNoReset(config.isNoReset());  // Prevent reinstalling the app
            options.setAutomationName(config.getAutomationName());
            options.setNoReset(!config.isNoReset()); // Ensure app resets between tests
            options.setAutoGrantPermissions(config.isAutoGrantPermissions()); // Auto-grant permissions
            options.setUnlockType(config.getUnlockType()); // Unlock type (e.g., PIN, password, pattern)
            options.setUnlockKey(config.getUnlockKey()); // Unlock key for the phone
            options.setNewCommandTimeout(Duration.ofSeconds(config.getNewCommandTimeout()));

             driver = new AndroidDriver(new URL(getURL()), options);
            if (driver.isDeviceLocked()) {
                driver.unlockDevice();
            }
             driver.activateApp("com.androidsample.generalstore");
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


            // Perform Actions (Example: Click a Button)
            System.out.println("App launched successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
            }

    @AfterSuite
    public void tearDown()
    {
            driver.quit();
    }


}




