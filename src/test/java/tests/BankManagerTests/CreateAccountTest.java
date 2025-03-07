package tests.BankManagerTests;

import base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.bankManagerPages.BankManagerLoginPage;
import pages.utils.bankManagerPages.CreateAccount;

public class CreateAccountTest extends BaseTest {
    // Static variable to track whether the test has been run
    private static boolean hasTestRun = false;
    @Order(2)
    @Test(priority = 2)
    public void testOpenAccount() {
        // Check if the test has already run
        if (hasTestRun) {
            System.out.println("Create Account test has already been executed. Skipping.");
            return;
        }

        // Initialize page objects
        BankManagerLoginPage managerPage = new BankManagerLoginPage(driver);
        CreateAccount createAccount = new CreateAccount(driver);

        // Add initial pause
        pauseExecution(2000);

        // Perform account creation steps
        managerPage.clickBankManagerLogin();
        createAccount.clickOpenAccount();
        createAccount.selectCustomer("Hermoine Granger");
        createAccount.selectCurrency("Dollar");
        createAccount.submitForm();

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