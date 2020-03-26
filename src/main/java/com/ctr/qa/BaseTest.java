package com.ctr.qa;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ctr.tests.ExtentReportClass;
import com.ctr.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest extends ExtentReportClass{

	static AppiumDriver<MobileElement> driver;
	protected static Properties props;
	InputStream inputStream;
	URL url;
	protected static String platForm;
	
	public BaseTest()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@BeforeTest
	public void setup() throws Exception
	{
		
		try 
		{
		props = new Properties();
		String propFileName = "config.properties";
		
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		props.load(inputStream);
		
		DesiredCapabilities cap = new DesiredCapabilities();

		//		-----------------FOR REAL DEVICE----------------
		/*cap.setCapability(MobileCapabilityType.UDID, props.getProperty("udid"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("realDeviceName"));
		cap.setCapability(MobileCapabilityType.VERSION, props.getProperty("androidVersion"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, props.getProperty("androidPlatformName"));
		cap.setCapability("appPackage", props.getProperty("androidAppPackage"));
		cap.setCapability("appActivity", props.getProperty("androidAppActivity"));*/
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, props.getProperty("platformName"));
		platForm = props.getProperty("platformName");

		switch (platForm)
		{
		case "Android":
			
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("androidAutomationName"));
			cap.setCapability("appPackage", props.getProperty("androidAppPackage"));
			cap.setCapability("appActivity", props.getProperty("androidAppActivity"));
//			cap.setCapability("avd", props.getProperty("emulatorDeviceName"));
//			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
			String currentDir = System.getProperty("user.dir");
			String androidAppLocation = currentDir+props.getProperty("androidAppLocation");
			System.out.println("androidAppLication "+androidAppLocation);
			cap.setCapability(MobileCapabilityType.APP, androidAppLocation);

			url = new URL(props.getProperty("appiumURL"));
			driver = new AppiumDriver<MobileElement>(url, cap);
//			String sessionId = driver.getSessionId().toString();
			
		break;
		
		case "iOS":
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("iOSAutomationName"));
			cap.setCapability("bundleId", props.getProperty("iOSBundleId"));
			String iOSAppLocation= getClass().getResource(props.getProperty("androidAppLocation")).getFile();
			cap.setCapability(MobileCapabilityType.APP, iOSAppLocation);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

			url = new URL(props.getProperty("appiumURL"));
			driver = new IOSDriver<MobileElement>(url, cap);
			break;
			
			default:
			throw new Exception("Invalid platform---- "+props.getProperty("platformName"));
		
		}
		
		}
		catch (Exception e)
		{
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw e;
			
		}
	}
	
	public void waitForElementToBeClickable(MobileElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void waitForVisibility(MobileElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
		try {
		wait.until(ExpectedConditions.visibilityOf(e));
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void click(MobileElement e) throws InterruptedException
	{
		waitForVisibility(e);
		waitForElementToBeClickable(e);
		e.click();
	}
	
	public void sendKeys(MobileElement e, String txt)
	{
		waitForVisibility(e);
		waitForElementToBeClickable(e);
		e.sendKeys(txt);
	}
	
	public void clear(MobileElement e)
	{
		waitForVisibility(e);
		waitForElementToBeClickable(e);
		e.clear();
	}
	
	public String getAttribute(MobileElement e,String attribute)
	{
		waitForVisibility(e);
		waitForElementToBeClickable(e);
		return e.getAttribute(attribute);
	}
	
	public String getText(MobileElement e)
	{
		switch(platForm)
		{
		case "Android":
			return getAttribute(e, "text");
		case "iOS":
			return getAttribute(e, "label");
		}
		return null;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
