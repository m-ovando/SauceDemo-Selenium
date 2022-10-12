package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername (String username) {
        //TODO: Wait for input to be clickable
        WebElement userfield = webDriver.findElement(By.xpath("//input[@id = 'user-name']"));
        userfield.clear();
        userfield.sendKeys(username);
    }

    public void setPassword (String pass) {
        //TODO: Wait for input to be clickable
        WebElement passfield = webDriver.findElement(By.xpath("//input[@id = 'password']"));
        passfield.clear();
        passfield.sendKeys(pass);
    }

    public void clickLoginButton() {
        //TODO: Wait for button to be clickable
        WebElement loginButton = webDriver.findElement(By.xpath("//input[@id = 'login-button']"));
        loginButton.click();
    }

    public WebElement getErrorMessage() {
        //TODO: Wait for message to be displayed
        WebElement errorMessage = webDriver.findElement(By.xpath("//*[contains(@class, 'error-message-container')]/h3[@data-test = 'error']"));

        return new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(errorMessage));
    }
}
