package core.steps;

import core.objects.Post;
import core.objects.User;
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

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        driver.quit();
    }

    public void createNewEvent() {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
    }

    public void signIn(User user) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openPage();
        signInPage.signIn(user);
    }

    public boolean isLogged(User user) {
        StartPage startPage = new StartPage(driver);
        return startPage.getUsername().equals(user.getUsername());
    }

    public void deleteLastPost() {
        StartPage startPage = new StartPage(driver);
        startPage.pressPostMenuButton();
        startPage.pressPostMenuItemDelete();
    }

    public void addPost(Post post) {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.pressPostField();
        startPage.setMessageFieldText(post.getText());
        startPage.pressButtonAddPost();
        /*
        * need to add delete the added post, but it is not possible
        * to access the menu of the post due to the fact that it is hidden
        */
    }

    public boolean checkAddedPost(Post post) {
        StartPage startPage = new StartPage(driver);
        boolean authorAgreement = startPage.getLastPostAuthor().contains(post.getAuthor().getUsername());
        boolean textAgreement = startPage.getLastPostText().equals(post.getText());
        return authorAgreement == textAgreement;

    }
}
