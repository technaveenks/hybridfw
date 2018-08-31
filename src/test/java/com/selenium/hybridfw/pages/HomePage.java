package com.selenium.hybridfw.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.hybridfw.utils.WebDriverHelper;

public class HomePage extends BasePage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='body-section']/div[1]/div/div/div[1]/div/ul/li[4]/a")
	private WebElement _carsTab;

	@FindBy(xpath = "//*[@id='s2id_autogen10']/a/span[1]")
	private WebElement _location;
	
	@FindBy(xpath="//*[@id='select2-drop']/div/input")
	private WebElement _locationSearch;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li/ul")
	private WebElement _autoSelectLocation;
	
	@FindBy(xpath="//*[@id='HOTELS']/form/div[3]/div[3]/button")
	private WebElement _search;
	
	@FindBy(xpath="//*[@id='body-section']/div[5]/div[3]/div/h1")
	private WebElement _locationResults;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public CarsPage clickOnCars() {
		System.out.println("in clickOnCars() Method");
		_carsTab.click();

		System.out.println("Executed");

		return new CarsPage(getDriver());

	}

	public void enterLocation(String Location) throws InterruptedException {
		_location.click();
		_locationSearch.sendKeys(Location);
		//implicitWaits();	
		Thread.sleep(3000);
		_autoSelectLocation.click();
	}

	public HotelsPage clickOnSearch() {
		_search.click();
		return new HotelsPage(getDriver());
	}
	
	public String getResults(){
		String results = _locationResults.getText();
		return results;
	}
	
	public void implicitWaits(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
