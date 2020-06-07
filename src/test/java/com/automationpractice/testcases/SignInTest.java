package com.automationpractice.testcases;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.pages.LandingPage;
import com.automationpractice.pages.SingInPage;




public class SignInTest extends TestBase
{
	public WebDriver driver;
//	public static Logger logger = LogManager.getLogger("PageObjectPattern");	
//	PropertyConfigurator.configure("log4j2.properties");
//	
	@BeforeTest
	public void intializeDriver()
	{
		 driver=initbr();
		 logger.info("driver is intialized");
		 logger.error("abcd");
		 logger.warn("hi");
		 logger.fatal("shaajshk");
		 System.out.println(System.getProperty("user.dir"));
	}
	
	
	@Test
	public void registeredcredentials() throws InterruptedException
	
	{   
		LandingPage lp = new LandingPage(driver);
	    lp.goToSignIn(); 	
	    SingInPage sn = new SingInPage(driver);
	    sn.getEmail(email); 
		sn.getPassword(passwrd);
	    sn.singInButton();
	    
		
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
	

}
