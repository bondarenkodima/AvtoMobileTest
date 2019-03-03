package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomPageObject;
import org.openqa.selenium.ScreenOrientation;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        driver = Platform.getInstance().getDriver();

        this.rotateScreenPortrait(); // девайс всегда будет переходить в портретный режим перед запуском теста
        this.skipeWelcomePageForIOSApp(); // клик по кнопке skip
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

    private void skipeWelcomePageForIOSApp()
    {
        if(Platform.getInstance().isIOS()) {
            WelcomPageObject WelcomPageObject = new WelcomPageObject(driver);
            WelcomPageObject.clickSkip();
        }
    }

}
