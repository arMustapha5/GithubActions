package pages.utils.customerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class CustomerDeposit extends BasePage {
    public CustomerDeposit(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    private WebElement depositButton;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

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

    public void deposit(String amount) {
        // Wait for and highlight deposit button
        wait.until(ExpectedConditions.elementToBeClickable(depositButton));
        highlightElement(depositButton);
        depositButton.click();
        pauseExecution(1000);

        // Wait for and highlight amount input
        wait.until(ExpectedConditions.visibilityOf(amountInput));
        highlightElement(amountInput);
        amountInput.clear();
        amountInput.sendKeys(amount);
        pauseExecution(1000);

        // Wait for and highlight submit button
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        highlightElement(submitButton);
        submitButton.click();
        pauseExecution(1000);
    }
}