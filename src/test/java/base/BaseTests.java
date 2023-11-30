package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
   protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
       homePage = new HomePage(driver);
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        goHome();
    }
    @BeforeMethod
    public void goHome(){

        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();

    }
}
