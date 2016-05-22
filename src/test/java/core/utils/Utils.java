package core.utils;

import core.data.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bogat on 5/9/2016.
 */
public class Utils {

    public static void clearWebElement(WebElement webElement, int length) {
        for (int i = 0; i < length ; i++) { // Bad practice
            webElement.sendKeys(Keys.BACK_SPACE);
        }
    }

    public static void waitElementBeClickable(WebDriver driver, WebElement element) {
        (new WebDriverWait(driver, Constants.TIMEOUT_ELEMENT_BE_CLICKABLE))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitVisibilityElement(WebDriver driver, WebElement element) {
        (new WebDriverWait(driver, Constants.TIMEOUT_VISIBILITY_OF))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitVisibilityElement(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        (new WebDriverWait(driver, Constants.TIMEOUT_VISIBILITY_OF))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitInisibilityElement(WebDriver driver, By locator) {
        (new WebDriverWait(driver, Constants.TIMEOUT_INVISIBILITY_OF))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void actionClickByElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        actions.click().build().perform();
    }
}
