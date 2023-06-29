package Helper;

import Models.Customer;
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
    public static final String HUB_URL = "https://marcussmith_BH2rDw:pvyMzs4e3smboMC7sTp6@hub-cloud.browserstack.com/wd/hub";

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
                //Customer customer = new Customer();
                //customer.runSearch(value);
                //customer.customerActions();
                search(value);
                break;
            default:
                System.out.println("-------------------------");
                System.out.println("-------------------------");
                System.out.println("-------------------------");
                System.out.println("Invalid customer action: " + action);
                break;
        }
    }

    //TODO Mobile and Desktop adaptability
    public void search(String searchTerm) {

        // Mobile double click required on search icon
        //click(By.cssSelector("#search_mini_form > div.field.search > label"));
        //click(By.cssSelector("#search_mini_form > div.field.search > label"));

        type(By.cssSelector("input[id='search']"), searchTerm);
        //driver.findElement(By.cssSelector("input[id='search']")).submit();

        // below action search button is for desktop only
        click(By.cssSelector("button[class='action search']"));
        //Assert.assertEquals("Page title is not correct", "Search results for: '" +searchTerm+ "'", driver.getTitle());
        Assert.assertEquals("Page title is not correct", "My Account", driver.getTitle());
    }

    //TODO Moved into Product Class
    public void parseProductData(){
        // ProductBlock has two differing CMS blocks - first for desktop, second for mobile.
        WebElement ProductBlock = driver.findElement(By.cssSelector(".products.wrapper.list.products-list > ol,div.category-products.products.wrapper.grid.products-grid > ol"));
        // WebElement split into individual product data blocks
        List<WebElement> products = ProductBlock.findElements(By.cssSelector("li.item.product.product-item"));

        DisplayPLPDataSummary(products);
        for (WebElement product : products) {
            String productName = product.findElement(By.cssSelector("div.product.name.product-item-name.category-products__name")).getText();
            String price = product.findElement(By.cssSelector("div.price-box.price-final_price")).getText();

            System.out.println("-----------------");
            System.out.println(productName);
            System.out.println(price);
            System.out.println("-----------------");
        }
    }

    private void DisplayPLPDataSummary(List<WebElement> products) {
        System.out.println();
        System.out.println("**** PLP INFORMATION **** ");
        System.out.println("**** PAGE TITLE : " + driver.getTitle());
        System.out.println("**** # PRODUCTS : " + products.size());
        System.out.println("**** URL : " + driver.getCurrentUrl());
        System.out.println();
    }


    //TODO turn into @Before class
    private void pageStartUpTasks() {
        // accept cookies
        acceptCookies();
        // close marketing pop-up and select search trigger to search available for input.
        try {
            click(By.cssSelector(".frel_button-close"));
            //click(By.cssSelector("#search-trigger"));
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

    //TODO @Before requirement
    //TODO set Desktop / Mobile type with ENUM Cat ? Feed into future switch statements
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
/*        desiredCapabilities.setCapability("osVersion", "14");
        desiredCapabilities.setCapability("deviceName", "iPhone 12");
        desiredCapabilities.setCapability("realMobile", "true");*/

        // Windows 11 (Chrome 100)
        String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
        String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
        String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
        //  String buildName = System.getenv("JENKINS_LABEL");
        System.out.println("Build Name: " + buildName);
        System.out.println("testing");

        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.setCapability("browser_version", "100");
        desiredCapabilities.setCapability("os", "windows");
        desiredCapabilities.setCapability("os_version", "11");
        desiredCapabilities.setCapability("resolution", "2048x1536");


        desiredCapabilities.setCapability("seleniumVersion", "4.8.1");
        desiredCapabilities.setCapability("project", "ANIMED_CI");
        desiredCapabilities.setCapability("browserstack.local", browserstackLocal);
        desiredCapabilities.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);

        //desiredCapabilities.setCapability("build","ANIMED DIRECT" + " :: AUTOMATION CI");
        //desiredCapabilities.setCapability("build","Intergration Jenkins BS Plugin Build");
        desiredCapabilities.setCapability("build", buildName);

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

