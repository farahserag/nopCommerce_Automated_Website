package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    private WebDriver driver;
    public ShoppingCartPage(WebDriver driver){this.driver = driver;}
    private By checkoutBtn = By.id("checkout");
    private By termsOfService = By.id("termsofservice");
    public void acceptTermsOfService(){
        driver.findElement(termsOfService).click();
    }
    public CheckoutPage clickCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
