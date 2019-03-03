package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{

    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia')]";  //открытие поиска википедии
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia')]";  //ввод текста в строку поиска
        SEARCH_CANCEL_BUTTON = "id:Close"; //очистка текста с поля ввода поиска
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";   //ожидает элемент по ресурс ид и тексту из /* TEMPLATES METHODS */
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_RESULT_TITLE_ELEMENT = "id:org.wikipedia:id/page_list_item_title";
        //SEARCH_EMPTY_SEARCH = "xpath://*[contains(@text, 'Search and read the free encyclopedia in your language')]"; // поиск лейба Search and read the free encyclopedia in your language на странице
        //SEARCH_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@text='{TITLE}']/following-sibling::*[@text='{DESCRIPTION}']"; //  TEMPLATES METHODS локатор тайтл + дескрипшен
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
