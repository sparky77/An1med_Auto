package co.uk.animed;

import Models.CustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class StepDef {
    FirstTest firstTest = new FirstTest();
    @Given("Customer visits Animeddirect website and verifs page title")
    public void customerVisitsAnimedirectAndVerifysTitle() {
        firstTest.openBrowserTest();
    }

    @Given("Customer performs search for pet stock")
    public void customerSearchesForStock() {
        firstTest.search("doggie treats");
    }

    @Then("TearDown")
    public void tearDownTest() {
        firstTest.tearDown();
    }

}
