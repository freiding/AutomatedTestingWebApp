package core.pages;

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
    @FindBy(xpath = ".//div[@role='article']//div[@class='jba']")
    private WebElement eventTitle;
    @FindBy(xpath = ".//a[@class='d-s ob Xi d-k-l']")
    private WebElement organizer;
    @FindBy(xpath = ".//div[@class='Ee fP Ue eZ']//div[@role='button']")
    private WebElement eventMenuButton;
    @FindBy(xpath = ".//button[text()='Delete event']")
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
        return driver.findElements(By.xpath(".//div[@role='menu']//div[@role='menuitem']"));
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
