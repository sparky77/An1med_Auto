package co.uk.animed;

import java.util.concurrent.TimeUnit;

import Helper.PageHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstTest extends PageHelper {
    WebDriver driver;

    public void openBrowserTest() {
        setUp();

        LOGGER.info("Running the test...");
        driver.get("https://www.animeddirect.co.uk/");
        LOGGER.info("Title of the page is: {}", driver.getTitle());
        Assert.assertEquals("Page title is not correct", "Pet Foods | Pet Prescription Medication | Pet Accessories", driver.getTitle());
        LOGGER.info("Test completed...");

        tearDown();
    }
}


