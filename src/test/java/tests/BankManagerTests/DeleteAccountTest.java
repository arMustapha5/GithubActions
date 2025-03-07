package tests.BankManagerTests;

import base.BaseTest;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;
import pages.utils.bankManagerPages.BankManagerLoginPage;
import pages.utils.bankManagerPages.DeleteAccount;
import pages.utils.bankManagerPages.SearchCustomer;
import pages.utils.bankManagerPages.ViewCustomers;

public class DeleteAccountTest extends BaseTest {
    // Static variable to track whether the test has been run
    private static boolean hasTestRun = false;
    @Order(5)
    @Test(priority = 5)
    public void testDeleteCustomer() {
        // Check if the test has already run
        if (hasTestRun) {
            System.out.println("Delete Account test has already been executed. Skipping.");
            return;
        }

        // Initialize page objects
        BankManagerLoginPage managerPage = new BankManagerLoginPage(driver);
        ViewCustomers viewCustomers = new ViewCustomers(driver);
        SearchCustomer searchCustomers = new SearchCustomer(driver);
        DeleteAccount deleteAccount = new DeleteAccount(driver);

        // Add initial pause
        pauseExecution(2000);

        // Perform delete customer steps
        managerPage.clickBankManagerLogin();
        viewCustomers.clickCustomers();
        searchCustomers.setSearchCustomerButton("Hermoine");
        deleteAccount.setDeleteCustomerButton();

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