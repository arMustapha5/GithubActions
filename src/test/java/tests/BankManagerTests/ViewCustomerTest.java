package tests.BankManagerTests;

import base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.bankManagerPages.BankManagerLoginPage;
import pages.utils.bankManagerPages.ViewCustomers;

public class ViewCustomerTest extends BaseTest {
    // Static variable to track whether the test has been run
    private static boolean hasTestRun = false;
    @Order(3)
    @Test
    public void testCustomers() {
        // Check if the test has already run
        if (hasTestRun) {
            System.out.println("View Customer test has already been executed. Skipping.");
            return;
        }

        // Initialize page objects
        BankManagerLoginPage managerPage = new BankManagerLoginPage(driver);
        ViewCustomers viewCustomers = new ViewCustomers(driver);

        // Add initial pause
        pauseExecution(2000);

        // Perform view customers steps
        managerPage.clickBankManagerLogin();
        viewCustomers.clickCustomers();

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