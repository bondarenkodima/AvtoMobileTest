package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListPageObject extends MainPageObject {

    public static final String
           FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
           ARTICLE_BY_TITLE_TPL = "//*[@text='{TITLE}']";

    private static String getFolderXpathByName(String name_of_folder) // заменяет значение константы FOLDER_BY_NAME_TPL на значение из name_of_folder
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title) // выдает xpath для статьи TPL
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)  // находим папку с названием "Learning programming" и кликаем по нему
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);   // для того что бы передавать правильный xpath
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath), //используем переменную которая через строку выше
                "Cannot find folder by name" + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title) // убеждаемся что статья присутствует
    {
        String article_xpath = getFolderXpathByName(article_title);   // для того что бы передавать правильный xpath
        this.waitForElementPresent(By.xpath(article_xpath), "Cannot find saved article by title" + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) // убеждаемся что статья удалилась
    {
        String article_xpath = getFolderXpathByName(article_title);   // для того что бы передавать правильный xpath
        this.waitForElementNotPresent(By.xpath(article_xpath), "Saved article still present with title" + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title)  // скролим элемент влево и сразуже идет проверка
    {
        this.waitForArticleToAppearByTitle(article_title);  // убеждаемся что статья присутствует
        String article_xpath = getFolderXpathByName(article_title);   // для того что бы передавать правильный xpath
        this.swipeElementToLeft(
                By.xpath(article_xpath),  //используем переменную которая через строку выше
                "Cannot find saved article"
        );
        this.waitForArticleToDisappearByTitle(article_title); //  убеждаемся что статья удалилась
    }

}
