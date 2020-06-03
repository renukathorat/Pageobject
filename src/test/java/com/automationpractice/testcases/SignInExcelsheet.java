package com.automationpractice.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.pages.LandingPage;
import com.automationpractice.pages.SingInPage;
import com.automationpractice.utilities.ExcelReader;

public class SignInExcelsheet extends TestBase {
	public WebDriver driver;

	
	public void intializeDriver() {

		driver = initbr();

	}


	public void gotosignin() {
		LandingPage lp = new LandingPage(driver);
		lp.goToSignIn();
	}

	@Test(dataProvider = "LoginData")
	public void logindata(String ename,String pwd) throws InterruptedException {
		intializeDriver();
		gotosignin();
		SingInPage sn = new SingInPage(driver);
		sn.getEmail(ename);
		sn.getPassword(pwd);
		sn.singInButton();

	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws Exception {
		Object [][] data=new Object[2][2];
		String path = System.getProperty("user.dir") + "/src/test/resources/excel/LoginData.xlsx";
		ExcelReader er = new ExcelReader(path);
		int rownum;
		rownum = 2;
		//String logindata[][] = new String[rownum][colnum];
/*		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colnum; j++) {
				data[i - 1][j - 1] = er.getCellData("Sheet1", "email_id", j);// 1 0
				System.out.println(data[i - 1][j - 1]);
			}
			
		}*/
		
		for (int i=0;i<rownum;i++) {
			data[i][0]=er.getCellData("Sheet1", "email_id", i+2);
			data[i][1]=er.getCellData("Sheet1", "password", i+2);
			System.out.println(data[i][0]);
			System.out.println(data[i][1]);
			
		}
		
		return data;
	}
	

}
