package com.automationpractice.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	 Properties prop;

	public ReadProp() 
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/properties/configuration.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	public String appUrl() {

		String URL = prop.getProperty("appurl");
		return URL;
	}

	public String getemail() {

		String email = prop.getProperty("eml");
		return email;
	}

	public String getpasswrd() {

		String passwrd = prop.getProperty("password");
		return passwrd;
	}

	public String getbrowser() {

		String browser = prop.getProperty("browser");
		return browser;
	}

	
}
