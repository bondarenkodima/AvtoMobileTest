package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class HomeworkEx9 extends CoreTestCase {

    @Test
    public void testAssertElementByTitleAndDescriptionPresent()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();  //открытие поиска википедии
        SearchPageObject.typeSearchLine("Java"); //ввод текста в строку поиска
        SearchPageObject.waitForElementByTitleAndDescription("Java", "Island of Indonesia");  // ожидаем элемент с тайтлом и дискрипшеном
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");  // ожидаем элемент с тайтлом и дискрипшеном
        SearchPageObject.waitForElementByTitleAndDescription("JavaScript", "Programming language");  // ожидаем элемент с тайтлом и дискрипшеном
    }
}
