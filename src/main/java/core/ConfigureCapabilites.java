package core;

import java.time.Duration;

public class ConfigureCapabilites {

    private String platformName;
    private String deviceName;
    private String udid;
    private String appPackage;
    private String appActivity;
    private boolean noReset;
    private String automationName;
    private boolean autoGrantPermissions;
    private String unlockType;
    private String unlockKey;
    private int newCommandTimeout;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
       this.deviceName = deviceName;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
       this.udid = udid;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
       this.appActivity = appActivity;
    }

    public boolean isNoReset() {
        return noReset;
    }

    public void setNoReset(boolean noReset) {
        this.noReset = noReset;
    }

    public String getAutomationName() {
        return automationName;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    public boolean isAutoGrantPermissions() {
        return autoGrantPermissions;
    }

    public void setAutoGrantPermissions(boolean autoGrantPermissions) {
       this.autoGrantPermissions = autoGrantPermissions;
    }

    public String getUnlockType() {
        return unlockType;
    }

    public void setUnlockType(String unlockType) {
        this.unlockType = unlockType;
    }

    public String getUnlockKey() {
        return unlockKey;
    }

    public void setUnlockKey(String unlockKey) {
        this.unlockKey = unlockKey;
    }

    public int getNewCommandTimeout() {
        return newCommandTimeout;
    }

    public void setNewCommandTimeout(int newCommandTimeout) {
        this.newCommandTimeout = newCommandTimeout;
    }

}
