package pages.utils.customerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class CustomerTransaction extends BasePage {
    public CustomerTransaction(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    private WebElement transactionButton;

    // Highlight element method
    private void highlightElement(WebElement element) {
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.border='3px solid blue'", element);
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

    public void transactions() {
        // Wait for and highlight transaction button
        wait.until(ExpectedConditions.elementToBeClickable(transactionButton));
        highlightElement(transactionButton);
        transactionButton.click();
        pauseExecution(2000);
    }
}