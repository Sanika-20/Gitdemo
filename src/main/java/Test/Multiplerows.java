package Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Multiplerows {
	WebDriver wd;

	@BeforeTest
	public void openChrome() {
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wd.get("https://cosmocode.io/automation-practice-webtable/");

	}

	@Test(priority = 1)
	public void testCondition() {
		
		List<WebElement> li = wd.findElements(By.tagName("tr"));
		int count = li.size();
		System.out.println(count);

		for (int j = 1; j <= count; j++) {
			for (int i = 1; i <= 5; i++) {
				String str = wd.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[" + j + "]/td[" + i + "]"))
						.getText();
				System.out.println(str);
			}
		}

	}

	@AfterTest
	public void close() {
		wd.quit();
	}

}
