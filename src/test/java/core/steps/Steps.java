package core.steps;

import core.pages.SignInPage;
import core.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by bogat on 29.03.2016.
 */
public class Steps {

    private WebDriver driver;
    private final static String email = "user5684931@gmail.com";
    private final static String password = "password477100321";

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        driver.quit();
    }

    public void createNewEvent () {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.pressEventsButton();
    }
    public void signIn () {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openPage();
        signInPage.signIn(email,password);
    }
}
