package core.pages;

import core.data.XpathList;
import core.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by bogat on 5/9/2016.
 */
public class EventPage extends AbstractPage {

    private String PAGE_URL;
    @FindBy(xpath = XpathList.EVENT_PAGE_EVENT_TITLE)
    private WebElement eventTitle;
    @FindBy(xpath = XpathList.EVENT_PAGE_EVENT_AUTHOR)
    private WebElement organizer;
    @FindBy(xpath = XpathList.EVENT_PAGE_EVENT_MENU_BUTTON)
    private WebElement eventMenuButton;
    @FindBy(xpath = XpathList.EVENT_PAGE_EVENT_DIALOG_DELETE_BUTTON)
    private WebElement confirmDeleteEventButton;

    private enum eventMenu {
        EDIT_EVENT,
        EDIT_GUESTS_LIST,
        REPEAT_EVENT,
        DELETE
    }

    public EventPage(WebDriver driver) {
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

    public String getEventTitle() {
        return eventTitle.getText();
    }

    public String getOrganizerName() {
        return organizer.getText();
    }

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public List<WebElement> getMenuItemsList() {
        return driver.findElements(By.xpath(XpathList.EVENT_PAGE_EVENT_MENU_ITEMS));
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setPAGE_URL(String PAGE_URL) {
        this.PAGE_URL = PAGE_URL;
    }

    /*************************************************************************************
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressEventMenuButton() {
        eventMenuButton.click();
    }

    public void pressMenuItem(String item) {
        List<WebElement> menuItemsList = getMenuItemsList();
        WebElement menuItem = menuItemsList.get(0);
        eventMenu menu = eventMenu.valueOf(item);
        switch (menu) {
            case EDIT_EVENT: {
                menuItem = menuItemsList.get(0);
                break;
            }
            case EDIT_GUESTS_LIST: {
                menuItem = menuItemsList.get(1);
                break;
            }
            case REPEAT_EVENT: {
                menuItem = menuItemsList.get(2);
                break;
            }
            case DELETE: {
                menuItem = menuItemsList.get(3);

            }
        }
        Utils.waitElementBeClickable(driver, menuItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(menuItem).build().perform();
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void pressConfirmDeleteEventButton() {
        confirmDeleteEventButton.click();
    }

}
