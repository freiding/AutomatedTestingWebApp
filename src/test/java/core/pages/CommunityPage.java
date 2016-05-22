package core.pages;

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
public class CommunityPage extends AbstractPage {

    public static String PAGE_URL;
    private enum communityMenu {
        INVITE,
        SHARE,
        LEAVE,
        REPORT,
        DISPLAY_POSTS,
        MORE
    }

    public CommunityPage(WebDriver driver) {
        super(driver);
        PAGE_URL = driver.getCurrentUrl();
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
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressMenuSettingsButton() {
        WebElement menuButton = driver.findElement(By.xpath(".//div[@class='d-y-r-c-ha fjzDZe']//div[@class='RY']"));
        menuButton.click();
    }

    public void pressMenuSettingsItem(String menuItem) {
        communityMenu menu = communityMenu.valueOf(menuItem);
        Utils.waitVisibilityElement(driver, By.xpath(".//div[@class='d-r d-r-ih']//div[@role='menuitem']"));
        List<WebElement> communityMenuItems = driver.findElements(By.xpath(".//div[@class='d-r d-r-ih']//div[@role='menuitem']"));
        WebElement selectedMenuItem = communityMenuItems.get(0);
        switch (menu) {
            case INVITE: {
                selectedMenuItem = communityMenuItems.get(0);
                break;
            }
            case SHARE: {
                selectedMenuItem = communityMenuItems.get(1);
                break;
            }
            case LEAVE: {
                selectedMenuItem = communityMenuItems.get(2);
                break;
            }
            case REPORT: {
                selectedMenuItem = communityMenuItems.get(3);
                break;
            }
            case DISPLAY_POSTS: {
                selectedMenuItem = communityMenuItems.get(4);
                break;
            }
            case MORE: {
                selectedMenuItem = communityMenuItems.get(5);
                break;
            }
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(selectedMenuItem).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void pressConfirmLeaveButton() {
        Utils.waitVisibilityElement(driver, By.xpath(".//button[text()='Leave community']"));
        driver.findElement(By.xpath(".//button[text()='Leave community']")).click();
    }
}
