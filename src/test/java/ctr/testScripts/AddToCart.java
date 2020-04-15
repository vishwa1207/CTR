package ctr.testScripts;

import ctr.commonLib.CommonMethods;
import ctr.commonLib.ExtentReportClass;
import ctr.pages.AddToCartPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart extends ExtentReportClass{

	AddToCartPage addToCartPage = new AddToCartPage();
	CommonMethods c = new CommonMethods();


	@Given("^I click on 'Allow' button for location and Notification$")
	public void i_click_on_Allow_button_for_location_and_Notification() throws Throwable {

		System.out.println("inside first feature ");
		//Thread.sleep(3000);
		c.click(addToCartPage.getAllowForLocation());
		c.click(addToCartPage.getAllowForNotification());
		//Thread.sleep(3000);
		System.out.println("clicked on Allow");


	}

	@When("^I click on 'NEXT' button to reach HomePage$")
	public void i_click_on_NEXT_button_to_reach_HomePage() throws Throwable {
		try {
			System.out.println("inside Second feature ");

			c.waitForVisibility(addToCartPage.getNextButton());
			addToCartPage.getNextButton().click();
			addToCartPage.getNextButton().click();
			addToCartPage.getNextButton().click();
			addToCartPage.getFinishButton().click();
			System.out.println("reached home page");
		}
		catch (Exception e){System.out.println("NO next button came");}

	}

	@Then("^I Click on 'shop' button$")
	public void i_Click_on_shop_button() throws Throwable {

		System.out.println("inside Third feature ");
		addToCartPage.getShopButton().click();
		System.out.println("reached Shop page");
	}

	@Then("^Add an Item to Cart$")
	public void add_an_Item_to_Cart() throws Throwable {
		System.out.println("inside Fourth feature ");

		addToCartPage.getGotosearch().click();
		addToCartPage.getGotosearch().sendKeys("Hardwood pellets");
		addToCartPage.getSearchButton().click();
		//c.waitForElementToBeClickable(addToCartPage.getSelectFirstItem());
		addToCartPage.getSelectFirstItem().isEnabled();
		addToCartPage.getSelectFirstItem().click();
		c.waitForVisibility(addToCartPage.getAddToCart());
		c.waitForElementToBeClickable(addToCartPage.getAddToCart());
		addToCartPage.getAddToCart().click();
		Thread.sleep(3000);
		System.out.println("Successfully Added Item To Cart");

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
		}
	}

}
