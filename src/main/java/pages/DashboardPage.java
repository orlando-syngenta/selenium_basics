package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void validateSuccessfulLogin() {
        String cartIcon = "//a[@class='shopping_cart_link']";
        String sortDropDown = "//div[@class='header_container']/div[2]/div/span";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartIcon)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sortDropDown)));

        driver.quit();
    }
}