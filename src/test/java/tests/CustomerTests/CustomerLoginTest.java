package tests.CustomerTests;

import base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.customerPages.CustomerLogin;

public class CustomerLoginTest extends BaseTest  {
    @Order(0)
    @Test(priority = 0)
    public void testLogin() throws InterruptedException {
        CustomerLogin customerLogin = new CustomerLogin(driver);
        Thread.sleep(3000);
        customerLogin.clickCustomerLogin();
        Thread.sleep(3000);
        customerLogin.selectCustomer("Hermoine Granger");
        Thread.sleep(3000);
    }
}
