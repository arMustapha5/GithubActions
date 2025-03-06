package pages.utils.bankManagerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class BankManagerLoginPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    private WebElement bankManagerLoginButton;

    public BankManagerLoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickBankManagerLogin() {
        // Explicitly wait and ensure page is loaded
        waitForPageLoad();

        // Wait for the Bank Manager Login button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(bankManagerLoginButton));

        // Highlight the button before clicking (visual aid)
        highlightElement(bankManagerLoginButton);

        // Click the Bank Manager Login button
        safeClick(bankManagerLoginButton);

        // Add a pause to make the transition visible
        pauseExecution(2000);
    }

    // New method to highlight element (visual aid)
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

    // Method to add a pause for visibility
    private void pauseExecution(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Execution pause interrupted");
        }
    }
}