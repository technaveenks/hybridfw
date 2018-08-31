package com.selenium.hybridfw.pages;

import org.openqa.selenium.WebDriver;

public class CarsPage extends BasePage{
	
	public CarsPage(WebDriver driver){
		super(driver);
	}

	public void selectItem() {
		System.out.println("Navigated to Cars Page");
		
	}

}
