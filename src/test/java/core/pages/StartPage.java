package core.pages;

import core.data.Constants;
import core.data.XpathList;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by bogat on 29.03.2016.
 */
public class StartPage extends AbstractPage {

    public final static String PAGE_URL = "https://www.plus.google.com";
    @FindBy(xpath = XpathList.START_PAGE_USERNAME_LABEL)
    private WebElement usernameLabel;
    @FindBy(xpath = XpathList.START_PAGE_POST_TEXT_AREA)
    private WebElement postTextArea;
    @FindBy(xpath = XpathList.START_PAGE_POST_MESSAGE_TEXT_FIELD)
    private WebElement messageField;
    @FindBy(xpath = XpathList.START_PAGE_DIALOG_POST_ADD_BUTTON)
    private WebElement buttonAddPost;
    @FindBy(xpath = XpathList.START_PAGE_LASTPOST_TEXT_LABEL)
    private WebElement lastPostText;
    @FindBy(xpath = XpathList.START_PAGE_LASTPOST_AUTHOR_LABEL)
    private WebElement lastPostAuthor;

    private enum postMenu {
        EDIT,
        DELETE,
        GET_LINK,
        EMBDED,
        IGNORE,
        DISSABLE_COMMENTS,
        BAN
    }

    public StartPage(WebDriver driver) {
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

    public String getUsername() {
        (new WebDriverWait(driver, Constants.TIMEOUT_VISIBILITY_OF))
                .until(ExpectedConditions.visibilityOf(usernameLabel));
        return usernameLabel.getText();
    }

    public String getLastPostAuthor() {
        return lastPostAuthor.getText();
    }

    public String getLastPostText() {
        return lastPostText.getText();
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setMessageFieldText(String message) {
        messageField.sendKeys(message);
        PageFactory.initElements(this.driver, this);
    }

    /*************************************************************************************
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressPostField() {
        postTextArea.click();
    }

    public void pressButtonAddPost() {
        buttonAddPost.click();
        Utils.waitInisibilityElement(driver, By.xpath(XpathList.START_PAGE_DIALOG_POST_ADD_BUTTON));
    }

    public void pressPostMenuButton() {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath(XpathList.START_PAGE_LASTPOST_MENU_BUTTON));
        Utils.waitVisibilityElement(driver, menu);
        menu.click();
        Utils.waitVisibilityElement(driver, By.xpath("//div[@class='YH WD d-r']"));
    }

    public void pressPostMenuItem(String item) {
        List<WebElement> menuItemsList = driver.findElements(By.xpath(XpathList.START_PAGE_POST_MENU_ITEMS));
        WebElement menuItem = menuItemsList.get(0);
        postMenu menu = postMenu.valueOf(item);
        switch (menu) {
            case EDIT: {
                menuItem = menuItemsList.get(0);
                break;
            }
            case DELETE: {
                menuItem = menuItemsList.get(1);
                break;
            }
            case GET_LINK: {
                menuItem = menuItemsList.get(2);
                break;
            }
            case EMBDED: {
                menuItem = menuItemsList.get(3);
                break;
            }
            case IGNORE: {
                menuItem = menuItemsList.get(4);
                break;
            }
            case DISSABLE_COMMENTS: {
                menuItem = menuItemsList.get(5);
                break;
            }
            case BAN: {
                menuItem = menuItemsList.get(6);
                break;
            }
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(menuItem).build().perform();
        actions.sendKeys(Keys.ENTER).click().build().perform();
    }

    public void pressConfirmDeletePost() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(XpathList.START_PAGE_CONFIRM_DIALOG_DELETE_BUTTON))).build().perform();
        actions.sendKeys(Keys.ENTER);
    }
}

