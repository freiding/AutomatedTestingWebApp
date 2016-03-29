package core.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by bogat on 29.03.2016.
 */
public abstract class AbstractPage {

    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
