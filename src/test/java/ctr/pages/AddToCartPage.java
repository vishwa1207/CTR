package ctr.pages;

import java.util.List;

import ctr.driver.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;

public class AddToCartPage  extends BaseTest{
//	@iOSXCUITBy(id="")
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_always_button")
	private MobileElement allowAlwaysButton;
	
	@AndroidFindBy(id="ca.triangle.retail.canadiantire.uat15:id/icon")
	private List<MobileElement> firstIcon;
	

	
	public List<MobileElement> getFirstIcon() {
		return firstIcon;
	}

	public MobileElement getAllowAlwaysButton() {
		return allowAlwaysButton;
	}


}
