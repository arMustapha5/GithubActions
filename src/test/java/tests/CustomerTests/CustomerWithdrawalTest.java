package tests.CustomerTests;

import base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.customerPages.CustomerLogin;
import pages.utils.customerPages.CustomerWithdrawal;

public class CustomerWithdrawalTest extends BaseTest {
    // Static variable to track whether the test has been run
    private static boolean hasTestRun = false;
    @Order(4)
    @Test
    public void testWithdrawal() {

        // Check if the test has already been run
        if (hasTestRun) {
            System.out.println("Withdrawal test has already been executed. Skipping.");
            return;
        }

        CustomerLogin customerLogin = new CustomerLogin(driver);
        CustomerWithdrawal customerWithdrawal = new CustomerWithdrawal(driver);

        // Utility method for pausing execution
        pauseExecution(2000);

        // Perform login and withdrawal
        customerLogin.clickCustomerLogin();
        customerLogin.selectCustomer("Hermoine Granger");

        // First withdrawal
        pauseExecution(1000);
        customerWithdrawal.withdraw("50");

        // Second withdrawal
        pauseExecution(2000);
        customerWithdrawal.withdraw("50");

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
