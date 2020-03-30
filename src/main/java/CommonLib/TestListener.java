package CommonLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {



	public void onStart(ITestResult result) {
		System.out.println("Test case "+result.getMethod()+" is started");
	}



	public void onFinish(ITestResult result) {
		System.out.println("Test case "+result.getMethod()+" is finished");
	}



	public void onTestStart(ITestResult result) {
		System.out.println("Test case "+result.getMethod()+" is started");
	}



	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed Test Name is "+result.getTestName()+"Passed Test case is "+result.getMethod());
	}



	public void onTestFailure(ITestResult result) {



		System.out.println("Failed Test Name is "+result.getTestName()+"Failed Test case is "+result.getMethod());
	}



	public void onTestSkipped(ITestResult result) {



		System.out.println("Skipped Test case is "+result.getMethod());
	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {




	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}



	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
