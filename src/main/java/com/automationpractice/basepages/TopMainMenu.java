package com.automationpractice.basepages;



import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  TopMainMenu 
{
	public WebDriver driver;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement logOut;
		
	

	

	
	public TopMainMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		

	}

	public void contactus()
	{
		
	}
    
	public WebElement getelement()
	{  // try {
		return logOut;
	//}
	/*catch(NoSuchElementException e) {
		WebElement temp=null;
		return temp;
	}*/


	}
	

	

/*	public boolean isDisplayed() {
		
	boolean b;
	 try {
		 b=logOut.isDisplayed();
	    } 
	 catch (NoSuchElementException e) {
	        b=false;
	    }

		return b;
	
		} 
	
	*/
}


