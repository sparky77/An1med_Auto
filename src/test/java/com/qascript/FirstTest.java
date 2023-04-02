package com.qascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstTest {

    ChromeOptions options;
    WebDriver driver;

    @Test
    public void OpenBrowserTest()  {
        startRemoteBrowser();
        driver.get("https://www.animeddirect.co.uk/");
        System.out.println("Title of the page is: " + driver.getTitle());
        Assert.assertEquals("Page title is not correct", "Pet Foods | Pet Prescription Medication | Pet Accessories", driver.getTitle());
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


}


