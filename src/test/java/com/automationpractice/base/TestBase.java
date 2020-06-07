package com.automationpractice.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
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
	public static Logger logger;



	public WebDriver initbr()
	{
		logger=Logger.getLogger("PageObjectPattern");
		PropertyConfigurator.configure("log4j.properties");

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
	   public String captureScreenShot(String methodName, WebDriver driver) throws IOException {
		   
//		   TakesScreenshot ts = (TakesScreenshot) driver;
//	        File source = ts.getScreenshotAs(OutputType.FILE);
//	        String dest = System.getProperty("user.dir")+"/screenshots/"+ methodName+ ".png";
//	        File destination = new File(dest);
//	        FileUtils.copyFile(source, destination);
	 
//	        return dest;
		   
		   WebDriver augment = new Augmenter().augment(driver);
	        TakesScreenshot scrShot = ((TakesScreenshot) augment);
	        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
	        SrcFile.renameTo(new File("./screenshots/" + methodName + ".jpeg"));
	        return null;
	    	

}
}
