package tests.BankManagerTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.utils.bankManagerPages.AddCustomer;
import pages.utils.bankManagerPages.BankManagerLoginPage;

public class AddCustomerTest extends BaseTest {
    @Test(priority = 2)
    public void testAddCustomer() {
        // Initialize page objects
        BankManagerLoginPage managerPage = new BankManagerLoginPage(driver);
        AddCustomer addCustomer = new AddCustomer(driver);

        // Click Bank Manager Login with visible pause
        managerPage.clickBankManagerLogin();
        pauseExecution(2000);

        // Click Add Customer with visible pause
        addCustomer.clickAddCustomer();

        // Add new customer with visible pauses between actions
        addCustomer.addNewCustomer("Abdul", "Mustapha", "12345");
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