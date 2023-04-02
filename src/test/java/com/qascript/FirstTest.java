package com.qascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FirstTest {

    ChromeOptions options;
    WebDriver driver;

    @Test
    public void OpenBrowser()  {
        startRemoteBrowser();
        //WebDriver driver;
       // WebDriverManager.chromedriver().setup();
        //WebDriverManager.
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //ChromeOptions options = new ChromeOptions();
       // options.addArguments("headless");
       //options.addArguments("disable-gpu");
       // driver = new ChromeDriver(options);
        driver.get("https://www.animeddirect.co.uk/");
        System.out.println("Title of the page is: " + driver.getTitle());
        Assert.assertTrue("Page title is not correct",driver.getTitle().equals("Pet Foods | Pet Prescription Medication | Pet Accessories"));
        driver.quit();
    }

    public void startRemoteBrowser(){
        DesiredCapabilities caps = new DesiredCapabilities();
        String hubURL = "https://marcussmith_tdujoc:nd7Yfv4AuWaaYzq3S8NM@hub-cloud.browserstack.com/wd/hub";
        options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-web-security");
        options.addArguments("--test-type");
        options.addArguments("allow-running-insecure-content");
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        caps.setCapability("browser", "chrome");
        caps.setCapability("browser_version", "100");
        caps.setCapability("os", "windows");
        caps.setCapability("os_version", "11");
        caps.setCapability("seleniumVersion", "4.2.2");
        caps.setCapability("project", "BAT");
        driver = WebDriverManager.chromedriver()
                .capabilities(options)
                .remoteAddress(hubURL)
                .create();
    }

/*    // TRYING to fire remote driver for BS
    DesiredCapabilities caps = new DesiredCapabilities();
    options = new ChromeOptions();
                options.addArguments("--ignore-ssl-errors=yes");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-web-security");
                options.addArguments("--test-type");
                options.addArguments("allow-running-insecure-content");
                caps.setCapability(ChromeOptions.CAPABILITY, options);

                caps.setCapability("browser", "chrome");
                caps.setCapability("browser_version", "100");
                caps.setCapability("os", "windows");
                caps.setCapability("os_version", "11");
                caps.setCapability("seleniumVersion", "4.2.2");
                caps.setCapability("project", "BAT");
    driver = new RemoteWebDriver(new URL("https://batbsauto_IG7R8rDiiDf:vNhrigLoLtzizHEKhTti@hub-cloud.browserstack.com/wd/hub"), caps);
                driver.manage().window().maximize();*/


}


