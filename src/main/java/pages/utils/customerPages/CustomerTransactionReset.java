package pages.utils.customerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class CustomerTransactionReset extends BasePage {
    public CustomerTransactionReset(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    private WebElement resetButton;

    // Highlight element method
    private void highlightElement(WebElement element) {
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.border='3px solid green'", element);
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

    public void TransactionReset() {
        // Wait for and highlight reset button
        wait.until(ExpectedConditions.elementToBeClickable(resetButton));
        highlightElement(resetButton);
        resetButton.click();
        pauseExecution(2000);
    }
}