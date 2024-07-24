package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown {
	WebDriver wd;

	@BeforeTest
	public void open() {
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wd.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");
		
	}
	
	@Test
	public void runTest() {
		//retreive all options from a drop down and print them one by one
		

		
	}
	
	@AfterTest
	public void close() {
		wd.quit();
	}
}
