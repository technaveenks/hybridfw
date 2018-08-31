package com.selenium.hybridfw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsPage extends BasePage{
	

	public HotelsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="/html/body/div[6]/div/div/div[2]/a/img")
	private WebElement _logo;
	
	public HomePage clickOnLogo(){
		_logo.click();
		/*String loginBtn=System.getProperty("loginBtn");
		driver.findElement(By.xpath(loginBtn)).click();*/
		return new HomePage(getDriver());
	}

}
