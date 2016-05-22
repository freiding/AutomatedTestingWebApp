package core.pages;

import core.data.Constants;
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
    @FindBy(xpath = ".//span[@class='gb_P gb_R']")
    private WebElement usernameLabel;
    @FindBy(xpath = ".//div[@guidedhelpid='sharebox_textarea']")
    private WebElement postTextArea;
    @FindBy(xpath = ".//div[@guidedhelpid='sharebox_editor']//div[@role='textbox']")
    private WebElement messageField;
    @FindBy(xpath = ".//div[@guidedhelpid='sharebutton']")
    private WebElement buttonAddPost;
    @FindBy(xpath = ".//div[@class='ki ve']//div[@class='Ct']")
    private WebElement lastPostText;
    @FindBy(xpath = ".//div[@class='ki ve']//a[@class='ob tv Ub Hf']")
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
        Utils.waitInisibilityElement(driver, By.xpath(".//div[@guidedhelpid='sharebutton']"));
    }

    public void pressPostMenuItem(String item) {
        List<WebElement> menuItemsList = driver.findElements(By.xpath(".//div[@class='YH WD d-r']//div[@role='menuitem']"));
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
}

