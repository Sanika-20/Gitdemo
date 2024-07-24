package Qualityqa.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test; 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;

public class AmazonAutomationTest
{    
	WebDriver driver;    
	ExtentReports extent;   
	ExtentTest test;   
	
	@BeforeClass
	public void setup() throws InterruptedException {        
		
		// Set the path of the ChromeDriver executable  
		
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");  
		
		// Initialize WebDriver      
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		
		// Initialize ExtentReports
    ExtentSparkReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");        
	htmlsparkReporter.config().setDocumentTitle("Amazon Automation Report");    
    htmlReporter.config().setReportName("Amazon Functional Test");       
	htmlReporter.config().setTheme(Theme.STANDARD);       
	extent = new ExtentReports();        
	extent.attachReporter(htmlReporter);      
	extent.setSystemInfo("Tester", "Your Name");        
test = extent.createTest("AmazonAutomationTest");  
		
		}    
	
	    @Test(priority = 1)
	     public void navigateToAmazon()
		{        
	    	test.info("Navigating to Amazon");    
	    	driver.get("https://www.amazon.com");      
	    	String title = driver.getTitle();      
	    	Assert.assertTrue(title.contains("Amazon"), "Title does not contain 'Amazon'");  
	    	test.pass("Navigated to Amazon successfully"); 
	    	}    
	    
	    @Test(priority = 2)
	    public void loginToAmazon()
	    {     
	    	////test.info("Logging into Amazon");   
	    	driver.findElement(By.id("nav-link-accountList")).click();    
	    	driver.findElement(By.id("ap_email")).sendKeys("your-email@example.com");    
	    	driver.findElement(By.id("continue")).click();     
	    	driver.findElement(By.id("ap_password")).sendKeys("your-password");    
	    	driver.findElement(By.id("signInSubmit")).click();   
	    	
	    	// Verify login by checking for an element that's only present when logged in
	    	WebElement accountElement = driver.findElement(By.id("nav-link-accountList-nav-line-1"));    
	    	Assert.assertTrue(accountElement.isDisplayed(), "Login failed");       
	    	test.pass("Logged into Amazon successfully");  
	    	}   
	    
	    @Test(priority = 3)
	    public void searchForTV() throws InterruptedException 
	    {       
	    	test.info("Searching for TV");     
	    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));  
	    searchBox.sendKeys("TV");       
	    searchBox.submit();  
	    
	    // Optionally, wait for results to load and print the title    
	    Thread.sleep(2000);       
	    Assert.assertTrue(driver.getTitle().contains("TV"), "Search results page title does not contain 'TV'");      
	    test.pass("Searched for TV successfully");  
	    }    
	    
	    @Test(priority = 4)
	    public void searchForShoes() throws InterruptedException 
	    {       
	    	test.info("Searching for Shoes");    
	    	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));   
	    	searchBox.clear();     
	    	searchBox.sendKeys("Shoes");      
	    	searchBox.submit();    
	    	
	    	// Optionally, wait for results to load and print the title     
	    	Thread.sleep(2000);      
	    	Assert.assertTrue(driver.getTitle().contains("Shoes"), "Search results page title does not contain 'Shoes'"); 
	    	test.pass("Searched for Shoes successfully"); 
	    	} 
	    @Test(priority = 5)public void searchForPhone() throws InterruptedException
	    { 
	    	test.info("Searching for Phone");
	    	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	    	searchBox.clear(); searchBox.sendKeys("Phone"); 
	    	searchBox.submit(); 
	    	
	    	// Optionally, wait for results to load and print the title 
	    	Thread.sleep(2000);
	    	Assert.assertTrue(driver.getTitle().contains("Phone"), "Search results page title does not contain 'Phone'");
	    	test.pass("Searched for Phone successfully"); 
	    	} 
	    
	    @Test(priority = 6)
	    public void addPhoneToCart() throws InterruptedException 
	    { 
	    	test.info("Adding first phone to cart"); 
	    	WebElement firstPhone = driver.findElement(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")); 
	    	firstPhone.click();
	    	
	    	// Switch to the new tab if a new tab is opened
	    	for (String handle : driver.getWindowHandles()) {
	    		driver.switchTo().window(handle);
	    		} 
	    	WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button")); 
	    	addToCartButton.click(); 
	    	
	    	// Optionally, wait for the cart page to load and print the title
	    	Thread.sleep(2000);
	    	Assert.assertTrue(driver.getTitle().contains("Amazon.com Shopping Cart"), "Cart page title does not contain 'Shopping Cart'");
	    	test.pass("Added phone to cart successfully");
	    	} 
	    
	    @AfterClass
	    public void tearDown() { 
	    	
	    	// Close the browser 
	    	driver.quit(); 
	    	// Generate the report 
	    	extent.flush(); }
	    
	}



