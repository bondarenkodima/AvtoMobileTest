package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        driver = new AndroidDriver(new URL(AppiumURL), capabilities);

        this.rotateScreenPortrait(); // девайс всегда будет переходить в портретный режим перед запуском теста
    }

    @Override
    protected void tearDown() throws Exception

    {
        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT); // делаем переворот в портретный режим
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE); // поворот телефона в ландшафтный режим
    }

    protected void backGroundApp(int seconds)
    {
        driver.runAppInBackground(seconds); // отсылаем приложение в бекграунд, автоматически разворачивается
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception  // получаем переменную среды которую создали Android
    {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(platform.equals(PLATFORM_ANDROID)) //если то подключаем для андроида
        {
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("deviceName","Redmi4x");
            capabilities.setCapability("platformVersion","7.1");
            capabilities.setCapability("automationName","Appium");
            capabilities.setCapability("appPackage","org.wikipedia");
            capabilities.setCapability("appActivity",".main.MainActivity");
            capabilities.setCapability("app","C:\\Users\\Кас\\Desktop\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");
        } else  if (platform.equals(PLATFORM_IOS))  // иначе используем капабилитис для ios
        {
            capabilities.setCapability("platformName","iOS");
            capabilities.setCapability("deviceName","iPhone 8 Plus");
            capabilities.setCapability("platformVersion","11.0");
            capabilities.setCapability("app","/Users/testers/Desktop/JavaAppiumAutomation/apks/wikipedia.app");
        } else  // если платформа не соответствует ни андроид ни ios
            {
                throw new Exception("Cannot ger run platform from env variable. Platform value" + platform);
            }
        return capabilities;
    }

}
