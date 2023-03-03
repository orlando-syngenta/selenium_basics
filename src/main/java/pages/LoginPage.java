package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement userTextbox, passwordTextBox, loginButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        userTextbox = driver.findElement(By.xpath("//input[@id='user-name']"));
        passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
    }

    public void validLoginTest() {
        DashboardPage dashboardPage = new DashboardPage(driver, wait);

        userTextbox.sendKeys("standard_user");
        passwordTextBox.sendKeys("secret_sauce");
        loginButton.click();

        dashboardPage.validateSuccessfulLogin();

        driver.quit();
    }

    public void invalidLoginTest() {
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