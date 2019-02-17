package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "//*[@text='View page in browser']",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_CHANGE_LANGUAGE_BUTTON = "//*[@text= 'Change language']",
            OPTIONS_SHARE_LINK_BUTTON = "//*[@text= 'Share link']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text= 'Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            WAIT_ARTICLE_TITLE = "org.wikipedia:id/item_container",
            ARTICLE_IN_MY_LIST = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='scripting language']",
            ARTICLE_TITLE = "//*[@text='PHP']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()  // ожидаем название статьи
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page!", 15);
    }

    public String getArticleTitle() // получаем название статьи
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }


    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder) // добавление статьи в мой список
    {
        this.waitForElementAndClick( // находим элемент "More options" и кликаем по нему
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                5
        );

        this.waitForElementPresent(  // выбираем элемент из списка поиска
                By.xpath(OPTIONS_CHANGE_LANGUAGE_BUTTON),
                "Cannot find options 'Change language'",
                5
        );

        this.waitForElementPresent(  // выбираем элемент из списка поиска
                By.xpath(OPTIONS_SHARE_LINK_BUTTON),
                "Cannot find options 'Share link'",
                5
        );

        this.waitForElementAndClick( // находим элемент "Add to reading list" и кликаем по нему
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find options 'Add to reading list'",
                5
        );

        this.waitForElementAndClick( // находим элемент "GOT IT" и кликаем по нему
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot find 'GOT IT' tip overlay",
                5
        );

        this.waitForElementAndClear(    //  очистка текста с поля ввода
                By.id(MY_LIST_NAME_INPUT),
                "Cannot find input to set name of articles folder",
               5
        );

        this.waitForElementAndSendKeys( // вводим новый текст в поле ввода
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick( // находим элемент "OK" и кликаем по нему
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                5
        );

    }

    public void waitArticleTitlePresent() // ждем появление элемента
     {
         this.waitForElementPresent(
                 By.id(WAIT_ARTICLE_TITLE),
                 "Cannot find article title",
                 5
         );
     }


    public void closeArticle()  // находим элемент "Navigate up" и кликаем по нему ЗАКРЫВАЕМ
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close article, cannot find X link",
                5
        );
    }

    public void addTwoArticleToMyList(String name_of_folder) // сохранение второй статьи в готовый список
    {
        this.waitForElementAndClick( // находим элемент "More options" и кликаем по нему
                  By.xpath(OPTIONS_BUTTON),
                  "Cannot find button to open article options",
                  5
        );

        this.waitForElementPresent(  // выбираем элемент из списка поиска
                  By.xpath(OPTIONS_CHANGE_LANGUAGE_BUTTON),
                  "Cannot find options 'Change language'",
                  5
        );

        this.waitForElementPresent(  // выбираем элемент из списка поиска
                  By.xpath(OPTIONS_SHARE_LINK_BUTTON),
                  "Cannot find options 'Share link'",
                  5
        );

        this.waitForElementAndClick( // находим элемент "Add to reading list" и кликаем по нему
                  By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                  "Cannot find options 'Add to reading list'",
                  5
        );
    }

    public void clickOnArticleInMyList() // клик по статье в моем списке
    {
        this.waitForElementAndClick( // находим статью в мое листе и кликаем по ней
                By.xpath(ARTICLE_IN_MY_LIST),
                "Cannot find article PHP 'Scripting language'",
                5
        );
    }

    public void checkArticleTitle() // проверяем title в открытой статье
    {
        this.waitForElementPresent(
                By.xpath(ARTICLE_TITLE),
                "Cannot find article title 'PHP'",
                5
        );
    }

}
