package pages.utils.bankManagerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ViewCustomers extends BasePage {
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    private WebElement customersButton;

    public ViewCustomers(WebDriver driver) {
        super(driver);
    }

    public void clickCustomers() {
        waitForPageLoad();

        // Wait for and highlight Customers button
        wait.until(ExpectedConditions.elementToBeClickable(customersButton));
        highlightElement(customersButton);

        safeClick(customersButton);
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