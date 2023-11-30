package addToCart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.CompProductPage;
import pages.ShoppingCartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AddToCartTest extends BaseTests {

    @Test
    public void addCompProductToCart() throws InterruptedException {
        CompProductPage compProduct =homePage.clickCompProductToCart();
        String option = "2.2 GHz Intel Pentium Dual-Core E2200"; //"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"
        compProduct.selectProcessor(option); //Added WebDriverWait to selectProcessor Method because of NoSuchElementException
        compProduct.selectRam(1);
        compProduct.selectHDD();
        compProduct.selectOS();
        compProduct.clickAddToCart();
        assertEquals(compProduct.getNotificationText(),
                "The product has been added to your shopping cart",
                "Something Went Wrong");
        compProduct.closeNotification();
        compProduct.moveToCart();
        ShoppingCartPage shoppingCart =homePage.goToCart();
        shoppingCart.acceptTermsOfService();
        shoppingCart.clickCheckOut();

    }

}