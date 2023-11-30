package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){this.driver=driver;}
    private By loginPagelink = By.linkText("Log in");
    private By registerPageLink =By.linkText("Register");
    private By productComp = By.xpath("//div[@data-productid=('1')]");
    private By addProductCompToCart =
    By.xpath("//div[@data-productid=('1')]//button[contains(text(),'Add to cart')]");
    private By goToCart = By.className("ico-cart");


    public LoginPage clickLoginLink(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPagelink));
        driver.findElement(loginPagelink).click();
        return new LoginPage(driver);
    }
    public RegisterPage clickRegisterLink(){
        driver.findElement(registerPageLink).click();
        return new RegisterPage(driver);
    }
    public void findProduct(){
        WebElement productsDiv = driver.findElement(productComp);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, productsDiv);
    }
    public CompProductPage clickCompProductToCart(){
        findProduct();
        driver.findElement(addProductCompToCart).click();
        return new CompProductPage(driver);
    }
    public ShoppingCartPage goToCart(){
        driver.findElement(goToCart).click();
        return new ShoppingCartPage(driver);
    }
}
