package com.naveenAutomation_Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenAutomation_Base.TestBase;

public class Utils extends TestBase {
	public static void takingFailTestScreenShot(String testMethodName) {

		String timeStamp = getCurrentDateTimeStamp();

		File screenShotFfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile,
					new File("./FailedTestCasesScreenShot\\" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}

	}

	public static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String generateRandomAlphabetic(int charCount) {
		return RandomStringUtils.randomAlphabetic(charCount);
	}

	public static String generateRandomAlphaNumbers(int numCount) {
		return RandomStringUtils.randomAlphanumeric(numCount);
	}

	public static String generateRandomNumbers(int numCount) {
		return RandomStringUtils.randomNumeric(numCount);
	}

	public static String getCurrentDateTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	}

}
