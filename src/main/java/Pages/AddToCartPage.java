package Pages;

import Driver.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class AddToCartPage  extends BaseTest{
	//	@iOSXCUITBy(id="")
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_one_time_button")//com.android.packageinstaller:id/permission_allow_button
	private MobileElement onlyThisTimeButton;

	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")//com.android.packageinstaller:id/permission_allow_button
	private MobileElement LocationPermission;

	@AndroidFindBy(id="ca.triangle.retail.canadiantire.uat15:id/icon")
	private List<MobileElement> firstIcon;

	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Shop\"]")
	private MobileElement shopIcon;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Heating & Cooling']")
	private MobileElement heatingMenu;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Show All']")
	private MobileElement showallId;

	@AndroidFindBy(xpath="//com.google.android.material.chip.Chip[@text='Home Delivery']")
	private MobileElement HomeDelvery;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Portable Car Aroma Humidifier']")
	private MobileElement clickonItem;

	@AndroidFindBy(xpath="//android.widget.Button[@text='ADD 1 TO CART']")
	private MobileElement addToCart;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Cart\"]")
	private MobileElement cartBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Large']")
	private MobileElement selectSize;

	@AndroidFindBy(xpath="//android.widget.Button[@text='CHECKOUT']")
	private MobileElement checkoutBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Account')]")
	private MobileElement AccountButton;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Settings')]")
	private MobileElement Settings;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Notifications')]")
	private MobileElement NotificationButton;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Switch")
	private MobileElement SalesAlertToggleButton;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.Switch")
	private MobileElement PromotionToggleButton;



	public List<MobileElement> getFirstIcon() {
		return firstIcon;
	}

	public MobileElement getonlyThisTimeButton() {
		return onlyThisTimeButton;
	}

	public MobileElement getLocationPermission() {
		return LocationPermission;
	}
	public MobileElement getshopIcon() {
		return shopIcon;
	}

	public MobileElement getheatingMenu() {
		return heatingMenu;
	}

	public MobileElement getHomeDelvery() {
		return HomeDelvery;
	}

	public MobileElement getshowallId() {
		return  showallId;
	}

	public MobileElement getclickonItem() {
		return clickonItem;
	}

	public MobileElement getaddToCart() {
		return addToCart;
	}

	public MobileElement getcartBtn() {
		return cartBtn;
	}

	public MobileElement getcheckoutBtn() {
		return checkoutBtn;
	}

	public MobileElement getselectSize() {
		return selectSize;
	}

	public MobileElement getAccountButton() {
		return AccountButton;
	}

	public MobileElement getSettings() {
		return Settings;
	}

	public MobileElement getNotificationButton() {
		return NotificationButton;
	}

	public MobileElement getSalesAlertToggleButton() {
		return SalesAlertToggleButton;
	}

	public MobileElement getPromotionToggleButton() {
		return PromotionToggleButton;
	}



}
