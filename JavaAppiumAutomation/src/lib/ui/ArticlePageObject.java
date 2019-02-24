package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE = "id:org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
            OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
            OPTIONS_CHANGE_LANGUAGE_BUTTON = "xpath://*[@text= 'Change language']",
            OPTIONS_SHARE_LINK_BUTTON = "xpath://*[@text= 'Share link']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text= 'Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            WAIT_ARTICLE_TITLE = "id:org.wikipedia:id/item_container",
            ARTICLE_IN_MY_LIST = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='scripting language']",
            ARTICLE_TITLE = "xpath://*[@text='PHP']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()  // ожидаем название статьи
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }

    public String getArticleTitle() // получаем название статьи
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }


    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder) // добавление статьи в мой список
    {
        this.waitForElementAndClick( // находим элемент "More options" и кликаем по нему
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementPresent(  // выбираем элемент из списка поиска
                OPTIONS_CHANGE_LANGUAGE_BUTTON,
                "Cannot find options 'Change language'",
                5
        );

        this.waitForElementPresent(  // выбираем элемент из списка поиска
                OPTIONS_SHARE_LINK_BUTTON,
                "Cannot find options 'Share link'",
                5
        );

        this.waitForElementAndClick( // находим элемент "Add to reading list" и кликаем по нему
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options 'Add to reading list'",
                5
        );

        this.waitForElementAndClick( // находим элемент "GOT IT" и кликаем по нему
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'GOT IT' tip overlay",
                5
        );

        this.waitForElementAndClear(    //  очистка текста с поля ввода
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
               5
        );

        this.waitForElementAndSendKeys( // вводим новый текст в поле ввода
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick( // находим элемент "OK" и кликаем по нему
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );

    }

    public void waitArticleTitlePresent() // ждем появление элемента
     {
         this.waitForElementPresent(
                 WAIT_ARTICLE_TITLE,
                 "Cannot find article title",
                 5
         );
     }


    public void closeArticle()  // находим элемент "Navigate up" и кликаем по нему ЗАКРЫВАЕМ
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );
    }

    public void addTwoArticleToMyList(String name_of_folder) // сохранение второй статьи в готовый список
    {
        this.waitForElementAndClick( // находим элемент "More options" и кликаем по нему
                  OPTIONS_BUTTON,
                  "Cannot find button to open article options",
                  5
        );

        this.waitForElementPresent(  // выбираем элемент из списка поиска
                  OPTIONS_CHANGE_LANGUAGE_BUTTON,
                  "Cannot find options 'Change language'",
                  5
        );

        this.waitForElementPresent(  // выбираем элемент из списка поиска
                  OPTIONS_SHARE_LINK_BUTTON,
                  "Cannot find options 'Share link'",
                  5
        );

        this.waitForElementAndClick( // находим элемент "Add to reading list" и кликаем по нему
                  OPTIONS_ADD_TO_MY_LIST_BUTTON,
                  "Cannot find options 'Add to reading list'",
                  5
        );
    }

    public void clickOnArticleInMyList() // клик по статье в моем списке
    {
        this.waitForElementAndClick( // находим статью в мое листе и кликаем по ней
                ARTICLE_IN_MY_LIST,
                "Cannot find article PHP 'Scripting language'",
                5
        );
    }

    public void checkArticleTitle() // проверяем title в открытой статье
    {
        this.waitForElementPresent(
                ARTICLE_TITLE,
                "Cannot find article title 'PHP'",
                5
        );
    }

}
