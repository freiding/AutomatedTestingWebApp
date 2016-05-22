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

/**
 * Created by bogat on 5/9/2016.
 */
public class EventsPage extends AbstractPage {

    public static final String PAGE_URL = "https://plus.google.com/events";
    @FindBy(xpath = ".//div[@guidedhelpid='events_create_event_button']")
    private WebElement createEventButton;
    @FindBy(xpath = ".//input[@label='Event title']")
    private WebElement eventTitleInput;
    @FindBy(xpath = ".//input[@class='o-E-N TJ Pma']")
    private WebElement eventDateInput;
    @FindBy(xpath = ".//input[@class='o-E-N TJ dEa']")
    private WebElement eventTimeInput;
    @FindBy(xpath = ".//input[@label='Location (optional)']")
    private WebElement eventLocationInput;
    @FindBy(xpath = ".//div[@class='o-E-N Lea']//div[@role='textbox']")
    private WebElement eventDescriptionInput;
    @FindBy(xpath = ".//input[@aria-label='Invite names, circles, or email addresses']")
    private WebElement eventForWhomInput;
    @FindBy(xpath = ".//div[@guidedhelpid='sharebutton']")
    private WebElement eventInviteButton;

    public EventsPage(WebDriver driver) {
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

    public void setEventName(String name) {
        (new WebDriverWait(driver, Constants.TIMEOUT_VISIBILITY_OF))
                .until(ExpectedConditions.visibilityOf(eventTitleInput));
        eventTitleInput.clear();
        eventTitleInput.sendKeys(name);
    }

    public void setEventDate(core.objects.Date date) {
        Utils.clearWebElement(eventDateInput, Constants.TEXT_FIELD_LENGTH);
        eventDateInput.sendKeys(date.toString());
    }

    public void setEventTime(core.objects.Time time) {
        Utils.clearWebElement(eventTimeInput, Constants.TEXT_FIELD_LENGTH);
        eventTimeInput.sendKeys(time.toString());
    }

    public void setEventDescriotion(String description) {
        eventDescriptionInput.click();
        eventDescriptionInput.clear();
        eventDescriptionInput.sendKeys(description);
    }

    public void setEventLocation(String location) {
        eventLocationInput.click();
        eventLocationInput.clear();
        eventLocationInput.sendKeys(location);
    }

    public void setEventForFollowings(String forWhom) {
        eventForWhomInput.click();
        eventForWhomInput.sendKeys(forWhom);
        eventForWhomInput.sendKeys(Keys.ENTER);
    }

    /*************************************************************************************
     * *                                     Pressers                                     **
     *************************************************************************************/

    public void pressCreateEventButton() {
        createEventButton.click();
    }

    public void pressEventInviteButton() {
        eventInviteButton.click();
    }

    /*************************************************************************************
     * *                                     Actions                                     **
     *************************************************************************************/

    public EventPage openEventPage(String eventName) {
        String eventPageURL = driver.findElement(By.linkText(eventName)).getAttribute("href");
        EventPage eventPage = new EventPage(driver);
        eventPage.setPAGE_URL(eventPageURL);
        eventPage.openPage();
        return eventPage;
    }
}
