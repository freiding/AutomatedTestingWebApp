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
    public final static String EMAIL = "user5684931@gmail.com";
    public final static String PASSWORD = "password477100321";
    public final static String USERNAME = "Assistant";

    public void initBrowser() {
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
    }

    public void signIn () {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openPage();
        signInPage.signIn(EMAIL, PASSWORD);
    }

    public boolean isLogged(String username) {
        StartPage startPage = new StartPage(driver);
        return startPage.getUsername().equals(username);
    }

    public void addPost(String message) {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.pressPostField();
        startPage.setMessageFieldText(message);
    }
}
