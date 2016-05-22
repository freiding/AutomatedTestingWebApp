package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bogat on 5/9/2016.
 */
public class CollectionsPage extends AbstractPage {

    public static final String PAGE_URL = "https://plus.google.com/collections";

    @FindBy(xpath = ".//div[text()='CREATE A COLLECTION']")
    private WebElement createCollectionButton;
    @FindBy(xpath = ".//input[@aria-label='Name']")
    private WebElement collectionNameInput;
    @FindBy(xpath = ".//input[@aria-label='Tagline (optional)']")
    private WebElement collectionDescriptionInput;
    @FindBy(xpath = ".//div[@class='G-q-ea']//div[text()='Create']")
    private WebElement collectionCreateButton;

    public CollectionsPage(WebDriver driver) {
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
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setCollectionName(String name) {
        collectionNameInput.clear();
        collectionNameInput.sendKeys(name);
    }

    public void setCollectionDescription(String description) {
        collectionDescriptionInput.clear();
        collectionDescriptionInput.sendKeys(description);
    }

    /*************************************************************************************
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressCreateCollectionButton() {
        createCollectionButton.click();
    }

    public void pressCollectionCreateButton() {
        collectionCreateButton.click();
    }

    /*************************************************************************************
     * *                                     Actions                                     **
     *************************************************************************************/

    public CollectionPage openCollection(String collectionTitle) {
        CollectionsPage collectionsPage = new CollectionsPage(driver);
        collectionsPage.openPage();
        String collectionPageURL = driver.findElement(By.linkText(collectionTitle)).getAttribute("href");
        System.out.println(collectionPageURL);
        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.setPAGE_URL(collectionPageURL);
        collectionPage.openPage();
        return collectionPage;
    }
}
