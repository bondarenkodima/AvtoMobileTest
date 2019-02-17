package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase
{
    @Test
    public void testChangeScreenOrientationOnSearchResults() // перевород устройства в ландшафтный и портретный режим
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();  //открытие поиска википедии
        SearchPageObject.typeSearchLine("Java"); //ввод текста в строку поиска
        SearchPageObject.clickByArticleWithSubString("Object-oriented programming language");  //клик по статье найденной по ресурс ид и тексту

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        String title_before_rotation = ArticlePageObject.getArticleTitle(); //записываем название статьи в переменнную,получаем название статьи

        this.rotateScreenLandscape(); // поворот телефона в ландшафт

        String title_after_rotation = ArticlePageObject.getArticleTitle(); //записываем название статьи в переменнную,получаем название статьи

        assertEquals(  //сравниваем два полученых значения (до поворота и после поворота телефона)
                "Article titlehave been change after screen rotation",
                title_before_rotation,
                title_after_rotation
        );

        this.rotateScreenPortrait() ; // поворот телефона в портрет

        String title_after_second_rotation = ArticlePageObject.getArticleTitle(); //записываем название статьи в переменнную,получаем название статьи

        assertEquals(  //сравниваем два полученых значения (до поворота и после поворота телефона)
                "Article titlehave been change after screen rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }

    @Test
    public void testCheckSearchArticleInBackground() // сворачивание и разворачивание приложения
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();  //открытие поиска википедии
        SearchPageObject.typeSearchLine("Java"); //ввод текста в строку поиска
        SearchPageObject.waitForSearchResult("Object-oriented programming language") ;   //ожидает элемент по ресурс ид и тексту

        this.backGroundApp(2); // отсылаем приложение в бекграунд, автоматически разворачивается

        SearchPageObject.waitForSearchResult("Object-oriented programming language") ;   // проверяем наличие нашей статьи
    }
}
