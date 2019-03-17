package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";  //открытие поиска википедии
        SEARCH_INPUT = "css:form>input[type='search']";  //ввод текста в строку поиска
        SEARCH_CANCEL_BUTTON = "css:button.cancel"; //очистка текста с поля ввода поиска
        //SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[contains(@text, 'Object-oriented programming language')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";   //ожидает элемент по ресурс ид и тексту из /* TEMPLATES METHODS */
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary"; // страница результатов поиска ДОМ
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";  // когда поиск ничего не нашел
        SEARCH_RESULT_TITLE_ELEMENT ="css:body > div.overlay.search-overlay.visible > div.overlay-content";
         //SEARCH_RESULT_TITLE_ELEMENT = "id:org.wikipedia:id/page_list_item_title";
        //SEARCH_EMPTY_SEARCH = "xpath://*[contains(@text, 'Search and read the free encyclopedia in your language')]"; // поиск лейба Search and read the free encyclopedia in your language на странице
        //SEARCH_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@text='{TITLE}']/following-sibling::*[@text='{DESCRIPTION}']"; //  TEMPLATES METHODS локатор тайтл + дескрипшен
    }

    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}

