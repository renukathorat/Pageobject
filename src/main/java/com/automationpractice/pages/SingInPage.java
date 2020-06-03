package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInPage {
	public WebDriver driver;
	
 @FindBy(xpath="//input[@id='email']")
 WebElement emailId;
 
 @FindBy(css="input#passwd")
 WebElement password;
 
 @FindBy(xpath ="//button[@id='SubmitLogin']")  
 WebElement singinbutton;
 
 public SingInPage(WebDriver driver)
 {
	 this.driver= driver;
	 PageFactory.initElements(driver, this);
 }
 public void  getEmail(String uname)
 
 {   emailId.clear();
     emailId.sendKeys(uname);
 }
 
 public void getPassword (String paswrd )
 {
	 password.clear();
	 password.sendKeys(paswrd);
 }
 
 public void singInButton()
 {
	 singinbutton.click();
 }
}


