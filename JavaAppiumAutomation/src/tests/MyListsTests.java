package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming"; // описываем переменную один раз,что бы везде сама подставлялась

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();  //открытие поиска википедии
        SearchPageObject.typeSearchLine("Java"); //ввод текста в строку поиска
        SearchPageObject.clickByArticleWithSubString("Object-oriented programming language");  //клик по статье найденной по ресурс ид и тексту

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();   // выбираем элемент из списка поиска по заголовку

        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder); // передаем имя папки в которую будет добавляться статья
        } else {
            ArticlePageObject.addArticlesToMySaved();  // сохранение статьи для ios
        }

        ArticlePageObject.closeArticle();  // находим элемент "Navigate up" и кликаем по нему ЗАКРЫВАЕМ

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();  // находим элемент "My lists" и кликаем по нему

        ArticlePageObject.waitArticleTitlePresent(); // ждем появление элемента

        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(name_of_folder); // находим папку с названием "Learning programming" и кликаем по нему
        }
        MyListPageObject.swipeByArticleToDelete(article_title);   // скролим элемент влево и сразуже идет проверка
    }
}
