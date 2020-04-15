package ctr.driver;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import ctr.commonLib.ReportingUtil;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import ctr.commonLib.ExtentReportClass;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;


@RunWith(Cucumber.class)
@CucumberOptions (
        features = {"src/test/java/Features"},
        glue = {"ctr.testScripts"},
        tags = {"@CTR"},
		plugin = {
				"pretty",
				"html:target/site/cucumber-pretty",
				"json:target/cucumber.json",
		},
        monochrome = true)



public class BaseTest extends AbstractTestNGCucumberTests {
	
	private TestNGCucumberRunner testRunner;
	protected static AppiumDriver<MobileElement> driver;
	protected static Properties props;
	InputStream inputStream;
	URL url;
	protected static String platForm;
	
	
	public BaseTest()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AfterSuite
	public void generateReport(){

		ReportingUtil.generateJVMreport();
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
			System.out.println("Driver assigned");
			
		break;
		
		case "iOS":
			/*cap.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("deviceName"));
			cap.setCapability("platFormVersion", props.getProperty("platformVersion"));
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("automationName"));
			cap.setCapability(MobileCapabilityType.APP, props.getProperty("app"));
			//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");*/


			cap.setCapability("platformVersion",props.getProperty("platformVersion"));
			cap.setCapability("deviceName",props.getProperty("deviceName"));
			cap.setCapability("automationName",props.getProperty("automationName"));
			cap.setCapability("app",props.getProperty("app"));
			cap.setCapability("udid",props.getProperty("udid"));
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
	

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
