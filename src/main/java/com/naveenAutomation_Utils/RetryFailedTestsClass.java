package com.naveenAutomation_Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenAutomation_Base.TestBase;

public class RetryFailedTestsClass extends TestBase implements IRetryAnalyzer {
	int count = 1;
	int maxCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		logger.info(" Retrying failed test " + result.getMethod().getMethodName() + "for " + count + " time");
		if (count < maxCount) {
			count++;
			return true;
		}
		return false;
	}

}
