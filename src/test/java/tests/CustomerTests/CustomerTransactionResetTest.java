package tests.CustomerTests;

import base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.customerPages.CustomerLogin;
import pages.utils.customerPages.CustomerTransaction;
import pages.utils.customerPages.CustomerTransactionReset;

public class CustomerTransactionResetTest extends BaseTest {
    // Static variable to track whether the test has been run
    private static boolean hasTestRun = false;
    @Order(2)
    @Test
    public void testTransactionReset() {
        // Check if the test has already been run
        if (hasTestRun) {
            System.out.println("Transaction Reset test has already been executed. Skipping.");
            return;
        }

        CustomerLogin customerLogin = new CustomerLogin(driver);
        CustomerTransaction customerTransaction = new CustomerTransaction(driver);
        CustomerTransactionReset customerTransactionReset = new CustomerTransactionReset(driver);

        // Utility method for pausing execution
        pauseExecution(2000);

        // Perform login, view transactions, and reset
        customerLogin.clickCustomerLogin();
        pauseExecution(1000);
        customerLogin.selectCustomer("Hermoine Granger");
        pauseExecution(1000);
        customerTransaction.transactions();
        pauseExecution(1000);
        customerTransactionReset.TransactionReset();

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