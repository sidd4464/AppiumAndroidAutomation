package com.appium.appium_test;

import Pages.AppObjects;
import Pages.AppPageOne;
import com.beust.ah.A;
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
        pageOne.clickOnPrefernce();
        pageOne.clickOnPreferenceOption();
        pageOne.clickOnCheckBox();
        pageOne.clickOnWifiSettings();
        Assert.assertEquals(pageOne.getAlertTitle(),"WiFi settings");
        pageOne.enterWifiSettings("Settings");
        pageOne.clickOnOkayButton();
    }

    @Test
    public static void longPressCheck(){
        pageOne.scrollToElement("Views");
        pageOne.clickOnViews();
        pageOne.clickOnExpandableLists();
        pageOne.ClickOnCustomAdapter();
        pageOne.performLongPress();
        Assert.assertEquals(pageOne.getSampleMenuTest(),"Sample menu");

    }


}


