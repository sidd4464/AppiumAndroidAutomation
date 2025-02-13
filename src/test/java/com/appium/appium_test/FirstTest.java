package com.appium.appium_test;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstTest extends AppiumBasics {



    @Test
    public void emulatorTest() {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("WifiSet");
        String AlertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals("WiFi settings",AlertTitle);
        driver.findElement(By.id("android:id/button1")).click();
    }
}
