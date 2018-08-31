package com.selenium.hybridfw.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	private WebDriver driver;
	
	@BeforeClass
	public void beforeAllClasses() throws Exception{
		driver= WebDriverHelper.createDriver();
	}
	

	public WebDriver getDriver(){
		return driver;
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	

}
