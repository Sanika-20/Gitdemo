package Qualityqa.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.Duration;

public class AmazonTest {
	
	public static void main(String[] args) {
        // Setup WebDriver
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Setup ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("AmazonAutomationReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        ExtentTest test = extent.createTest("Amazon Automation Test");
        
        try {
            // Navigate to Amazon
            driver.get("https://www.amazon.com");
            test.pass("Navigated to Amazon");

            // Login to Amazon
            WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
            signInButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
            emailField.sendKeys("9518937126");
            driver.findElement(By.id("continue")).click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
            passwordField.sendKeys("Sanika@07");
            driver.findElement(By.id("signInSubmit")).click();
            test.pass("Logged in to Amazon");

            // Search for TV
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("tv");
            searchBox.submit();
            wait.until(ExpectedConditions.titleContains("tv"));
            test.pass("Searched for TV");

            // Search for Shoes
            searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.clear();
            searchBox.sendKeys("shoe");
            searchBox.submit();
            wait.until(ExpectedConditions.titleContains("shoe"));
            test.pass("Searched for Shoes");

            // Search for iPhone 15
            searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.clear();
            searchBox.sendKeys("iPhone 15");
            searchBox.submit();
            wait.until(ExpectedConditions.titleContains("iPhone 15"));
            test.pass("Searched for iPhone 15");

            // Add iPhone 15 to cart
            WebElement firstIPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")));
            firstIPhone.click();
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
            addToCartButton.click();
            test.pass("Added iPhone 15 to cart");

            // Proceed to Buy
            WebElement cartButton = driver.findElement(By.id("nav-cart"));
            cartButton.click();
            WebElement proceedToBuyButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("proceedToRetailCheckout")));
            proceedToBuyButton.click();
            test.pass("Proceeded to Buy");

        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        } finally {
            // Close the driver
            driver.quit();
            extent.flush();
        }
    }
}

}
