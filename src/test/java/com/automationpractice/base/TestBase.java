package com.automationpractice.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.automationpractice.utilities.ReadProp;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class TestBase {
	
	ReadProp read = new ReadProp();
	public String url= read.appUrl();
	public String email=read.getemail();
	public String passwrd=read.getpasswrd();
	public static  WebDriver driver;
	public String br =read.getbrowser();


	public WebDriver initbr()
	{
	

		if (br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("IE"))
			{
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
		
	}
	

}
