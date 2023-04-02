package co.uk.animed;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class StepDef {
    @Given("Customer visits Animeddirect website and verifs page title")
    public void customerVisitsAnimedirectAndVerifysTitle() {
        FirstTest firstTest = new FirstTest();
        firstTest.openBrowserTest();
    }
}
