package core.pages;

import core.data.Constants;
import core.data.XpathList;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by bogat on 5/15/2016.
 */
public class CirclesPage extends AbstractPage {

    private static final String PAGE_URL = "https://plus.google.com/circles";

    public CirclesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        driver.navigate().to(PAGE_URL);
        init();
    }

    @Override
    public void init() {
        PageFactory.initElements(this.driver, this);
    }

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public List<WebElement> getCirclesList() {
        return driver.findElements(By.xpath(XpathList.CIRCLES_PAGE_CIRCLES));
    }
    public List<WebElement> getCirclesTitlesList() {
        return driver.findElements(By.xpath(XpathList.CIRCLES_PAGE_CIRCLES_TITLE));
    }

    public String getCircleText(int circleID) {
        if(circleID == Constants.LAST_ITEM_INDEX) {
            circleID = getCirclesTitlesList().size() - 1;
        }
        String circleTitle = getCirclesTitlesList()
                .get(circleID)
                .getText();
        return circleTitle;
    }

    public List<WebElement> getContactsList() {
        return driver.findElements(By.xpath(XpathList.CIRCLES_PAGE_CONTACT));
    }

    public int getNumberContactsInCircle(int circleID) {
        if(circleID == Constants.LAST_ITEM_INDEX) {
            circleID = getCirclesList().size() - 1;
        }
        return Integer.valueOf(getCirclesList()
                .get(circleID).
                findElement(By.xpath(XpathList.CIRCLES_PAGE_CIRCLE_CONTACTS_COUNTER))
                .getText());
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setContactSearchText(String username) {
        driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_ALLERT_DIALOG_INPUT))
                .sendKeys(username + Keys.ENTER);
    }

    public void setCircleTitle(String title) {
        driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_FRAME_CREATE_CIRCLE))
                .findElement(By.xpath(XpathList.CIRCLES_PAGE_FRAME_CREATE_CIRCLE_TITLE_TEXTBOX))
                .sendKeys(title);
    }

    /*************************************************************************************
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressCreateEmptyCircleButton() {
        driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_FRAME_CREATE_CIRCLE))
                .findElement(By.xpath(XpathList.CIRCLES_PAGE_FRAME_CREATE_CIRCLE_CREATE_BUTTON))
                .click();
        Utils.waitInisibilityElement(driver, By.xpath(XpathList.CIRCLES_PAGE_FRAME_CREATE_CIRCLE_CREATE_BUTTON));
    }

    public void pressNewCircleButton() {
        Utils.actionClickByElement(driver, driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_NEW_CIRCLE_BUTTON)));
    }

    public void pressDeleteCircleButton() {
        Utils.actionClickByElement(driver, driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_CIRCLE_DELETE_BUTTON)));
    }

    public void pressOnCircle(int circleNumber) {
        if(circleNumber == Constants.LAST_ITEM_INDEX) {
            circleNumber = getCirclesTitlesList().size() - 1;
        }
        WebElement circle = getCirclesTitlesList()
                .get(circleNumber);
        Utils.actionClickByElement(driver, circle);
    }

    public void pressConfirmDeleteCircleButton() {
        Utils.waitVisibilityElement(driver, driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_FRAME_CONFIRM_DELETE_CIRCLE)));
        driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_FRAME_CONFIRM_DELETE_CIRCLE_DELETE_BUTTON))
                .click();
    }

    public void pressAddContactButton() {
        driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_ADD_CONTACT_BUTTON))
                .click();
    }

    public void pressSaveContactAddingButton() {
        driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_ALLERT_DIALOG_SAVE_BUTTON))
                .click();
        Utils.waitVisibilityElement(driver, By.xpath(XpathList.CIRCLES_PAGE_CONTACT));
    }

    public void pressRemoveContactButton() {
        driver.findElement(By.xpath(XpathList.CIRCLES_PAGE_CONTACT_DELETE_BUTTON)).click();
        Utils.waitInisibilityElement(driver, By.xpath(XpathList.CIRCLES_PAGE_CONTACT_DELETE_BUTTON));
    }

    public void selectCircleToAdd(int circleID) {
        driver.findElements(By.xpath(XpathList.CIRCLES_PAGE_ALLERT_DIALOG_CIRCLES_LIST))
                .get(circleID)
                .click();
    }
}
