package com.automationpractice.testcases;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.basepages.TopMainMenu;
import com.automationpractice.pages.LandingPage;
import com.automationpractice.pages.SingInPage;
import com.automationpractice.utilities.ExcelReader;

public class SignInExcelsheet extends TestBase {
	public WebDriver driver;

	@Test(dataProvider = "LoginData")

	public void logindata(String ename, String pwd) throws InterruptedException, IOException {
		driver = initbr();
		LandingPage lp = new LandingPage(driver);
		lp.goToSignIn();
		SingInPage sn = new SingInPage(driver);
		sn.getEmail(ename);

		sn.getPassword(pwd);
		sn.singInButton();
		Thread.sleep(3000);
		isLoginsuccessful();
		/*
		 * TopMainMenu tp = new TopMainMenu(driver); WebElement lout= tp.logout();
		 * sn.getEmail(UtilText.email);
		
		sn.getPassword(UtilText.passwrd);
		 */

	}

	@Test(enabled = false)
	public void isLoginsuccessful() throws IOException {
		TopMainMenu tp = new TopMainMenu(driver);
		WebElement lout = tp.getelement();
		boolean b = false;
		try {
			b = lout.isDisplayed();
		} catch (NullPointerException e) {
			// b=false;
		} catch (NoSuchElementException e) {
			// b=false;
		}

		if (b == true) {
			System.out.println("login successful");
		} else {
			captureScreenShot("isLoginsuccessful", driver);
			System.out.println("login unsuccessfull");
		}
	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws Exception {
		Object[][] data = new Object[2][2];
		String path = System.getProperty("user.dir") + "/src/test/resources/excel/LoginData.xlsx";
		ExcelReader er = new ExcelReader(path);
		int rownum;
		rownum = 2;
		// String logindata[][] = new String[rownum][colnum];
		/*
		 * for (int i = 1; i <= rownum; i++) { for (int j = 1; j <= colnum; j++) {
		 * data[i - 1][j - 1] = er.getCellData("Sheet1", "email_id", j);// 1 0
		 * System.out.println(data[i - 1][j - 1]); }
		 * 
		 * }
		 */

		for (int i = 0; i < rownum; i++) {
			data[i][0] = er.getCellData("Sheet1", "email_id", i + 2);
			data[i][1] = er.getCellData("Sheet1", "password", i + 2);
			// System.out.println(data[i][0]);
			// System.out.println(data[i][1]);

		}

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
