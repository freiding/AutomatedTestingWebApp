package core.pages;

import core.data.XpathList;
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
        driver.findElement(By.xpath(XpathList.COMMUNITIY_PAGE_MENU_SETTINGS_BUTTON)).click();
    }

    public void pressMenuSettingsItem(String menuItem) {
        List<WebElement> menuSettingsItems = driver.findElements(By.xpath(XpathList.COMMUNITIY_PAGE_MENU_SETTINGS_ITEMS));
        communityMenu menu = communityMenu.valueOf(menuItem);
        WebElement selectedMenuItem = menuSettingsItems.get(0);
        switch (menu) {
            case INVITE: {
                selectedMenuItem = menuSettingsItems.get(0);
                break;
            }
            case SHARE: {
                selectedMenuItem = menuSettingsItems.get(1);
                break;
            }
            case LEAVE: {
                selectedMenuItem = menuSettingsItems.get(2);
                break;
            }
            case REPORT: {
                selectedMenuItem = menuSettingsItems.get(3);
                break;
            }
            case DISPLAY_POSTS: {
                selectedMenuItem = menuSettingsItems.get(4);
                break;
            }
            case MORE: {
                selectedMenuItem = menuSettingsItems.get(5);
                break;
            }
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(selectedMenuItem).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void pressConfirmLeaveButton() {
        driver.findElement(By.xpath(XpathList.COMMUNITIY_PAGE_CONFIRM_LEAVE_FRAME_LEAVE_BUTTON)).click();
    }
}
