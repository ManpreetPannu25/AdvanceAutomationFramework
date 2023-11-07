package com.naveenAutomation_Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenAutomation_Base.TestBase;

public class CustomListener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("----------Test Case Started " + result.getMethod().getMethodName() + "--------------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("**********Test Case Passed " + result.getMethod().getMethodName() + "*************");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("!!!!!!!!!!!Test Case Failed " + result.getMethod().getMethodName() + "  Taking ScreenShot "
				+ "!!!!!!!!");
		Utils.takingFailTestScreenShot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("??????????????Test Case Skipped " + result.getMethod().getMethodName() + "??????????????");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
