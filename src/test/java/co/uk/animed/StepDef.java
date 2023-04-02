package co.uk.animed;

import co.uk.animed.FirstTest;
import io.cucumber.java.en.Given;

public class StepDef {
    @Given("Customer visits Animeddirect website and verifs page title")
    public void customerVisitsAnimedirectAndVerifysTitle() {
        FirstTest firstTest = new FirstTest();
        firstTest.openBrowserTest();
    }
}
