package tests.BankManagerTests;

import tests.base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.bankManagerPages.BankManagerLoginPage;

public class BankManagerLoginPageTest extends BaseTest {
    // Static variable to track whether the test has been run
    private static boolean hasTestRun = false;
    @Order(0)
    @Test
    public void clickBankManagerLogin() {
        // Check if the test has already run
        if (hasTestRun) {
            System.out.println("Test has already been executed. Skipping.");
            return;
        }

        // Initialize the page object
        BankManagerLoginPage managerPage = new BankManagerLoginPage(driver);

        // Add initial pause
        pauseExecution(2000);

        // Click Bank Manager Login
        managerPage.clickBankManagerLogin();

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