package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demomultipletable {
	
	WebDriver wd; 
	
	@BeforeTest
	public void open() {
		
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wd.get("https://demoapps.qspiders.com/ui/table?");	
		
	}
	@Test
	public void runTest() {
		for (int j = 1; j <= count; j++) {
			for (int i = 1; i <= 5; i++) {
				
			}
				
			}
	}
	
	@AfterTest
	public void close() {
		wd.quit();
	}
	}
	

}
