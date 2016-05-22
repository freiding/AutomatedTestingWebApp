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

import java.util.List;

/**
 * Created by bogat on 5/9/2016.
 */
public class CollectionPage extends AbstractPage {

    private String PAGE_URL;
    @FindBy(xpath = ".//span[@itemprop='name']")
    private WebElement collectionTitle;
    @FindBy(xpath = ".//a[@rel='author']")
    private WebElement collectionAuthor;
    @FindBy(xpath = ".//div[@class='FkKHNb']")
    private WebElement collectionDescription;
    @FindBy(xpath = ".//div[@aria-label='Collection settings']")
    private WebElement menuActionsWithCollection;
    @FindBy(xpath = ".//div[@class='WuGs8d']//div[@role='checkbox']")
    private WebElement deleteConfirmationCheckBox;
    @FindBy(xpath = ".//div[text()='Delete']")
    private WebElement deleteCollectionDialogButton;

    @FindBy(xpath = ".//div[@guidedhelpid='sharebox_textarea']")
    private WebElement postTextArea;
    @FindBy(xpath = ".//div[@guidedhelpid='sharebox_editor']//div[@role='textbox']")
    private WebElement dialogPostTextArea;
    @FindBy(xpath = ".//div[@guidedhelpid='sharebutton']")
    private WebElement dialogSharedPostButton;

    private enum collectionMenu {
        RENAME,
        DELETE
    }

    public CollectionPage(WebDriver driver) {
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

    public String getCollectionTitle() {
        return collectionTitle.getText();
    }

    public String getCollectionAuthor() {
        return collectionAuthor.getText();
    }

    public String getCollectionDescription() {
        return collectionDescription.getText();
    }

    public List<WebElement> getMenuItemsList() {
        return driver.findElements(By.xpath(".//div[@role='menu']//div[@role='menuitem']"));
    }

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public GPost getLastCollecionPost() {
        WebElement lastPost = driver.findElements(By.xpath(".//div[@role='article']//div[@class='ki ve']")).get(0);
        String[] postAuthor = lastPost.findElement(By.xpath("//a[@class='ob tv Ub Hf']")).getText().split(Constants.WORDS_SEPARATOR);
        String postText = lastPost.findElement(By.xpath("//div[@class='Al pf']//div[@class='Ct']")).getText();
        GUser author = new GUser();
        author.setName(postAuthor[0]);
        author.setSurname(postAuthor[1]);
        return new GPost(
                author,
                postText
        );
    }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setPAGE_URL(String PAGE_URL) {
        this.PAGE_URL = PAGE_URL;
    }

    public void setPostText(String postText) { this.dialogPostTextArea.sendKeys(postText); }


    /*************************************************************************************
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressMenuActionsWithCollection() {
        menuActionsWithCollection.click();
    }

    public void pressMenuItem(String item) {
        List<WebElement> menuItemsList = getMenuItemsList();
        collectionMenu menu = collectionMenu.valueOf(item);
        WebElement menuItem = menuItemsList.get(0);
        switch (menu) {
            case RENAME: {
                menuItem = menuItemsList.get(0);
                break;
            }
            case DELETE: {
                menuItem = menuItemsList.get(1);
            }
        }
        menuItem.click();
    }

    public void pressDeleteConfirmationCheckBox() {
        deleteConfirmationCheckBox.click();
    }

    public void pressDeleteCollectionDialogButton() {
        deleteCollectionDialogButton.click();
    }

    public void pressPostTextArea() { postTextArea.click(); }

    public void pressDialogSharedPostButton() {
        dialogSharedPostButton.click();
        (new WebDriverWait(driver, Constants.TIMEOUT_ELEMENT_BE_CLICKABLE))
                .until(ExpectedConditions.elementToBeClickable(postTextArea));
    }
}
