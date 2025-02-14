package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.HashMap;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AppPageOne extends AppObjects {

    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Preference\"]")
    private WebElement PreferenceOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")
    private  WebElement preferenceListOption;

    @AndroidFindBy(id="android:id/checkbox")
    private WebElement preferenceCheckbox;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WiFi settings\")")
    private WebElement wifiSettings;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"android:id/edit\"]")
    private WebElement wifiInput;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertTitle;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okayBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"People Names\"]")
    private WebElement longPressElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]")
    private WebElement sampleMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Views\")")
    private WebElement views;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
    private  WebElement expandaleLists;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"1. Custom Adapter\")")
    private WebElement customAdapter;




    public AppPageOne() {
        initElements(this);
    }

    public void clickOnPrefernce() {
        PreferenceOption.click();
    }

    public void clickOnPreferenceOption() {
        preferenceListOption.click();
    }

    public void clickOnCheckBox() {
        preferenceCheckbox.click();
    }

    public void clickOnWifiSettings() {
        wifiSettings.click();
    }

    public void enterWifiSettings(String settings) {
        wifiInput.sendKeys(settings);
    }

    public String getAlertTitle() {
       return alertTitle.getText();
    }

    public void clickOnOkayButton() {
        okayBtn.click();
    }

    public void clickOnViews(){
        views.click();
    }

    public void clickOnExpandableLists() {
        expandaleLists.click();
    }

    public void ClickOnCustomAdapter(){
        customAdapter.click();
    }

    public void performLongPress() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Prepare the arguments for the long press
        HashMap<String, Object> longPressArgs = new HashMap<>();
        longPressArgs.put("action", "longPress");
        longPressArgs.put("elementId", ((RemoteWebElement) longPressElement).getId()); // Element to long press
        longPressArgs.put("duration", 2000);

        jsExecutor.executeScript("mobile: touchAndHold", longPressArgs);
        System.out.println("Long press performed successfully.");

    }

    public String getSampleMenuTest() {
        return sampleMenu.getText();
    }

    public void scrollToElement(String text) {
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

        System.out.println("Element found: " + element.getText());
    }














}
