package com.selenium.hybridfw.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.hybridfw.pages.CarsPage;
import com.selenium.hybridfw.utils.BaseTest;

public class CarsTests extends BaseTest{
	
	CarsPage carsPage;
	@Test(priority=1)
	public void browser_launch(){
	
		
		System.out.println("Cars Test 1 Executed");
		
		
	}
	
	@Test(priority=2)
	public void browser_launch2(){
	
		
		System.out.println("Cars Test 2 Executed");
		
		
	}
	
	@BeforeClass
	public void setup(){
		
		//logic to navigate to HomePage
		
		carsPage = new CarsPage(getDriver());
		
	}

}
