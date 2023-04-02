package co.uk.animed;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstTest.class);
    private static final String HUB_URL = "https://marcussmith_tdujoc:nd7Yfv4AuWaaYzq3S8NM@hub-cloud.browserstack.com/wd/hub";
    private WebDriver webDriver;

    @Before
    public void setUp() {
        LOGGER.info("Setting up the test...");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--test-type");
        chromeOptions.addArguments("allow-running-insecure-content");
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.setCapability("browser_version", "100");
        desiredCapabilities.setCapability("os", "windows");
        desiredCapabilities.setCapability("os_version", "11");
        desiredCapabilities.setCapability("seleniumVersion", "4.2.2");
        desiredCapabilities.setCapability("project", "BAT");
        webDriver = WebDriverManager.chromedriver()
                .capabilities(desiredCapabilities)
                .remoteAddress(HUB_URL)
                .create();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        LOGGER.info("Tearing down the test...");
        webDriver.quit();
    }

    @Test
    public void openBrowserTest() {
        LOGGER.info("Running the test...");
        webDriver.get("https://www.animeddirect.co.uk/");
        LOGGER.info("Title of the page is: {}", webDriver.getTitle());
        Assert.assertEquals("Page title is not correct", "Pet Foods | Pet Prescription Medication | Pet Accessories", webDriver.getTitle());
    }
}


