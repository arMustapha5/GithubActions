package pages.utils.bankManagerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class CreateAccount extends BasePage {
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    private WebElement openAccountButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "userSelect")
    private WebElement customerSelect;

    @FindBy(id = "currency")
    private WebElement currencySelect;

    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    public void clickOpenAccount() {
        waitForPageLoad();

        // Wait for and highlight Open Account button
        wait.until(ExpectedConditions.elementToBeClickable(openAccountButton));
        highlightElement(openAccountButton);

        safeClick(openAccountButton);
        pauseExecution(2000);
    }

    public void selectCustomer(String customerName) {
        wait.until(ExpectedConditions.visibilityOf(customerSelect));
        highlightElement(customerSelect);

        // Use Select class for dropdown
        Select customerDropdown = new Select(customerSelect);
        customerDropdown.selectByVisibleText(customerName);

        pauseExecution(1000);
    }

    public void selectCurrency(String currency) {
        wait.until(ExpectedConditions.visibilityOf(currencySelect));
        highlightElement(currencySelect);

        // Use Select class for dropdown
        Select currencyDropdown = new Select(currencySelect);
        currencyDropdown.selectByVisibleText(currency);

        pauseExecution(1000);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        highlightElement(submitButton);

        safeClick(submitButton);
        pauseExecution(2000);

        // Handle potential alert
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            pauseExecution(1000);
        } catch (Exception e) {
            System.out.println("No alert present or error handling alert");
        }
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