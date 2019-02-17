package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class HomeworkEx8_2 extends CoreTestCase
{
    @Test
    public void testSaveTwoArticlesToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();  //открытие поиска википедии
        SearchPageObject.typeSearchLine("Java"); //ввод текста в строку поиска
        SearchPageObject.clickByArticleWithSubString("Object-oriented programming language");  //клик по статье найденной по ресурс ид и тексту

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        ArticlePageObject.waitForTitleElement();   // выбираем элемент из списка поиска по заголовку
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming"; // описываем переменную один раз,что бы везде сама подставлялась
        ArticlePageObject.addArticleToMyList(name_of_folder); // передаем имя папки в которую будет добавляться статья
        ArticlePageObject.closeArticle();  // находим элемент "Navigate up" и кликаем по нему ЗАКРЫВАЕМ

        SearchPageObject.initSearchInput();  //открытие поиска википедии
        SearchPageObject.typeSearchLine("PHP"); //ввод текста в строку поиска
        SearchPageObject.clickByArticleWithSubString("Scripting language");  //клик по статье найденной по ресурс ид и тексту

        ArticlePageObject.addTwoArticleToMyList(name_of_folder); // ищем и добавляем вторую статью в мой список

        MyListPageObject MyListPageObject = new MyListPageObject(driver);

        MyListPageObject.openFolderByName(name_of_folder); // находим папку с названием "Learning programming" и кликаем по нему

        ArticlePageObject.closeArticle();  // находим элемент "Navigate up" и кликаем по нему ЗАКРЫВАЕМ

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();  // находим элемент "My lists" и кликаем по нему

        ArticlePageObject.waitArticleTitlePresent(); // ждем появление элемента

        MyListPageObject.openFolderByName(name_of_folder); // находим папку с названием "Learning programming" и кликаем по нему
        MyListPageObject.swipeByArticleToDelete(article_title);   // скролим элемент влево и сразуже идет проверка

        ArticlePageObject.clickOnArticleInMyList(); // клик по статье в моем списке
        ArticlePageObject.checkArticleTitle(); // проверяем title в открытой статье
    }
}