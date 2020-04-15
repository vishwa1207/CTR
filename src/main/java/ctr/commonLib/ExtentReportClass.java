package ctr.commonLib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ctr.driver.BaseTest;
import org.testng.annotations.BeforeSuite;

public class ExtentReportClass extends BaseTest {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	protected static String oSname = System.getProperty("os.name");
	protected static String javaVersion = System.getProperty("java.runtime.version");
	protected static String userName = System.getProperty("user.name");
	protected static String osVersion = System.getProperty("os.version");
	
	@BeforeSuite
	public void reportSetup()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		String dateValue = dateFormat.format(date); // 2016/11/16 12:08:43
		String classNameWithPackage = getClass().getName();
		String className = classNameWithPackage.substring(16);

		htmlReporter = new ExtentHtmlReporter("./Reports/CTR" + "_" + dateValue + ".html");

		
//		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("User Name is ", userName);
		extent.setSystemInfo("OS Name is ", oSname);
		extent.setSystemInfo("OS Version is ", osVersion);
		extent.setSystemInfo("Java Version is ", javaVersion);
	}
	

	@AfterSuite
	public void reportTeardown()
	{
		extent.flush();
		System.out.println("flushed the report");
	}
	
	
	public void reportMethodName(String methodNameinfo, String methodDetails)
	{
		logger = extent.createTest(methodNameinfo,methodDetails);
	}
}
