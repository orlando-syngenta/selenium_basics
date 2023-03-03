package test_cases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class LoginTestCase {
    private LoginPage loginPage;

    @BeforeEach
    private void setDriver()
    {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver");
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, wait);
    }

    @Test
    public void loginTest()
    {
        loginPage.validLoginTest();
    }

    @Test
    public void invalidLoginTest()
    {
        loginPage.invalidLoginTest();

    }

    public static void main(String[] args) {

    }
}