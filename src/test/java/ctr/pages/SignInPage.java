package ctr.pages;

import ctr.commonLib.CommonMethods;
import ctr.driver.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignInPage extends BaseTest{
//	@iOSXCUITBy(id="")
	CommonMethods commethod=new CommonMethods();
@AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_sign_in_button")//ca.triangle.retail.canadiantire.uat15:id/ctc_account_sign_out_btn
private MobileElement signIn;

	@AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_signin_email")
	private MobileElement UserID;

	@AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_signin_pass")
	private MobileElement Password;

	@AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_btn_signin")
	private MobileElement logInButton;

	@AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_account_navigation_entry_point")
	private MobileElement MyAccountPage;

	@AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_account_sign_out_btn")//android:id/button1
	private MobileElement signout;

	@AndroidFindBy(id = "android:id/button1")//android:id/button1
	private MobileElement signoutYes;

	public MobileElement getSignInButton() {
		return signIn;
	}

	public MobileElement getUserId() {
		return UserID;
	}

	public MobileElement getPassword() {
		return Password;
	}

	public MobileElement getlogin() {
		return logInButton;
	}

	public MobileElement getMyAccountPage() {
		return MyAccountPage;
	}

	public MobileElement getSignout() {
		return signout;
	}

	public MobileElement getSignoutYesbutton() {
		return signoutYes;
	}

}
