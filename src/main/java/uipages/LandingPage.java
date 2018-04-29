package uipages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class LandingPage extends Base {
	
	@FindBy(name="username")
	WebElement usrname;
	
	@FindBy(name="password")
	WebElement passwd;
	
	@FindBy(xpath="//input[contains(@value,'Login')]")
	WebElement login;
	
	
	public LandingPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	

	public void login(String username,String password){
		
	this.usrname.sendKeys(username);
	this.passwd.sendKeys(password);
	this.login.click();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
	}
	
	
}
