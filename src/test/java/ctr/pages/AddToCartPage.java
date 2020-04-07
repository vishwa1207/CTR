package ctr.pages;

import java.util.List;

import ctr.driver.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage  extends BaseTest{



	//@iOSXCUITBy(id="Allow")
	//private MobileElement allowNotification;

	@iOSXCUITFindBy(accessibility="Allow")
	private MobileElement allowNotification;

	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_always_button")
	private MobileElement allowAlwaysButton;
	
	@AndroidFindBy(id="ca.triangle.retail.canadiantire.uat15:id/icon")
	private List<MobileElement> firstIcon;


	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")//com.android.packageinstaller:id/permission_allow_button
	private MobileElement LocationPermission;
	
	public List<MobileElement> getFirstIcon() {
		return firstIcon;
	}

	public MobileElement getAllowAlwaysButton() {
		return allowAlwaysButton;
	}

	public MobileElement getAllowAlwaysButtonOnLocation() {
		return LocationPermission;
	}

	public MobileElement getAllowForNotification() {
		return allowNotification;
	}

}
