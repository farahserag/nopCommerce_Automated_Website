package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterDonePage {
    private WebDriver driver;
    public RegisterDonePage(WebDriver driver){
        this.driver=driver;
    }
    private By registerDone = By.cssSelector("div.result");
    private By continueButton = By.xpath("//a[contains(.,'Continue')]");
    public String registerCompleteText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerDone));
        return driver.findElement(registerDone).getText();
    }
    public HomePage clickContinueAfterRegister(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}
