package Models;

import Helper.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerPage extends PageHelper {

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void customerActions(String action, String value) {
        switch (action.toLowerCase()) {
            case "search":
                search(value);
                break;
            case "add to cart":
                addToCart(value);
                break;
            case "remove from cart":
                removeFromCart(value);
                break;
            case "checkout":
                checkout();
                break;
            default:
                System.out.println("Invalid customer action: " + action);
                break;
        }
    }

    public void search(String searchTerm) {
        type(By.cssSelector("input[id='search']"), searchTerm);
        click(By.cssSelector("button[class='action search']"));
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
