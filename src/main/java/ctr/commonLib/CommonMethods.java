package ctr.commonLib;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ctr.driver.BaseTest;
import io.appium.java_client.MobileElement;

public class CommonMethods extends BaseTest{
	
	 /* public static ReportLogger log = (ReportLogger) ReportLogger
	            .getLogger(CommonMethods.class.getName());*/
	
	
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
	
	
}
