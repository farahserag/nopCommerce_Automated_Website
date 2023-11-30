package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompProductPage {
    private WebDriver driver;
    public CompProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private By processorSelection = By.id("product_attribute_1");
    private By ramSelection = By.id("product_attribute_2");
    private By hddRadio = By.id("product_attribute_3_6");
    private By osRadio = By.id("product_attribute_4_9");
    private By addToCart = By.id("add-to-cart-button-1");
    private By successMessage = By.xpath("//p[@class='content']");
    private By closeMessage = By.xpath("//span[@class='close']");
    private By goToCart =By.className("ico-cart");


    public void selectProcessor(String option){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(processorSelection));
        Select processor = new Select(driver.findElement(processorSelection));
        processor.selectByVisibleText(option);
    }
    public void selectRam(int index){
        Select ram = new Select(driver.findElement(ramSelection));
        ram.selectByIndex(index);
    }
    public void selectHDD(){
        driver.findElement(hddRadio).click();
    }
    public void selectOS(){
        driver.findElement(osRadio).click();
    }
    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }
    public String getNotificationText(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }
    public void closeNotification(){
        driver.findElement(closeMessage).click();
    }
    public ShoppingCartPage moveToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        driver.findElement(goToCart).click();
        return new ShoppingCartPage(driver);
    }

}

