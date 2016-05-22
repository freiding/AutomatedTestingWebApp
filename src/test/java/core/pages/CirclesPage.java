package core.pages;

import core.data.Constants;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        return driver.findElements(By.xpath(".//div[@class='XCd']"));
    }
    public List<WebElement> getCirclesTitlesList() {
        return driver.findElements(By.xpath(".//div[@class='XCd']//span[@class='xMa uQa']"));
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
        return driver.findElements(By.xpath(".//div[@role='link']"));
    }

    public int getNumberContactsInCircle(int circleID) {
        if(circleID == Constants.LAST_ITEM_INDEX) {
            circleID = getCirclesList().size() - 1;
        }
        return Integer.valueOf(getCirclesList()
                .get(circleID).
                findElement(By.xpath(".//div[@class='uBc']"))
                .getText());
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setContactSearchText(String username) {
        driver.findElement(By.xpath(".//input[@class='fH r6a']"))
                .sendKeys(username + Keys.ENTER);
    }

    public void setCircleTitle(String title) {
        driver.findElement(By.xpath(".//div[@class='G-q o-LX-XUa oKb']//input[@class='t-xl-vc-oa t-xl-vc qKb']"))
                .sendKeys(title);
    }

    /*************************************************************************************
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressCreateEmptyCircleButton() {
        driver.findElement(By.xpath(".//div[@class='G-q o-LX-XUa oKb']//button[@name='save']"))
                .click();
        Utils.waitInisibilityElement(driver, By.xpath(".//div[@class='G-q o-LX-XUa oKb']//button[@name='save']"));
    }

    public void pressNewCircleButton() {
        Utils.actionClickByElement(driver, driver.findElement(By.xpath(".//div[@guidedhelpid='newcirclecircle']")));
    }

    public void pressDeleteCircleButton() {
        Utils.actionClickByElement(driver, driver.findElement(By.xpath(".//div[@class='Rna d-k-l oBb Rna']")));
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
        Utils.waitVisibilityElement(driver, driver.findElement(By.xpath(".//div[@class='G-q']")));
        driver.findElement(By.xpath(".//button[@name='ok']"))
                .click();
    }

    public void pressAddContactButton() {
        driver.findElement(By.xpath(".//div[text()='Add a person']"))
                .click();
    }

    public void pressSaveContactAddingButton() {
        driver.findElement(By.xpath(".//div[@class='HQ m6a']//div[text()='Save']"))
                .click();
        Utils.waitVisibilityElement(driver, By.xpath(".//div[@role='link']"));
    }

    public void pressRemoveContactButton() {
        driver.findElement(By.xpath(".//div[@class='bxa snb-u']")).click();
        Utils.waitInisibilityElement(driver, By.xpath(".//div[@class='bxa snb-u']"));
    }

    public void selectCircleToAdd(int circleID) {
        driver.findElements(By.xpath(".//div[@guidedhelpid='circlelist']//div[@class='bA kt']"))
                .get(circleID)
                .click();
    }
}
