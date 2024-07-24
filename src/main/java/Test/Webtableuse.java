package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webtableuse {
	
	WebDriver wd;
	
	@BeforeTest
	public void openChrome() {
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wd.get("https://cosmocode.io/automation-practice-webtable/");
		
	}
	
	@Test
	public void runTest() {
		String  str = wd.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[2]/td[2]")).getText();
		System.out.println(str);
	}

	@AfterTest
	public void close() {
		wd.quit();
	}
}
