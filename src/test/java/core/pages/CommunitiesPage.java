package core.pages;

import core.data.Constants;
import core.data.XpathList;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by bogat on 5/15/2016.
 */
public class CommunitiesPage extends AbstractPage {

    private static final String PAGE_URL = "https://plus.google.com/communities";

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
        driver.findElement(By.xpath(XpathList.COMMUNITIES_PAGE_JOINED_COMMUNITIES))
                .findElement(By.linkText(title))
                .click();
    }

    public void refreshPage() {
        driver.navigate().refresh();
        init();
    }

    public void setSearchCommunityText(String title) {
        driver.findElement(By.xpath(XpathList.COMMUNITIES_PAGE_SEARCH_COMMUNITY_TEXTBOX))
                .sendKeys(title + Keys.ENTER);
        Utils.waitInisibilityElement(driver, By.xpath(XpathList.COMMUNITIES_PAGE_SEARCH_COMMUNITY_TEXTBOX));
    }
    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public List<WebElement> getFoundedCommunitiesList() {
        return driver.findElements(By.xpath(XpathList.COMMUNITIES_PAGE_RECOMENDED_COMUNITIES));
    }

    public List<WebElement> getJoinedCommunitiesList() {
        return driver.findElements(By.xpath(XpathList.COMMUNITIES_PAGE_JOINED_COMMUNITIES));
    }

    public String getTitleFoundedCommunity(WebElement community) {
        return community.findElement(By.xpath(XpathList.COMMUNITIES_PAGE_RECOMENDED_COMUNITY_TITLE))
                .getText();
    }

    public String getTitleJoinedCommunity(WebElement community) {
        return community.findElement(By.xpath(XpathList.COMMUNITIES_PAGE_JOINED_COMMUNITY_TITLE))
                .getText();
    }

    /*************************************************************************************
     * *                                     Pressers                                   **
     *************************************************************************************/

    public String pressJoinToCommunityButton(WebElement community) {
        Utils.scrollToElement(driver, community);
        String communityTitle = getTitleFoundedCommunity(community);
        WebElement joinButton = community.findElement(By.xpath(XpathList.COMMUNITIES_PAGE_RECOMENDED_COMUNITY_JOIN_BUTTON));
        joinButton.click();
        (new WebDriverWait(driver, Constants.TIMEOUT_ELEMENT_BE_CLICKABLE))
                .until(ExpectedConditions.textToBe(By.xpath(XpathList.COMMUNITIES_PAGE_RECOMENDED_COMUNITY_JOIN_BUTTON), "Взглянуть"));
        return communityTitle;
    }


}
