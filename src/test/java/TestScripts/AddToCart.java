package TestScripts;

import CommonLib.Utility;
import Driver.BaseTest;
import Pages.AddToCartPage;
import Pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AddToCart extends BaseTest{

	static AddToCartPage addToCartPage;

	Utility util =new Utility();
	@BeforeMethod
	public void beforeMethod(Method m)
	{
		addToCartPage = new AddToCartPage();
		System.out.println("Starting the method -->"+m.getName());
	}

	@Test(priority = 0)
	public void SignInandSignOut() throws InterruptedException {

		reportMethodName("LogIn and LogOut","To LogIn and LogOut");util.Sleep(5000);
		util.click(addToCartPage.getLocationPermission());
		util.Sleep(5000);
		SignInPage signin =new SignInPage();
		signin.LogIn();
		signin.LogOut();
		System.out.println("LoggedIn and LoggedOut Successfully");
	}


	@Test(priority = 1)
        public void addToCartFlow() throws InterruptedException {
	    reportMethodName("AddToCart","To test Add to Cart Flow");util.Sleep(5000);
		util.click(addToCartPage.getLocationPermission());
		util.Info("clicked on only this time button");
		util.Sleep(15000);
		util.click(addToCartPage.getshopIcon());
		util.Info("clicked on shop");
		util.click(addToCartPage.getheatingMenu());
		util.Info("clicked on Heating & Cooling Menu");
		util.Sleep(5000);
		util.click(addToCartPage.getshowallId());
		util.Info("clicked on show all menu");
		util.Sleep(5000);
		util.click(addToCartPage.getHomeDelvery());
		util.Info("Filtered by homedelivery");
		util.Sleep(5000);
		util.click(addToCartPage.getclickonItem());
		util.Info("clicked on the item");
		util.click(addToCartPage.getaddToCart());
		util.Sleep(5000);
		util.Info("Item added to the cart successfully");
		util.click(addToCartPage.getcartBtn());
		util.Info("Navigated to Cart Page");
		util.Sleep(5000);

		String checkoutHeader=util.getText(addToCartPage.getcheckoutBtn());
		Assert.assertEquals(checkoutHeader, "CHECKOUT");
		util.Info("checkout validated successfully");

        }





	/*@Test(priority = 1)
	public void settingsChange() throws InterruptedException {
		reportMethodName("SettingChange","To Change Setting");util.Sleep(5000);
		util.Sleep(5000);
		util.click(addToCartPage.getLocationPermission());
		System.out.print("clicked on only this time");
		util.Info("clicked on only this time button");
		util.Sleep(5000);
		util.click(addToCartPage.getAccountButton());
		logger.log(Status.INFO, "Account button Clicked successfully");
		util.click(addToCartPage.getSettings());
		logger.log(Status.INFO, "Setting button clicked successfully");
		util.click(addToCartPage.getNotificationButton());
		logger.log(Status.INFO, "Notification button clicked successfully");
		util.click(addToCartPage.getSalesAlertToggleButton());
		logger.log(Status.INFO, "SalesAlert button enabled");
		util.click(addToCartPage.getPromotionToggleButton());
		logger.log(Status.INFO, "PromotionToggle button enabled");
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(5000);
	}*/
}
