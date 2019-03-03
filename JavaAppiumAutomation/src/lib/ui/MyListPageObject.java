package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListPageObject extends MainPageObject {

    protected static String
           FOLDER_BY_NAME_TPL,
           ARTICLE_BY_TITLE_TPL;

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
                folder_name_xpath, //используем переменную которая через строку выше
                "Cannot find folder by name" + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title) // убеждаемся что статья присутствует
    {
        String article_xpath = getFolderXpathByName(article_title);   // для того что бы передавать правильный xpath
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title" + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) // убеждаемся что статья удалилась
    {
        String article_xpath = getFolderXpathByName(article_title);   // для того что бы передавать правильный xpath
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title" + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title)  // скролим элемент влево и сразуже идет проверка
    {
        this.waitForArticleToAppearByTitle(article_title);  // убеждаемся что статья присутствует
        String article_xpath = getFolderXpathByName(article_title);   // для того что бы передавать правильный xpath
        this.swipeElementToLeft(
                article_xpath,  //используем переменную которая через строку выше
                "Cannot find saved article"
        );

        if (Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        this.waitForArticleToDisappearByTitle(article_title); //  убеждаемся что статья удалилась
    }

}
