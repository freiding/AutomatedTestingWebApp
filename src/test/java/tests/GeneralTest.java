package tests;

import core.data.TestData;
import core.objects.GCollection;
import core.objects.GEvent;
import core.objects.GPost;
import core.objects.GUser;
import core.steps.Steps;
import core.data.Constants;
import core.utils.Utils;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bogat on 29.03.2016.
 */
public class GeneralTest {

    private Steps steps;
    private GUser gUser;

    @Before
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
        gUser = new GUser(TestData.USER_NAME, TestData.USER_SURNAME, TestData.USER_EMAIL, TestData.USER_PASSWORD);
        steps.signIn(gUser);
    }

    @After
    public void tearDown() {
        steps.closeDriver();
    }

    @Test
    public void signInTest() {
        Assert.assertEquals(true, steps.isLogged(gUser));
    }

    @Test
    public void addNewPost() {
        steps.openStartPage();
        GPost GPost = new GPost(
                gUser,
                TestData.POST_TEXT
        );
        steps.addPost(GPost);
        boolean actualResult = steps.isPostCreated(GPost);
        //steps.deleteLastPost();// I DON'T KNOW WHY THIS FUCK IS NOT WORKING
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void searchTest() {
        steps.openSearchPage();
        steps.searchPosts(TestData.SEARCH_TEXT);
        Assert.assertEquals(true, steps.isSearchCorrect(TestData.SEARCH_TEXT));
    }

    @Test
    public void createEventTest() {
        steps.openEventsPage();
        GEvent gEvent = new GEvent(
                TestData.EVENT_TITLE,
                TestData.EVENT_DATE,
                TestData.EVENT_TIME,
                TestData.EVENT_LOCATION,
                TestData.EVENT_DESCRIPTION,
                TestData.EVENT_FOR_WHOM
        );
        steps.createEvent(gEvent);
        boolean actualResult = steps.isEventCreated(gEvent);
        steps.deleteEvent();
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void createCollectionTest() {
        steps.openCollectionsPage();
        GCollection gCollection = new GCollection(
                TestData.COLLECTION_TITLE,
                TestData.COLLECTION_DESCRIPTION,
                gUser
        );
        steps.createCollection(gCollection);
        boolean actualResult = steps.isCollectionCreated(gCollection);
        steps.deleteCollection();
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void addPostToCollectionTest() {
        GCollection gCollection = new GCollection(
                TestData.COLLECTION_TITLE,
                TestData.COLLECTION_DESCRIPTION,
                gUser
        );
        GPost gPost = new GPost(
                gUser,
                TestData.POST_TEXT
        );
        steps.openCollectionsPage();
        steps.createCollection(gCollection);
        if (steps.isCollectionCreated(gCollection)) {
            steps.addPostToCollection(gPost);
            boolean actualResult = steps.isPostAddedToCollection(gPost);
            steps.deleteCollection();
            Assert.assertEquals(true, actualResult);
        }
        else
            Assert.fail(Constants.ERROR_MESSAGE_COLLECTION_NOT_CREATED);
    }

    @Test
    public void joinToCommunityTest() {
        steps.openCommunitiesPage();
        String joinedCommunityTitle = steps.joinToCommunity(TestData.SEARCH_COMMUNITY_TITLE);
        boolean actualResult = steps.isJoinedToCommunity(joinedCommunityTitle);
        steps.openJoinedCommunity(joinedCommunityTitle);
        steps.leaveCommunity();
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void createCircleTest() {
        steps.openCirlesPage();
        steps.createCirlce(TestData.NEW_CIRCLE_TITLE);
        boolean actualResult = steps.isCirleCreated(TestData.NEW_CIRCLE_TITLE);
        steps.deleteCircle(TestData.NEW_CIRCLE_TITLE);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void addContactToCircleTest() {
        GUser user = new GUser(
                TestData.TEST_USER_NAME,
                TestData.TEST_USER_SURNAME,
                TestData.TEST_USER_EMAIL,
                TestData.TEST_USER_PASSWORD
        );
        steps.openCirlesPage();
        steps.addContactToCircle(user, TestData.CIRCLE_NUMBER);
        boolean actualResult = steps.isContactAdded(TestData.CIRCLE_NUMBER + 1);
        steps.removeContact(user);
        Assert.assertEquals(true, actualResult);
    }
}
