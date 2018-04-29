package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import customListner.WebEventListener;

public class Base {
	public static WebDriver driver;
	public static FileInputStream fis;
	public String path="log4j.properties";
	public static final Logger log=Logger.getLogger(Base.class.getName());
	public static Properties prop;
	public static EventFiringWebDriver evd=null;
	public static WebEventListener listener=null;
	public String Browser="firefox";
	
	
	
	
	public void  Base(){
		
		PropertyConfigurator.configure("log4j.properties");
		
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.getProperty("user.dir"));
		log.info(Base.class.getName().toString());
		log.info("printing");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	
	public void init(){
	//	  Browser=prop.getProperty("browser");
		if(Browser.equalsIgnoreCase("firefox")){
			
			driver=new FirefoxDriver();
			driver.get("http://freecrm.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			evd=new EventFiringWebDriver(driver);
			listener=new WebEventListener();
			evd.register(listener);
			driver=evd;
			log.info(Base.class.getName().toString());
			log.info("printing");
			
			
		}
		
		
		
	}
	
}
