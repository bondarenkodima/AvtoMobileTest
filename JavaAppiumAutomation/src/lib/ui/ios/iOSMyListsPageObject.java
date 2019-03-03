package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;

public class iOSMyListsPageObject extends MyListPageObject
{
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name='{TITLE}')]";
    }

    public iOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
