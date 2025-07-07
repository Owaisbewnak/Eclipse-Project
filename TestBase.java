package SeleniumWebDriverDemo;

//TestBase.java - Core setup
public class TestBase {
 WebDriver driver;
 
 @BeforeSuite
 public void setup() {
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 }
 
 @AfterSuite
 public void teardown() {
     driver.quit();
 }
}

//CheckoutTest.java - Sample test case
public class CheckoutTest extends TestBase {
 @Test
 public void completePurchaseFlow() {
     // Product search
     driver.get("https://ecom-site.com");
     driver.findElement(By.id("search-box")).sendKeys("Wireless Headphones");
     driver.findElement(By.cssSelector(".search-btn")).click();
     
     // Add to cart
     WebElement firstProduct = driver.findElement(By.xpath("//div[@class='product'][1]"));
     firstProduct.findElement(By.className("add-to-cart")).click();
     
     // Checkout process
     driver.findElement(By.id("checkout-btn")).click();
     driver.findElement(By.name("email")).sendKeys("test@example.com");
     // ... additional checkout steps
     
     // Assertion
     String confirmation = driver.findElement(By.cssSelector(".order-confirmation")).getText();
     Assert.assertTrue(confirmation.contains("Thank you"), "Purchase confirmation missing");
 }
}

//pom.xml (Maven dependencies)
<dependencies>
 <dependency>
     <groupId>org.seleniumhq.selenium</groupId>
     <artifactId>selenium-java</artifactId>
     <version>4.8.0</version>
 </dependency>
 <dependency>
     <groupId>org.testng</groupId>
     <artifactId>testng</artifactId>
     <version>7.7.0</version>
 </dependency>
</dependencies>
