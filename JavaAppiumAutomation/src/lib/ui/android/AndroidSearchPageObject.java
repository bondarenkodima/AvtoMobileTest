package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{
    static {
                SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";  //открытие поиска википедии
                SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";  //ввод текста в строку поиска
                SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn"; //очистка текста с поля ввода поиска
                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";   //ожидает элемент по ресурс ид и тексту из /* TEMPLATES METHODS */
                SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
                SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
                SEARCH_EMPTY_SEARCH = "xpath://*[contains(@text, 'Search and read the free encyclopedia in your language')]"; // поиск лейба Search and read the free encyclopedia in your language на странице
                SEARCH_RESULT_TITLE_ELEMENT = "id:org.wikipedia:id/page_list_item_title";
                SEARCH_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@text='{TITLE}']/following-sibling::*[@text='{DESCRIPTION}']"; //  TEMPLATES METHODS локатор тайтл + дескрипшен
    }

    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
