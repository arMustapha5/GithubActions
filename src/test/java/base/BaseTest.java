package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
public class BaseTest {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage"
        ); // Run in headless mode (can be removed if not needed)


        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver(options);

        // Set implicit wait for the entire session
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // Replace with actual URL
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
