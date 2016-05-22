package core.pages;

import core.data.Constants;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by bogat on 5/15/2016.
 */
public class CommunitiesPage extends AbstractPage {

    private static final String PAGE_URL = "https://plus.google.com/communities";
    @FindBy(xpath = ".//div[@role='list']//div[@class='UYd oEd']")
    private WebElement joinedCommunitiesList;
    @FindBy(xpath = ".//input[@label='Search for communities']")
    private WebElement searchCommunitisField;
    public CommunitiesPage(WebDriver driver) {
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

    public boolean pageIsAlreadyOpen() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

    public void openJoinedCommunity(String title) {
        joinedCommunitiesList.findElement(By.linkText(title)).click();
        Utils.waitInisibilityElement(driver, By.xpath(".//input[@label='Search for communities']"));
    }

    public void refreshPage() {
        driver.navigate().refresh();
        init();
    }

    public void setSearchCommunityText(String title) {
        searchCommunitisField.sendKeys(title + Keys.ENTER);
        Utils.waitInisibilityElement(driver, By.xpath(".//input[@label='Search for communities']"));
    }
    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public List<WebElement> getFoundedCommunitiesList() {
        return driver.findElements(By.xpath(".//div[@role='article']"));
    }

    public List<WebElement> getJoinedCommunitiesList() {
        return driver.findElements(By.xpath(".//div[@class='k9c mke Pic I8c JUKJAb']"));
    }

    public String getTitleFoundedCommunity(WebElement community) {
        return community.findElement(By.xpath("//div[@class='hDc']"))
                .getText();
    }

    public String getJoinToCommunityButtonText(WebElement community) {
        return community.findElement(By.xpath(".//span[@guidedhelpid='community_join_button']")).getText();
    }

    public String getTitleJoinedCommunity(WebElement community) {
        return community.findElement(By.xpath("//a[@class='d-s ob w1d ATc']"))
                .getText();
    }

    /*************************************************************************************
     * *                                     Pressers                                   **
     *************************************************************************************/

    public String pressJoinToCommunityButton(WebElement community) {
        String communityTitle = getTitleFoundedCommunity(community);
        WebElement joinButton = community.findElement(By.xpath("//span[@guidedhelpid='community_join_button']"));
        joinButton.click();
        (new WebDriverWait(driver, Constants.TIMEOUT_ELEMENT_BE_CLICKABLE))
                .until(ExpectedConditions.textToBePresentInElement(joinButton, "View"));
        return communityTitle;
    }


}
