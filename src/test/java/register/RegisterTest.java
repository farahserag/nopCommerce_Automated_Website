package register;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.RegisterDonePage;
import pages.RegisterPage;

import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTests {
    @Test
    public void checkSuccessfullyRegister(){
        RegisterPage register =homePage.clickRegisterLink();
        register.selectGender("F");
        register.setFirstName("Farah");
        register.setLastName("Serag");
        register.selectDay("31");
        register.selectMonth("March");
        register.selectYear("2000");
        register.setEmail("farahserag797@gmail.com");
        register.setCompany("ITI");
        register.newsCheckBox();
        register.setPasswordField("farah12345");
        register.setConfirmPasswordField("farah12345");
        register.clickRegisterButton();
       RegisterDonePage registerCompletePage = register.registerComplete();
        assertEquals(registerCompletePage.registerCompleteText(),"Your registration completed","Incorrect");

    }

}
