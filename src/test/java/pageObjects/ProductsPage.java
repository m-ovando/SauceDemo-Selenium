package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriver webDriver;

    public ProductsPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductBanner() {

        WebElement productBanner = webDriver.findElement(By.xpath("//*[contains(@class, 'header_secondary_container')]/span[text() = 'Products']"));

        return new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(productBanner));
    }
}
