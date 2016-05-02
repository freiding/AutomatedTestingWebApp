package core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bogat on 29.03.2016.
 */
public class StartPage extends AbstractPage {

    public final static String PAGE_URL = "https://www.plus.google.com";
    @FindBy(xpath = ".//*[@id='gb']/div[1]/div[1]/div[1]/div/span")
    private WebElement usernameLabel;
    @FindBy(xpath = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[1]/div/div/div[1]/div[2]")
    private WebElement postField;
    @FindBy(xpath = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[1]/div/div[2]/div[1]/div[7]/div[2]/div[2]/div/div[2]/div[2]")
    private WebElement messageField;
    @FindBy(xpath = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr/td[1]/div[1]")
    private WebElement buttonAddPost;
    @FindBy(xpath = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div[2]")
    private WebElement lastPostText;
    @FindBy(xpath = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div/header/h3/a")
    private WebElement lastPostAuthor;
    @FindBy(xpath = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[1]/span")
    private WebElement postMenuButton;
    @FindBy(xpath = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div")
    private WebElement postMenuItemDelete;

    //  .//*[@id=':5v']/div
    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(PAGE_URL);
    }

    /************************************************
     * Pressers
     ************************************************/

    public void pressPostField() {
        postField.click();
    }

    public void pressButtonAddPost() {
        buttonAddPost.click();
    }

    public void pressPostMenuButton() {
        postMenuButton.click();
    }

    public void pressPostMenuItemDelete() {
        postMenuItemDelete.click();
    }

    /************************************************
     * Getters
     ************************************************/
    public String getUsername() {
        return usernameLabel.getText();
    }

    public String getLastPostAuthor() {
        return lastPostAuthor.getText();
    }

    public String getLastPostText() {
        return lastPostText.getText();
    }

    /************************************************
     * Setters
     ************************************************/

    public void setMessageFieldText(String message) {
        messageField.sendKeys(message);
        PageFactory.initElements(this.driver, this);
    }
}
