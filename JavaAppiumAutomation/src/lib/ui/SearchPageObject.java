package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",  //открытие поиска википедии
            SEARCH_INPUT = "//*[contains(@text, 'Search…')]",  //ввод текста в строку поиска
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn", //очистка текста с поля ввода поиска
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",   //ожидает элемент по ресурс ид и тексту из /* TEMPLATES METHODS */
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results found']",
            SEARCH_EMPTY_SEARCH = "//*[contains(@text, 'Search and read the free encyclopedia in your language')]"; // поиск лейба Search and read the free encyclopedia in your language на странице

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);  // берем драйвер из MainPageObject
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void initSearchInput()    //находит поиск, кликает по нему и проверяет что Input есть
    {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
    }

    public void waitForCancelButtonToAppear()   // проверяем наличие кнопки Х ЗАКРЫТИЕ
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear()   // проверяем отсутствие кнопки Х ЗАКРЫТИЕ
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }

    public void clickCancelSearch()  // клик по кнопке Х ЗАКРЫТИЕ
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line)  //ввод текста в строку поиска
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line,"Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)   //ожидает элемент по ресурс ид и тексту
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring" + substring);
    }

    public void clickByArticleWithSubString(String substring)   //клик по статье найденной по ресурс ид и тексту
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring" + substring, 10);
    }

    public int getAmountOfFoundArticles()  // возвращает  кол-во статей (элементов) по  определенному xpath
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                " Cannot find anything by request ",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel()  // поиск лейба No results found на странице
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch()  // проверяем что в поиске нет ни одной статьи
    {
       this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed not to find any results");
    }

    public void waitForEmptyResultsLabe2()  // поиск лейба Search and read the free encyclopedia in your language на странице
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_SEARCH), "Cannot find empty result element", 15);
    }

}
