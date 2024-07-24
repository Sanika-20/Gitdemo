package Test;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected", true);
	}
	
	@BeforeTest
	public void launchBrowser() {
		Reporter.log("browser launch", true);
	}
	
	@BeforeMethod
	public void login() {
		Reporter.log("customer loged in", true);
	}
	
	@Test
	public void created() {
		Reporter.log("customer created", true);
		
	}
	
	@AfterMethod
	public void logout() {
		Reporter.log("customer logout", true);
	}
	
	@AfterTest
	public void browserClose() {
		Reporter.log("browser closed", true);
	}
	
	@AfterSuite
	public void notConnected() {
		Reporter.log("databse disconnected", true);
	}
	
}
