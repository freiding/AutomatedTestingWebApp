package tests;

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
    @Before
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @After
    public void endTest() {
        //steps.closeDriver();
    }

    /*
    * Completed
    *
    @Test
    public void signInTest() {
        steps.signIn();
        Assert.assertEquals(steps.isLogged(Steps.USERNAME), true);
    }
    */
    @Test
    public void addNewPost() {
        steps.signIn();
        steps.addPost("My post message text!");
    }

}
