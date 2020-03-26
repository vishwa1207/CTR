package com.ctr.tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ctr.pages.AddToCartPage;
import com.ctr.qa.BaseTest;

public class AddToCart extends BaseTest{
  
	static AddToCartPage addToCartPage;
	
	@BeforeMethod
	public void beforeMethod(Method m)
	{
		addToCartPage = new AddToCartPage();
		System.out.println("Starting the method -->"+m.getName());
	}
	@Test
	public void addToCartFlow() throws InterruptedException {
		
		reportMethodName("AddToCart","To test Add to Cart Flow");
		
		System.out.println("waiting for 20sec");
		Thread.sleep(20000);
		System.out.println("wait is over");
		click(addToCartPage.getAllowAlwaysButton());
		logger.log(Status.INFO, "Aytu bidu guru");
		logger.info("Ivaga Baa");
		
		System.out.println("clicked on Allow");
		System.out.println("waiting 15 sec");
		Thread.sleep(15000);
		System.out.println("wait is over again");
		click(addToCartPage.getFirstIcon().get(1));
		System.out.println("clicked on 1st");
	}
}
