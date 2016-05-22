package core.pages;

import core.objects.GPost;
import core.objects.GUser;
import core.data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.data.TestData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogat on 5/3/2016.
 */
public class SearchPage extends AbstractPage {

    public static final String PAGE_URL = "https://plus.google.com/s/";

    @FindBy(xpath = ".//input[@aria-label='Search Google+']")
    private WebElement searchInputField;
    @FindBy(xpath = ".//button[@aria-label='Google Search']")
    private WebElement searchButton;
    @FindBy(xpath = ".//div[@guidedhelpid='search_header']//div[@class='Wzc ACd']")
    private WebElement searchTitle;


    public SearchPage(WebDriver driver) {
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

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public List<GPost> getListFoundItems() {
        List<WebElement> webElementsList = driver.findElements(By.xpath(".//div[@role='article']"));
        List<GPost> foundedArticles = new ArrayList<GPost>();
        for (WebElement item : webElementsList) {
            if (!foundedArticles.isEmpty()) {
                String[] author = item.findElement(By.xpath(".//a[@class='ob tv Ub Hf']")).getText().split(Constants.WORDS_SEPARATOR);
                String postText = item.findElement(By.className("Ct")).getText();
                GUser postAuthor = new GUser();
                if (author.length > 1) {
                    postAuthor.setName(author[0]);
                    postAuthor.setSurname(author[1]);
                }
                else {
                    postAuthor.setName(author[0]);
                }
                foundedArticles.add(new GPost(
                        postAuthor,
                        postText)
                );
            } else {
                List<WebElement> listPagesAndPeoples = item.findElements(By.xpath(".//a[@class='d-s ob Xi d-k-l']"));
                String textPost = Constants.EMPTY_STRING;
                for (WebElement page : listPagesAndPeoples) {
                    textPost += page.getText() + Constants.ROWS_SEPARATOR;
                }
                foundedArticles.add(new GPost(
                        new GUser(
                                Constants.DEFAULT_USER_NAME,
                                Constants.DEFAULT_USER_SURNAME,
                                Constants.DEFAULT_USER_EMAIL,
                                Constants.DEFAULT_USER_PASSWORD
                        ),
                        textPost
                    )
                );
            }
        }
        return foundedArticles;
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setSearchableText(String searchableText) {
        searchInputField.clear();
        searchInputField.sendKeys(searchableText);
    }
    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/
    public String getSearchTitle() {
        return searchTitle.getText();
    }

    /*************************************************************************************
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressSearchButton() {
        searchButton.click();
        (new WebDriverWait(driver, Constants.TIMEOUT_URL_CONTAINS))
                .until(ExpectedConditions.attributeContains(searchTitle, "title", TestData.SEARCH_TEXT));
    }
}
