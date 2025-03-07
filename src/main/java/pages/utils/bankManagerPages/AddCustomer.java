package pages.utils.bankManagerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.BasePage;

public class AddCustomer extends BasePage {
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    public AddCustomer(WebDriver driver) {
        super(driver);
    }

    public void clickAddCustomer() {
        // Explicitly wait and ensure page is loaded
        waitForPageLoad();

        // Wait for the Add Customer button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton));

        // Highlight the button before clicking (optional visual aid)
        highlightElement(addCustomerButton);

        // Click the Add Customer button
        safeClick(addCustomerButton);

        // Add a pause to make the transition visible
        pauseExecution(2000);

        // Verify the form is loaded
        Assert.assertTrue(verifyElementPresent(firstNameInput),
                "Add Customer form did not load properly");
    }

    public void addNewCustomer(String firstName, String lastName, String postCode) {
        // Wait for and highlight first name input
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        highlightElement(firstNameInput);
        safeSendKeys(firstNameInput, firstName);
        pauseExecution(1000);

        // Wait for and highlight last name input
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        highlightElement(lastNameInput);
        safeSendKeys(lastNameInput, lastName);
        pauseExecution(1000);

        // Wait for and highlight post code input
        wait.until(ExpectedConditions.visibilityOf(postCodeInput));
        highlightElement(postCodeInput);
        safeSendKeys(postCodeInput, postCode);
        pauseExecution(1000);

        // Highlight submit button
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        highlightElement(submitButton);

        // Click submit button
        safeClick(submitButton);
        pauseExecution(2000);

        // Handle alert
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            pauseExecution(1000);
        } catch (Exception e) {
            System.out.println("No alert present or error handling alert");
        }
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