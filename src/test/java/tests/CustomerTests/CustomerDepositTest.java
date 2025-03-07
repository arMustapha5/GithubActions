package tests.CustomerTests;

import base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.customerPages.CustomerLogin;
import pages.utils.customerPages.CustomerDeposit;

public class CustomerDepositTest extends BaseTest {
    // Static variable to track whether the test has been run
    private static boolean hasTestRun = false;
    @Order(3)
    @Test
    public void testDeposit() {
        // Check if the test has already run
        if (hasTestRun) {
            System.out.println("Deposit test has already been executed. Skipping.");
            return;
        }

        CustomerLogin customerLogin = new CustomerLogin(driver);
        CustomerDeposit customerDeposit = new CustomerDeposit(driver);

        // Utility method for pausing execution
        pauseExecution(2000);

        // Perform login and deposit
        customerLogin.clickCustomerLogin();
        customerLogin.selectCustomer("Hermoine Granger");

        // First deposit
        pauseExecution(1000);
        customerDeposit.deposit("1000");

        // Second deposit
        pauseExecution(2000);
        customerDeposit.deposit("1000");

        // Mark the test as run
        hasTestRun = true;
    }

    // Utility method for pausing execution
    private void pauseExecution(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Execution pause interrupted");
        }
    }
}