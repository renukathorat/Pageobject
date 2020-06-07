package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  LandingPage {
	public WebDriver driver;
	
	
	@FindBy(xpath="//a[@class='login']")
	WebElement gtSignIn;

	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void contactus()
	{
		
	}
    
	public void goToSignIn()
	{   
		
	
		gtSignIn.click();

	}
	public void searchButton()
	{
		
	}
	public void popularbutton()
	{
		
	}
	public void BestSeller()
	{
}
}
