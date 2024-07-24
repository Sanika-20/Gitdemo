package Test;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Browser {
	// private static final Function ExpectedConditons. = null;
	WebDriver wd;
	 //WebDriverWait wdw;
	 WebElement we;
	 
	@BeforeTest
	public void openBrowser() {
	 wd = new ChromeDriver();
	 wd.manage().window().maximize();
	 wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	 wd.get("https://www.facebook.com/");
	
	 
	}
	@Test
	public void testConditons() throws InterruptedException {
		wd.findElement(By.id("email")).sendKeys("saddf@gmail.com");
		wd.findElement(By.id("pass")).sendKeys("12345678");
		wd.findElement(By.name("login")).click();
		
	}
	
	@AfterTest
	public void closeBrowser() {
		wd.quit();
	}

}
