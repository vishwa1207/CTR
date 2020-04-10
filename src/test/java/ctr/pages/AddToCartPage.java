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


	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	@iOSXCUITFindBy(accessibility="Allow Once")
	private MobileElement allowLocationNotification;

	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_always_button")
	@iOSXCUITFindBy(accessibility="Allow")
	private MobileElement allowNotification;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"NEXT\"]")
	private MobileElement NextButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"FINISH\"]")
	private MobileElement FinishButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Welcome\"]/XCUIElementTypeOther[1]/XCUIElementTypeLink")//
	private MobileElement CancelButtonToReachHome;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Shop\"]")//
	private MobileElement ShopButton;

	@iOSXCUITFindBy(accessibility="Heating & Cooling")
	private MobileElement HeatingAndCoolingTab;

	@iOSXCUITFindBy(accessibility="Show All")
	private MobileElement ShowAllTab;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Home Delivery\"]")//
	private MobileElement HomedeliveryButton;

	@iOSXCUITFindBy(accessibility="What are you looking for?")
	private MobileElement Gotosearch;

	@iOSXCUITFindBy(accessibility="Search")
	private MobileElement SearchButton;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"ProductNameLabel\"])[1]")//
	private MobileElement SelectFirstItem;//

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeImage[@name=\"ItemImage\"])[22]")//
	private MobileElement SelectFirstItem1;

	@iOSXCUITFindBy(accessibility="ADD 1 TO CART")
	private MobileElement AddToCart;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Button\"]")//
	private MobileElement GotoShopCartPAge;


	public MobileElement getAllowForLocation() {
		return allowLocationNotification;
	}

	public MobileElement getAllowForNotification() {
		return allowNotification;
	}

	public MobileElement getNextButton() {
		return NextButton;
	}

	public MobileElement getFinishButton() {
		return FinishButton;
	}

	public MobileElement getCancelButtonToReachHome() {
		return CancelButtonToReachHome;
	}

	public MobileElement getShopButton() {
		return ShopButton;
	}

	public MobileElement getHeatingAndCoolingTab() {
		return HeatingAndCoolingTab;
	}

	public MobileElement getShowAllTab() {
		return ShowAllTab;
	}

	public MobileElement getHomedeliveryButton() {
		return HomedeliveryButton;
	}

	public MobileElement getGotosearch() {
		return Gotosearch;
	}

	public MobileElement getSearchButton() {
		return SearchButton;
	}

	public MobileElement getSelectFirstItem() {
		return SelectFirstItem;
	}

	public MobileElement getAddToCart() { return AddToCart; }

	public MobileElement getGotoShopCartPAge() {
		return GotoShopCartPAge;
	}
}
