package co.uk.animed;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {
    FirstTest firstTest = new FirstTest();
    @Given("Customer visits Animeddirect website and verifs page title")
    public void customerVisitsAnimedirectAndVerifysTitle() {
        firstTest.openBrowserTest();
    }

    @Given("Customer performs search for pet stock")
    public void customerSearchesForStock() {
        firstTest.customerActions("search","doggie treats");
    }

    @Given("Scrape product Data and Serialise product data")
    public void productDataSearlization() {
        firstTest.parseProductData();
    }

    @Then("TearDown")
    public void tearDownTest() {
        firstTest.tearDown();
    }

}
