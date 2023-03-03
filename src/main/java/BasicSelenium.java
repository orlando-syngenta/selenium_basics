import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasicSelenium {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    private void setDriver()
    {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver");
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }

    @Test
    public void validLoginTest() {
        WebElement userTextbox = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        String cartIcon = "//a[@class='shopping_cart_link']";
        String sortDropDown = "//div[@class='header_container']/div[2]/div/span";

        userTextbox.sendKeys("standard_user");
        passwordTextBox.sendKeys("secret_sauce");
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartIcon)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sortDropDown)));

        driver.quit();
    }

    @Test
    public void invalidLoginTest() {
        WebElement userTextbox = driver.findElement(By.xpath("//input[@name='user-name']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        String errorMessage = "//div[@id='login_button_container']/div/form/div[3]";
        String loginBtn = "//input[@name='login-button']";

        userTextbox.sendKeys("standard_user");
        passwordTextBox.sendKeys("secret_sauc");
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessage)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginBtn)));

        driver.quit();
    }
}