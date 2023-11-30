package login;

import base.BaseTests;
import org.openqa.selenium.devtools.v117.log.Log;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfullyLogin(){
        LoginPage loginPage=homePage.clickLoginLink();
        loginPage.setEmail("farahserag797@gmail.com");
        loginPage.setPassword("farah12345");
        loginPage.clickLoginButton();
    }
}
