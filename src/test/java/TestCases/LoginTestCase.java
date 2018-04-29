package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uipages.LandingPage;
import uipages.Login;
import TestBase.Base;

public class LoginTestCase extends Base {
	public LandingPage lo;
	
	public LoginTestCase(){
		
		super();
		
	}

	
	
	@BeforeMethod
	
	public void beforeMethod(){
		
		init();
		lo=new LandingPage();
		
	}
	
	
	@Test
	
	public void test1() throws InterruptedException{
		
		lo.login("naveenk", "test@123");
		Thread.sleep(8000);
		
		
	}
	
	
	@AfterMethod
	
	
	public void after(){
		driver.close();
		
	}
}
