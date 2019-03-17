package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class HomeworkEx18 extends CoreTestCase
{
    @Test
    public void testCheckTitleAndDescriptionTogether(){

          SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

          SearchPageObject.initSearchInput();  //открытие поиска википедии
          SearchPageObject.typeSearchLine("Java");
          assertTrue("Search found less than three results",
                SearchPageObject.checkSearchFoundSomeResults() >= 3);
          SearchPageObject.waitForElementByTitle("Java");
          SearchPageObject.waitForElementByTitle("Java (programming language)");
          SearchPageObject.waitForElementByTitle("JavaScript");
    }
}
