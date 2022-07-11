package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SmartBearHomePage;
import utils.Driver;

public class BaseSteps {
    WebDriver driver;


    @Before
    public void setup(){
        driver = Driver.getDriver();


    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }
}
