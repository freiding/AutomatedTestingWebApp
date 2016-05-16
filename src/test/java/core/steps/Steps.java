package core.steps;

import core.data.Constants;
import core.data.XpathList;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import core.data.TestData;
import core.objects.GCollection;
import core.objects.GEvent;
import core.objects.GUser;
import core.objects.GPost;
import core.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by bogat on 29.03.2016.
 */
public class Steps {

    private WebDriver driver;
    WebDriverWait wait;

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Constants.TIMEOUT_PAGELOAD, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void closeDriver() {
        driver.quit();
    }

    /*************************************************************************************
     **                           SIGN IN STEPS                                         **
     *************************************************************************************/

    public void signIn(GUser GUser) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openPage();
        signInPage.signIn(GUser);
    }

    public boolean isLogged(GUser GUser) {
        StartPage startPage = new StartPage(driver);
        startPage.init();
        return startPage.getUsername().equals(GUser.getName());
    }

    /*************************************************************************************
     **                           STEPS FOR WORKING WITH POSTS                          **
     *************************************************************************************/

    public void openStartPage() {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
    }

    public void addPost(GPost GPost) {
        StartPage startPage = new StartPage(driver);
        startPage.init();
        startPage.pressPostField();
        startPage.setMessageFieldText(GPost.getText());
        startPage.pressButtonAddPost();
    }

    public boolean isPostCreated(GPost gPost) {
        StartPage startPage = new StartPage(driver);
        startPage.init();
        boolean authorAgreement = startPage.getLastPostAuthor().contains(gPost.getAuthor().getName());
        boolean textAgreement = startPage.getLastPostText().equals(gPost.getText());
        return authorAgreement == textAgreement;
    }

    public void deleteLastPost() {
        StartPage startPage = new StartPage(driver);
        startPage.pressPostMenuButton();
        startPage.pressPostMenuItem(Constants.ALIAS_MENU_ITEM_DELETE);
        startPage.pressConfirmDeletePost();
    }

    /*************************************************************************************
     **                           STEPS FOR WORKING WITH SEARCH                         **
     *************************************************************************************/

    public void openSearchPage() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.openPage();
    }

    public void searchPosts(String searchableText) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.init();
        searchPage.setSearchableText(searchableText);
        searchPage.pressSearchButton();
    }

    public boolean isSearchCorrect(String searchableText) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.init();
        return searchableText.equals(searchPage.getSearchTitle());
    }

    /**************************************************************************************
     **                           STEPS FOR WORKING WITH EVENTS                          **
     *************************************************************************************/

    public void openEventsPage() {
        EventsPage eventsPage = new EventsPage(driver);
        eventsPage.openPage();
    }

    public void createEvent(GEvent gEvent) {
        EventsPage eventsPage = new EventsPage(driver);
        eventsPage.init();
        eventsPage.pressCreateEventButton();
        eventsPage.setEventName(gEvent.getTitle());
        eventsPage.setEventDate(gEvent.getDate());
        eventsPage.setEventTime(gEvent.getTime());
        //eventsPage.setEventLocation(gEvent.getLocation());
        //eventsPage.setEventDescriotion(gEvent.getDescription());
        eventsPage.setEventForFollowings(gEvent.getForWhom());
        eventsPage.pressEventInviteButton();
        (new WebDriverWait(driver, Constants.TIMEOUT_TITLE_CONTAINS))
                .until(ExpectedConditions.titleContains(gEvent.getTitle()));
    }

    public boolean isEventCreated(GEvent gEvent){
        EventPage eventPage = new EventPage(driver);
        eventPage.init();
        boolean eventNameIsRight = eventPage.getEventTitle().startsWith(gEvent.getTitle());
        boolean eventOrganaizerIsRight = eventPage.getOrganizerName().contains(TestData.USER_NAME);
        return eventNameIsRight == eventOrganaizerIsRight;
    }

    public void deleteEvent(){
        EventPage eventPage = new EventPage(driver);
        eventPage.init();
        eventPage.pressEventMenuButton();
        eventPage.pressMenuItem(Constants.ALIAS_MENU_ITEM_DELETE);
        eventPage.pressConfirmDeleteEventButton();
    }

    /*************************************************************************************
     **                           STEPS FOR WORKING WITH COLLECTIONS                    **
     *************************************************************************************/

    public void openCollectionsPage() {
        CollectionsPage collectionsPage = new CollectionsPage(driver);
        collectionsPage.openPage();
    }
    public void createCollection(GCollection gCollection) {
        CollectionsPage collectionsPage = new CollectionsPage(driver);
        collectionsPage.init();
        collectionsPage.pressCreateCollectionButton();
        collectionsPage.setCollectionName(gCollection.getTitle());
        collectionsPage.setCollectionDescription(gCollection.getDescription());
        collectionsPage.pressCollectionCreateButton();
        (new WebDriverWait(driver, Constants.TIMEOUT_TITLE_CONTAINS))
                .until(ExpectedConditions.titleContains(gCollection.getTitle()));
    }

    public void openCollection(String collectionTitle) {
        CollectionsPage collectionsPage = new CollectionsPage(driver);
        collectionsPage.openPage();
        collectionsPage.openCollection(collectionTitle);
    }

    public void addPostToCollection(GPost gPost) {
        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.init();
        collectionPage.pressPostTextArea();
        collectionPage.setPostText(gPost.getText());
        collectionPage.pressDialogSharedPostButton();
    }

    public boolean isCollectionCreated(GCollection gCollection) {
        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.init();
        boolean collectionTitleIsRight = collectionPage.getCollectionTitle().equals(gCollection.getTitle());
        boolean collectionAuthorIsRight = collectionPage.getCollectionAuthor().contains(gCollection.getAuthor().getName());
        boolean collectionDescription = collectionPage.getCollectionDescription().equals(gCollection.getDescription());
        if(collectionAuthorIsRight == true & collectionDescription == true & collectionTitleIsRight == true)
            return true;
        else
            return false;
    }

    public boolean isPostAddedToCollection(GPost gPost) {
        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.init();
        GPost lastPost = collectionPage.getLastCollecionPost();
        if (lastPost.equals(gPost))
            return true;
        else
            return false;
    }

    public void deleteCollection() {
        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.init();
        collectionPage.pressMenuActionsWithCollection();
        collectionPage.pressMenuItem(Constants.ALIAS_MENU_ITEM_DELETE);
        collectionPage.pressDeleteConfirmationCheckBox();
        collectionPage.pressDeleteCollectionDialogButton();

    }

    /*************************************************************************************
     **                           STEPS FOR WORKING WITH COMMUNITIES                    **
     *************************************************************************************/

    public void openCommunitiesPage() {
        CommunitiesPage communitiesPage = new CommunitiesPage(driver);
        communitiesPage.openPage();
    }

    public String joinToCommunity(String title) {
        CommunitiesPage communitiesPage = new CommunitiesPage(driver);
        communitiesPage.init();
        communitiesPage.setSearchCommunityText(title);
        List<WebElement> communitiesList = communitiesPage.getFoundedCommunitiesList();
        String communityTitle = communitiesPage.pressJoinToCommunityButton(communitiesList.get(1));
        communitiesPage.openPage();
        return communityTitle;
    }

    public boolean isJoinedToCommunity(String communityTitle) {
        CommunitiesPage communitiesPage = new CommunitiesPage(driver);
        communitiesPage.init();
        List<WebElement> joinedCommunitiesList = communitiesPage.getJoinedCommunitiesList();
        for (WebElement community : joinedCommunitiesList) {
            if (communitiesPage.getTitleJoinedCommunity(community).equals(communityTitle))
                return true;
        }
        return false;
    }

    public void openJoinedCommunity(String title) {
        CommunitiesPage communitiesPage = new CommunitiesPage(driver);
        if (!communitiesPage.pageIsAlreadyOpen()) {
            communitiesPage.openPage();
        }
        communitiesPage.init();
        communitiesPage.openJoinedCommunity(title);
    }
    public void leaveCommunity() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.pressMenuSettingsButton();
        communityPage.pressMenuSettingsItem(Constants.ALIAS_MENU_ITEM_LEAVE);
        communityPage.pressConfirmLeaveButton();
    }

    /*************************************************************************************
     **                           STEPS FOR WORKING WITH CIRCLES                    **
     *************************************************************************************/

    public void openCirlesPage() {
        CirclesPage circlesPage = new CirclesPage(driver);
        circlesPage.openPage();
    }

    public void createCirlce(String title) {
        CirclesPage circlesPage = new CirclesPage(driver);
        circlesPage.init();
        circlesPage.pressNewCircleButton();
        circlesPage.setCircleTitle(title);
        circlesPage.pressCreateEmptyCircleButton();
    }

    public boolean isCirleCreated(String title) {
        CirclesPage circlesPage = new CirclesPage(driver);
        circlesPage.init();
        return circlesPage.getCircleText(Constants.LAST_ITEM_INDEX).equals(title);
    }

    public void addContactToCircle(GUser user, int circleID) {
        CirclesPage circlesPage = new CirclesPage(driver);
        circlesPage.init();
        circlesPage.pressAddContactButton();
        circlesPage.setContactSearchText(user.getEmail());
        circlesPage.selectCircleToAdd(circleID);
        circlesPage.pressSaveContactAddingButton();
        Utils.waitInisibilityElement(driver, By.xpath(XpathList.CIRCLES_PAGE_ALLERT_DIALOG_CIRCLES_LIST));
    }

    public boolean isContactAdded(int circleID) {
        CirclesPage circlesPage = new CirclesPage(driver);
        circlesPage.init();
        if(circlesPage.getNumberContactsInCircle(circleID) > 0)
            return true;
        else
            return false;
    }

    public void removeContact(GUser user) {
        CirclesPage circlesPage = new CirclesPage(driver);
        circlesPage.init();
        List<WebElement> contactsList = circlesPage.getContactsList();
        String username = user.getName() + Constants.WORDS_SEPARATOR + user.getSurname();
        for (WebElement contact : contactsList) {
            if (contact.getText().equals(username)) {
                new Actions(driver).moveToElement(contact).build().perform();
                circlesPage.pressRemoveContactButton();
            }
        }
    }
    public void deleteCircle(String circleTitle) {
        CirclesPage circlesPage = new CirclesPage(driver);
        circlesPage.init();
        List<WebElement> circlesList = circlesPage.getCirclesTitlesList();
        for (int i = 0; i < circlesList.size(); i++) {
            if(circlesList.get(i).getText().equals(circleTitle)) {
                circlesPage.pressOnCircle(i);
                circlesPage.pressDeleteCircleButton();
                circlesPage.pressConfirmDeleteCircleButton();
                break;
            }
        }
    }

}
