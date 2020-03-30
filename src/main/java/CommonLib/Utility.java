package CommonLib;

import Driver.BaseTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility extends BaseTest {
	public static long WAIT = 30;

	public void waitForElementToBeClickable(MobileElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, Utility.WAIT);
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
		WebDriverWait wait = new WebDriverWait(driver, Utility.WAIT);
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

	public void Sleep(int millisecond) throws InterruptedException {

		Thread.sleep(millisecond);
	}

	public void Info(String detail) throws InterruptedException {

		logger.log(Status.INFO, detail);
	}

	public static void swipeup() {
		Dimension screenSize = driver.manage().window().getSize();

		int startX = 0;
		int endX = 0;
		int startY = 0;
		int endY = 0;
		endY = (int) (screenSize.height * 0.30);
		startY = (int) (screenSize.height * 0.70);
		startX = (screenSize.width / 2);
		endX = startX;

		new TouchAction((PerformsTouchActions) driver)
				.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(endX, endY))
				.release()
				.perform();
	}
}
