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
    @FindBy(xpath = ".//*[@id='content']/div[2]/div[2]/div[1]/div/div[7]/a/div[2]")
    private WebElement eventsButton;
    @FindBy(xpath = ".//*[@id='content']/div[2]/div[2]/div[1]/div/div[6]/a/div[2]")
    private WebElement communitysButton;
    @FindBy(xpath = ".//*[@id='gb_70']")
    private WebElement signInButton;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(PAGE_URL);
    }

    public void pressSignInButton() {
        signInButton.click();
    }

    public void pressEventsButton() {
        eventsButton.click();
    }

    public void communitysButton() {
        communitysButton.click();
    }
}
