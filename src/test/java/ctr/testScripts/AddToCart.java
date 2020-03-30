package ctr.testScripts;

import ctr.commonLib.CommonMethods;
import ctr.commonLib.ExtentReportClass;
import ctr.pages.AddToCartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCart extends ExtentReportClass{
  
	AddToCartPage addToCartPage = new AddToCartPage();
	CommonMethods c = new CommonMethods();

	
	@Given("^I click on 'Allow' button$")
	public void i_click_on_Allow_button() throws Throwable {
		System.out.println("inside first feature ");
		Thread.sleep(7000);
		c.click(addToCartPage.getAllowAlwaysButton());
		System.out.println("clicked on Allow");
	
	}
	
	
	@When("^I Click on 'shop' button$")
	public void i_Click_on_shop_button() throws Throwable {
		Thread.sleep(15000);
		c.click(addToCartPage.getFirstIcon().get(1));
		System.out.println("clicked on Shop");
	}
	
	@When("^I click on 'SignIn' button$")
	public void i_click_on_SignIn_button() throws Throwable {
	}

	@Then("^I enter 'UserName'$")
	public void i_enter_UserName() throws Throwable {
	}

	@Then("^I enter 'password'$")
	public void i_enter_password() throws Throwable {
	}

	

}
