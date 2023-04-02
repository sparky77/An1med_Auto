package Helper;

import co.uk.animed.FirstTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PageHelper {
    public WebDriver driver;
    public WebDriverWait wait;

    public static final Logger LOGGER = LoggerFactory.getLogger(FirstTest.class);
    public static final String HUB_URL = "https://marcussmith_tdujoc:nd7Yfv4AuWaaYzq3S8NM@hub-cloud.browserstack.com/wd/hub";


    public PageHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public PageHelper() {
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForLoad(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

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
        driver = WebDriverManager.chromedriver()
                .capabilities(desiredCapabilities)
                .remoteAddress(HUB_URL)
                .create();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDown() {
        LOGGER.info("Tearing down the test...");
        driver.quit();
    }

    public void testLogic() {
        LOGGER.info("Running the test...");
        driver.get("https://www.animeddirect.co.uk/");
        LOGGER.info("Title of the page is: {}", driver.getTitle());
        Assert.assertEquals("Page title is not correct", "Pet Foods | Pet Prescription Medication | Pet Accessories", driver.getTitle());
        LOGGER.info("Test completed...");
    }

}

