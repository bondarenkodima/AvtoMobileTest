package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static Platform instance;

    private Platform(){} // приватный конструктор

    public static Platform getInstance()
    {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public AppiumDriver getDriver() throws Exception // метод который отвечает за выбраный драйвер
    {
        URL URL = new URL(APPIUM_URL);
        if(this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredcCapabilities());
        } else if (this.isIOS()){
            return new IOSDriver(URL, this.getIOSDesiredcCapabilities());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value:" + this.getPlatformVar());
        }
    }

    public boolean isAndroid() // определяет является ли платформа Android
    {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS()  // определяет является ли платформа IOS
    {
        return isPlatform(PLATFORM_IOS);
    }


    private DesiredCapabilities getAndroidDesiredcCapabilities()  // capabilities для Android
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Redmi4x");
        capabilities.setCapability("platformVersion","7.1");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\Кас\\Desktop\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredcCapabilities() // capabilities для IOS
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("deviceName","iPhone 8 Plus");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("app","/Users/testers/Desktop/JavaAppiumAutomation/apks/wikipedia.app");
        return capabilities;
    }

    private boolean isPlatform(String my_platform)// сравнивание с переменной которая приходит на вход
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    private String getPlatformVar() // получение переменной окружения
    {
        return System.getenv("PLATFORM");
    }

}
