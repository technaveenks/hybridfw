package com.selenium.hybridfw.tests;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.selenium.hybridfw.pages.CarsPage;
import com.selenium.hybridfw.pages.HomePage;
import com.selenium.hybridfw.pages.HotelsPage;
import com.selenium.hybridfw.utils.BaseTest;
import com.selenium.hybridfw.utils.DataUtility;
import com.selenium.hybridfw.utils.WebDriverHelper;
//@Listeners(com.selenium.hybridfw.utils.Listeners.class)	
public class HomeTests extends BaseTest {
	BaseTest test;
	HomePage homePage;
	CarsPage carsPage;
	WebDriver driver;
	HotelsPage hotelsPage;
	private static final Logger log = LogManager.getLogger(HomeTests.class);
	@DataProvider(name = "Locations")

	public static Object[][] Locations() {
		return new Object[][] { { "Bangalore"}, { "Chennai"}, { "New Delhi"}};
	}
	SoftAssert assertion = new SoftAssert();
	
	@Test
	public void logValidation(){
		log.info("This is an info log");
		log.warn("this is a warning log");
		log.error("this is a error log");
	}
	
	@Test
	public void logValidation2(){
		log.info("This is an info log");
		log.warn("this is a warning log");
		log.error("this is a error log");
	}
	
	@Test
	public void logValidation3(){
		log.info("This is an info log");
		log.warn("this is a warning log");
		log.error("this is a error log");
	}
	
	@Test
	public void verify_data() throws Exception{
		DataUtility.setExcelFile();
		//System.out.println("===================="+DataUtility.setExcelFile());
		
		log.info(" Test case Started");
		log.info(" Navigated to PHP Travels.net");
		homePage.enterLocation(DataUtility.getCellData(2, 1));
		log.info(" Entered Location");
		hotelsPage = homePage.clickOnSearch();
		Assert.assertEquals(homePage.getResults(),DataUtility.getCellData(2, 2) );
		homePage = hotelsPage.clickOnLogo();
		//WebDriverHelper.getscreenshot();
		DataUtility.setCellData("Pass", 2, 3);
		System.out.println("executed");
		
	}
	
	@Test
	@Parameters({ "hotelLocation" , "results"})
	public void verify_parameter(String Location, String ExpectedResult) throws Exception {
		log.info(" Test case Started");
		log.info(" Navigated to PHP Travels.net");
		homePage.enterLocation(Location);
		log.info(" Entered Location");
		hotelsPage = homePage.clickOnSearch();
		Assert.assertEquals(homePage.getResults(), ExpectedResult);
		homePage = hotelsPage.clickOnLogo();
		//WebDriverHelper.getscreenshot();
		System.out.println("executed");
	/*	SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(true, false);
		assertion.assertEquals(false, false);
		assertion.assertEquals(true, true);
		assertion.assertAll();
		
		assertion.assertEquals(true, true);
		System.out.println("Assertion 1");
		assertion.assertEquals(true, false);
		System.out.println("Assertion 2");
		assertion.assertEquals(true, true);
		System.out.println("Assertion 3");
		assertion.assertAll();*/
		
	}

	@Test(dataProvider = "Locations", enabled=true)
	public void verify(String Location) throws InterruptedException {
		System.out.println("executed");
		System.out.println(" data provider "+ Location);
		/*homePage.enterLocation(Location);
		hotelsPage = homePage.clickOnSearch();
		Assert.assertEquals(homePage.getResults(), "No Results!!");
		homePage = hotelsPage.clickOnLogo();
		assertion.assertEquals("", "");*/
	}

	@BeforeClass
	public void setup() {
		homePage = new HomePage(getDriver());
	}

}
