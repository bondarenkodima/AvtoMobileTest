package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomPageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase
{
    @Test
    public void testPassThroughWelcome()
    {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW())) { // если платформа Android или mobile web,то пропускаем тест. если ios то пропускаем стартовые страницы wikipedia
            return;
        }
        WelcomPageObject WelcomePage = new WelcomPageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWayToExplorerText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditPreferredLangText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDataCollectedText();
        WelcomePage.clickGetStartedButton();
    }
}
