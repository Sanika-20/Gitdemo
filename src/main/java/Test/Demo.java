package Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {
	
	@Test(priority = 1)
	public void create() {
		Reporter.log("hello", true);
	}
	
	@Test (priority = 2)
	public void delete() {
		Reporter.log("bye",true);
	}
	
	@Test(priority = 3)
	public void update() {
		Reporter.log("tata", true);
	}
	
	@Test(invocationCount = 5 ,priority = 4)
	public void add() {
		Reporter.log("sanika", true);
	}
	

}
