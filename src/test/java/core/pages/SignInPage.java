package core.pages;

import core.objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bogat on 29.03.2016.
 */
public class SignInPage extends AbstractPage {

    public final static String PAGE_URL = "https://accounts.google.com/ServiceLogin#identifier";
    @FindBy(xpath = ".//*[@id='Email']")
    private WebElement emailTextField;
    @FindBy(xpath = ".//*[@id='Passwd']")
    private WebElement passwordTextField;
    @FindBy(xpath = ".//*[@id='next']")
    private WebElement nextButton;
    @FindBy(xpath = ".//*[@id='signIn']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        driver.navigate().to(PAGE_URL);
        PageFactory.initElements(this.driver, this);
    }

    public void signIn(User user) {
        emailTextField.sendKeys(user.getEmail());
        nextButton.click();
        passwordTextField.sendKeys(user.getPassword());
        signInButton.click();
    }
}
