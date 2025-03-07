package pages.utils.customerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.time.Duration;

public class CustomerLogin extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    private WebElement customerLoginButton;

    @FindBy(id = "userSelect")
    private WebElement customerSelect;

    public CustomerLogin(WebDriver driver) {
        super(driver);
    }

    public void clickCustomerLogin(){
        waitForPageLoad();
        waitForElementToBeClickable(customerLoginButton);
        customerLoginButton.click();
        wait.withTimeout(Duration.ofSeconds(5));
    }


    public void selectCustomer(String customerName) {
        customerSelect.sendKeys(customerName);
        customerSelect.submit();
    }



}

