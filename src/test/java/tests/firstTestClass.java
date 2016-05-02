package tests;

import core.TestData;
import core.objects.Post;
import core.objects.User;
import core.steps.Steps;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bogat on 29.03.2016.
 */
public class firstTestClass {

    private Steps steps;
    private User user;

    @Before
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
        user = new User(TestData.USERNAME, TestData.EMAIL, TestData.PASSWORD);
    }

    @After
    public void endTest() {
        steps.closeDriver();
    }

    @Test
    public void signInTest() {
        steps.signIn(user);
        Assert.assertEquals(steps.isLogged(user), true);
    }

    @Test
    public void addNewPost() {
        steps.signIn(user);
        Post post = new Post(user, TestData.POST_TEXT);
        steps.addPost(post);
        Assert.assertEquals(steps.checkAddedPost(post), true);
    }

}
