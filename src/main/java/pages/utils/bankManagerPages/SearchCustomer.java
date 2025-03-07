package pages.utils.bankManagerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class SearchCustomer extends BasePage {
    @FindBy(xpath = "//input[@placeholder = 'Search Customer']")
    private WebElement searchCustomerButton;

    public SearchCustomer(WebDriver driver) {
        super(driver);
    }

    public void setSearchCustomerButton(String customerName) {
        waitForPageLoad();

        // Wait for and highlight search input
        wait.until(ExpectedConditions.visibilityOf(searchCustomerButton));
        highlightElement(searchCustomerButton);

        // Click and send keys
        safeClick(searchCustomerButton);
        safeSendKeys(searchCustomerButton, customerName);

        pauseExecution(2000);
    }

    // Highlight element method
    private void highlightElement(WebElement element) {
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.border='3px solid red'", element);
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.backgroundColor='yellow'", element);
        } catch (Exception e) {
            System.out.println("Could not highlight element");
        }
    }

    // Pause execution method
    private void pauseExecution(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Execution pause interrupted");
        }
    }
}