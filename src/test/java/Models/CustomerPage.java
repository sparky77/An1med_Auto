package Models;

import Helper.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomerPage extends PageHelper {

    WebDriverWait wait;

    public CustomerPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void addToCart(String productName) {
        List<WebElement> products = driver.findElements(By.cssSelector("div.product-info h4"));
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                WebElement addToCartButton = product.findElement(By.xpath("../../div[2]/button"));
               // scrollToElement(addToCartButton);
                click((By) addToCartButton);
                break;
            }
        }
    }

    public void removeFromCart(String productName) {
        List<WebElement> products = driver.findElements(By.cssSelector("div.product-info h4"));
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                WebElement removeButton = product.findElement(By.xpath("../../div[2]/div/a[1]"));
                //driver.scrollToElement(removeButton);
                //click(removeButton);
                break;
            }
        }
    }

    public void checkout() {
        click(By.cssSelector("a.checkout-link"));
    }
}
