package SeleniumWebDriverDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerceSearchTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://example-ecom.com");
    }

    @Test
    public void testProductSearch() {
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        // Verify search results
        WebElement resultsHeader = driver.findElement(By.cssSelector("h1.search-results"));
        Assert.assertTrue(resultsHeader.getText().contains("laptop"), 
            "Search results header should contain 'laptop'");

        // Verify at least one product is displayed
        WebElement firstProduct = driver.findElement(By.cssSelector(".product-item:first-child"));
        Assert.assertTrue(firstProduct.isDisplayed(), 
            "At least one product should be displayed in search results");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}