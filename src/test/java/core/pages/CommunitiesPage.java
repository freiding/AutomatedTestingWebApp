package core.pages;

import core.data.XpathList;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public List<WebElement> getRecomendedCommunitiesList() {
        return driver.findElements(By.xpath(XpathList.COMMUNITIES_PAGE_RECOMENDED_COMUNITIES));
    }

    public List<WebElement> getJoinedCommunitiesList() {
        return driver.findElements(By.xpath(XpathList.COMMUNITIES_PAGE_JOINED_COMMUNITIES));
    }

    public String getTitleRecomendedCommuniti(WebElement community) {
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
        String communityTitle = getTitleRecomendedCommuniti(community);
        community.findElement(By.xpath(XpathList.COMMUNITIES_PAGE_RECOMENDED_COMUNITY_JOIN_BUTTON))
                .click();
        Utils.waitElementBeClickable(driver, community.findElement(By.xpath(XpathList.COMMUNITIES_PAGE_RECOMENDED_COMUNITY_JOIN_BUTTON)));
        return communityTitle;
    }


}
