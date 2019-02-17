package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class HomeworkEx8_1 extends CoreTestCase
{
    @Test
    public void testCancelSearch()
{
    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();  //открытие поиска википедии
    SearchPageObject.typeSearchLine("Java"); //ввод текста в строку поиска
    SearchPageObject.waitForSearchResult("Object-oriented programming language");  //ожидает элемент по ресурс ид и тексту
    SearchPageObject.waitForSearchResult("Programming language");  //ожидает элемент по ресурс ид и тексту
    SearchPageObject.clickCancelSearch();   // клик по кнопке Х ЗАКРЫТИЕ
    SearchPageObject.waitForEmptyResultsLabe2();  // поиск лейба Search and read the free encyclopedia in your language на странице
    SearchPageObject.assertThereIsNoResultOfSearch();  // проверяем что в поиске нет ни одной статьи
}

}
