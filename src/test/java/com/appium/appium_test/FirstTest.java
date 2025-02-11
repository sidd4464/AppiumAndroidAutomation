package com.appium.appium_test;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstTest extends AppiumBasics {

    @Test
    public void firstTest() {
        ArrayList<String> productNames = new ArrayList<String>();
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("John");
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        List<WebElement> products = driver.findElements(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.TextView\")"));

        for(WebElement product:products) {
            productNames.add(product.getText());
        }

        for(String productName:productNames) {
            System.out.println(productName);
        }
    }
}
