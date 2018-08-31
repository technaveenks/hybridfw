package com.selenium.hybridfw.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverHelper {
	
	protected static Properties _userProperties = new Properties();
	

	static WebDriver driver = null;
	
	public WebDriverHelper() throws IOException{
		loadProperties();
	}

	private static Properties loadProperties() throws IOException {
		try{
			FileInputStream configStream = new FileInputStream("config.user.properties");
			_userProperties.load(configStream);
			return _userProperties;
		} catch (FileNotFoundException e){
			System.out.println("No config file Found");
		}
		return _userProperties;
		
	}
	
	public static String getStringProperty(String propertyname) throws FileNotFoundException{
		try{
			_userProperties = loadProperties();
		}catch(IOException e){
			e.printStackTrace();
		}
		String returnValue = _userProperties.getProperty(propertyname);
		return returnValue;
	}

	public static WebDriver createDriver() throws FileNotFoundException {
		if (driver == null) {
			String browser = getStringProperty("browser");
			if(browser.contains("chrome")){
				System.setProperty("webdriver.chrome.driver",
						"C:/Users/Hp/Appium_Demo/hybridfw/src/test/java/resources/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.contains("Firefox")){
				System.setProperty("webdriver.gecko.driver",
						"C:/Users/Hp/Appium_Demo/hybridfw/src/test/java/resources/chromedriver.exe");
				driver= new FirefoxDriver();
			}
			else{
				System.out.println("No Browser found");
			}
			/*System.setProperty("webdriver.chrome.driver",
					"C:/Users/Hp/Appium_Demo/hybridfw/src/test/java/resources/chromedriver.exe");
			driver = new ChromeDriver();*/
			//driver.navigate().to("http://phptravels.net");
			driver.navigate().to(getStringProperty("url"));
			driver.manage().window().maximize();
		}
		return driver;

	}
	public static void getscreenshot() throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Hp\\Appium_Demo\\hybridfw\\screenshots\\failure"+System.currentTimeMillis()+".png"));
	}

	public static void getscreenshot(String MethodName) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Hp\\Appium_Demo\\hybridfw\\screenshots\\screenshot.png"));
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Hp\\Appium_Demo\\hybridfw\\screenshots\\"+MethodName+".png"));
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\Hp\\Appium_Demo\\hybridfw\\screenshots\\"+System.currentTimeMillis()+".png"));
		/* try {
			 	String filePath="C:\\Users\\Hp\\Appium_Demo\\hybridfw\\screenshots\\";
				FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
 }*/
	}
	
	

}
