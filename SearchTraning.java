package SeleniumWebDriverDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTraning {
	
	WebDriver driver;
	
	// Launching the firefox browser
	
	public void LaunchBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.simplilearn.com/");
		
	}
	// Searching selenium training and clicking on it
	
	public void search() throws InterruptedException {
		
		driver.findElement(By.id("header_srch")).sendKeys("Selenium");
		Thread.sleep(3000);
		driver.findElement(By.xpath("search_icon input-search-icon")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("Automation Testing Masters Program")).click();
		System.out.println("The page is :" +driver.getTitle());
	}
	
	//Close the browser 
	
	public void closebrowser() {
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		SearchTraning obj =new SearchTraning();
		obj.LaunchBrowser();
		obj.search();
		obj.closebrowser();
		

	}

}
