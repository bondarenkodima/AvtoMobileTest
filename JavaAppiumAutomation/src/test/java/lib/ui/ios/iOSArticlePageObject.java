package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        //OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        //OPTIONS_CHANGE_LANGUAGE_BUTTON = "xpath://*[@text= 'Change language']";
        //OPTIONS_SHARE_LINK_BUTTON = "xpath://*[@text= 'Share link']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        //ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        //MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        //MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        //WAIT_ARTICLE_TITLE = "id:org.wikipedia:id/item_container";
        //ARTICLE_IN_MY_LIST = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='scripting language']";
        //ARTICLE_TITLE = "xpath://*[@text='PHP']";
        ARTICLE_DESCRIPTION = "id:Scripting language"; //  дескрипшен
    }

    public iOSArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
