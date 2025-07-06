package SeleniumWebDriverDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ebaySearch {
	WebDriver driver;
	
public void LaunchBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.ebay.com/");
		
	}

public void searchProduct() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.id("gh-ac")).sendKeys("JBL Speakers");
	driver.findElement(By.id("gh-search-btn")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Daily Deals")).click();
}
	public void navigate() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("https://www.simplilearn.com/");
		Thread.sleep(3000);
		driver.navigate().back();
		System.out.println("The title of this page is :" + driver.getTitle());
	}

	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ebaySearch obj = new ebaySearch();
		obj.LaunchBrowser();
		obj.searchProduct();
		obj.navigate();
		obj.closeBrowser();

	}

}
