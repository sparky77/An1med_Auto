package co.uk.animed;

import Models.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;

public class StepDef {
    FirstTest firstTest = new FirstTest();
    @Given("Customer visits Animeddirect website and verify page title")
    public void customerVisitsAnimedirectAndVerifysTitle() {
        firstTest.openBrowserTest();
    }

    @Test
    @Given("Customer performs search for pet stock")
    public void customerSearchesForStock() {
        firstTest.customerActions("search","doggie treats");
        //Customer customer = new Customer();
        //customer.runSearch("doggie treats");
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
