package tests.CustomerTests;

import base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.customerPages.CustomerLogin;
import pages.utils.customerPages.CustomerTransaction;

public class CustomerTransactionTest extends BaseTest {
    // Static variable to track whether the test has been run
    private static boolean hasTestRun = false;
    @Order(1)
    @Test
    public void testTransactions() {
        // Check if the test has already been run
        if (hasTestRun) {
            System.out.println("Transactions test has already been executed. Skipping.");
            return;
        }

        CustomerLogin customerLogin = new CustomerLogin(driver);
        CustomerTransaction customerTransaction = new CustomerTransaction(driver);

        // Utility method for pausing execution
        pauseExecution(2000);

        // Perform login and view transactions
        customerLogin.clickCustomerLogin();
        pauseExecution(1000);
        customerLogin.selectCustomer("Hermoine Granger");
        pauseExecution(1000);
        customerTransaction.transactions();

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