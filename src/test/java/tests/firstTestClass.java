package tests;

import core.steps.Steps;
import org.junit.Test;

/**
 * Created by bogat on 29.03.2016.
 */
public class firstTestClass {

    private Steps steps;
    /*@BeforeMethod
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }*/

  /*  @Test
    public void createNewEvent() {
        steps = new Steps();
        steps.initBrowser();
        steps.createNewEvent();
    }*/

    @Test
    public void signInTest() {
        steps = new Steps();
        steps.initBrowser();
        steps.signIn();
    }
}
