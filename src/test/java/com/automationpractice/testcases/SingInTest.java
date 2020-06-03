package com.automationpractice.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.pages.LandingPage;
import com.automationpractice.pages.SingInPage;

public class SingInTest extends TestBase{
	public WebDriver driver;
	
	
	
	@BeforeTest
	public void intializeDriver()
	{
		
		 driver=initbr();
	
	
	}
	
	@Test
	public void gotosignin()
	{
		LandingPage lp = new LandingPage(driver);
		lp.goToSignIn();
	}
	
	@Test
	public void registeredcredentials()
	
	{
		SingInPage sn = new SingInPage(driver);
	    sn.getEmail(email); 
		sn.getPassword(passwrd);
	    sn.singInButton();
		
		
	}
	
	

}
