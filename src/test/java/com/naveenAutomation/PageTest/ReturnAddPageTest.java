package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.ReturnAddProductPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ReturnAddPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ReturnAddProductPage returnAddProductPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();

	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void ValidateWarningMsgIfNoOrderIdMentioned() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		returnAddProductPage = accountPage.returnsLinkClick();
		returnAddProductPage.orderInformationForm("Manu", "sharma", "Manpreet202025@yahoo.com", "123456789", "");
		returnAddProductPage.productInformationForm("Samsung", "1122", "Expecting refund");
		Assert.assertEquals(returnAddProductPage.orderIDWarningMsgText(), "Order ID required!",
				"Returm form successfully submitted");
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void ValidateWarningMsgWithInvalidProductName() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		returnAddProductPage = accountPage.returnsLinkClick();
		returnAddProductPage.orderInformationForm("Manu", "sharma", "Manpreet202025@yahoo.com", "123456789", "33333");
		returnAddProductPage.productInformationForm("", "1122", "Expecting refund");
		Assert.assertEquals(returnAddProductPage.invalidProductNameWarningMsgText(),
				"Product Name must be greater than 3 and less than 255 characters!",
				"Returm form successfully submitted");
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void ValidateWarningMsgWithInvalidProductModel() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		returnAddProductPage = accountPage.returnsLinkClick();
		returnAddProductPage.orderInformationForm("Manu", "sharma", "Manpreet202025@yahoo.com", "123456789", "33333");
		returnAddProductPage.productInformationForm("samsung", "", "Expecting refund");
		Assert.assertEquals(returnAddProductPage.productModelWarningText(),
				"Product Model must be greater than 3 and less than 64 characters!",
				"Returm form successfully submitted");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
