package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class HomeworkEx12 extends CoreTestCase
{
      @Test
    public void testCheckTitleAndDescriptionTogether(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        assertTrue("Search found less than three results",
                searchPageObject.checkSearchFoundSomeResults()  >= 3);
        searchPageObject.waitForElementByTitleAndDescription("Java","Island of Indonesia");
        searchPageObject.waitForElementByTitleAndDescription("Java (programming language)","Object-oriented programming language");
        searchPageObject.waitForElementByTitleAndDescription("JavaScript","Programming language");
    }
}
