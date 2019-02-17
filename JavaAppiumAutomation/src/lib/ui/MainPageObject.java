package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) // к этому конструктару обращаются все тесты
    {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new  WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n"); // с новой строки
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    public WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe)   // скрол страницы по y
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int  end_y = (int) (size.height * 0.2);
        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y).release()
                .perform();
    }

    public void swipeUpQuick() // метод для быстрого скрола
    {
        swipeUp(200);
    }

    public void  swipeUpToFindElement(By by, String error_message, int i)  // метод поиска всех элементов на странице
    {
        driver.findElements(by);  //поиск всех элементов на странице
        driver.findElements(by).size(); // вывод количества найденых элементов

        while (driver.findElements(by).size() == 0){  // цикл который ищит элементы
            swipeUpQuick();
        }
    }

    public void swipeElementToLeft(By by, String error_message) // скрол элемента влево по оси Х
    {
        WebElement element = waitForElementPresent( // находим элемент на странице
                by,
                error_message,
                10);
        int left_x = element.getLocation().getX(); //записует самую левую точку элемента по оси Х
        int right_x = left_x + element.getSize().getWidth(); // получаем точку а правой границы экрана
        int upper_y = element.getLocation().getY(); //
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2; // находим середину элемента

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }

    public int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();//  возврашаем кол-во которые были найдены при помощи функции driver.findElements
    }

    public void assertElementNotPresent(By by, String error_message) // проверяем что в поиске нет ни одной статьи
    {
        int amount_of_elements = getAmountOfElements(by); // вычисляем кол-во элементов по xpath
        if (amount_of_elements > 0) { //проверка если их больше 0
            String default_message = "' An element '" + by.toString() + " supposed to be present "; // формируем строку с присутствующим элементом (если он есть)
            throw new AssertionError(default_message + "" +error_message); // выдаем сообщение
        }
    }

    public String waitForElementAndGetAtribute(By by, String attribute, String error_message, long timeoutInSeconds) // получаем заголов статьи
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }
}
