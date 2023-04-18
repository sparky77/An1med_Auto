package Helper;

import co.uk.animed.FirstTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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
import java.util.List;

public class PageHelper {
    public WebDriver driver;
    public WebDriverWait wait;

    public static final Logger LOGGER = LoggerFactory.getLogger(FirstTest.class);
    public static final String HUB_URL = "https://marcussmith_tdujoc:nd7Yfv4AuWaaYzq3S8NM@hub-cloud.browserstack.com/wd/hub";

    public PageHelper() {
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
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

    public void customerActions(String action, String value) {
        switch (action.toLowerCase()) {
            case "search":
                search(value);
                break;
            default:
                System.out.println("Invalid customer action: " + action);
                break;
        }
    }

    public void search(String searchTerm) {
        // below is for mobile implementation
        try {
            click(By.cssSelector("#search_mini_form > div.field.search > label > span"));
        } catch (Exception e) {
            System.out.println("**** Couldn't find Mobile search icon - Desktop or Error");
        }
        type(By.cssSelector("input[id='search']"), searchTerm);
        click(By.cssSelector("button[class='action search']"));
        Assert.assertEquals("Page title is not correct", "Search results for: '" +searchTerm+ "'", driver.getTitle());
    }

    public void parseProductData(){
        WebElement ProductBlock = driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.category-products.products.wrapper.grid.products-grid > ol"));
        List<WebElement> products = ProductBlock.findElements(By.cssSelector("li.item.product.product-item"));
        System.out.println("**** PLP INFORMATION **** ");
        System.out.println("**** PAGE TITLE : " + driver.getTitle());;
        System.out.println("**** # PRODUCTS : " + products.size());
        System.out.println("**** URL : " + driver.getCurrentUrl());
        for (WebElement product : products) {
            String productName = product.findElement(By.cssSelector("div.product.name.product-item-name.category-products__name")).getText();
            String price = product.findElement(By.cssSelector("div.price-box.price-final_price")).getText();

            System.out.println("----------------");
            System.out.println(productName);
            System.out.println(price);
            System.out.println("----------------");
        }
    }

    private void pageStartUpTasks() {
        // accept cookies
        acceptCookies();
        // close marketing pop-up and select search trigger to search available for input.
        try {
            click(By.cssSelector(".frel_button-close"));
            click(By.cssSelector("#search-trigger"));
        } catch (Exception e) {
            System.out.println("Couldn't find / click frel button close");
        }
    }

    private void acceptCookies() {
        driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
    }

    public void waitForLoad(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void setUp() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--test-type");
        chromeOptions.addArguments("allow-running-insecure-content");

        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        //iPhone 12 (iOS 14.1 & Chrome)
        desiredCapabilities.setCapability("osVersion", "14");
        desiredCapabilities.setCapability("deviceName", "iPhone 12");
        desiredCapabilities.setCapability("realMobile", "true");

        // Windows 11 (Chrome 100)
/*        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.setCapability("browser_version", "100");
        desiredCapabilities.setCapability("os", "windows");
        desiredCapabilities.setCapability("os_version", "11");
        desiredCapabilities.setCapability("resolution", "2048x1536");*/

        desiredCapabilities.setCapability("seleniumVersion", "4.8.1");
        desiredCapabilities.setCapability("project", "ANIMED_CI");

        desiredCapabilities.setCapability("build","ANIMED DIRECT" + " :: AUTOMATION CI");

        driver = WebDriverManager.chromedriver()
                .capabilities(desiredCapabilities)
                .remoteAddress(HUB_URL)
                .create();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    public void tearDown() {
        System.out.println("************ TESTING COMPLETED ******************");
        LOGGER.info("Tearing down the test...");
        driver.quit();
    }

    public void testLogic() {
        LOGGER.info("Running the test...");
        driver.get("https://www.animeddirect.co.uk/");

        pageStartUpTasks();

        LOGGER.info("Title of the page is: {}", driver.getTitle());
        Assert.assertEquals("Page title is not correct", "Pet Foods | Pet Prescription Medication | Pet Accessories", driver.getTitle());
        LOGGER.info("Test completed...");
    }

}

