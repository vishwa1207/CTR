package Pages;


import CommonLib.Utility;
import Driver.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BaseTest {

    //public SignInPage(AppiumDriver<?> driver) {
        //super(driver);
    //}


    @AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_sign_in_button")//ca.triangle.retail.canadiantire.uat15:id/ctc_account_sign_out_btn
    private MobileElement signIn;

    @AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_signin_email")
    private MobileElement UserID;

    @AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_signin_pass")
    private MobileElement Password;

    @AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_btn_signin")
    private MobileElement SignInButton;

    @AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_account_navigation_entry_point")
    private MobileElement MyAccountPage;

    @AndroidFindBy(id = "ca.triangle.retail.canadiantire.uat15:id/ctc_account_sign_out_btn")//android:id/button1
    private MobileElement signout;

    @AndroidFindBy(id = "android:id/button1")//android:id/button1
    private MobileElement signoutYes;

    public void LogIn() throws InterruptedException {
        Thread.sleep(5000);
        signIn.click();
        UserID.click();
        UserID.clear();
        UserID.sendKeys("arpit.kumar.vaish@accenture.com");
        Password.click();
        Password.clear();
        Password.sendKeys("Ctr@4321");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ca.triangle.retail.canadiantire.uat15:id/ctc_btn_signin")));
        SignInButton.click();
        Thread.sleep(15000);
    }

    public void LogOut() throws InterruptedException {

        MyAccountPage.click();
        Thread.sleep(5000);
        Utility.swipeup();
        signout.click();
        signoutYes.click();
        Thread.sleep(5000);
    }

}
