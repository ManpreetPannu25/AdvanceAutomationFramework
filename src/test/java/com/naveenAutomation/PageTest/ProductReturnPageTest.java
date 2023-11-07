package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.ProductReturnPage;
import com.naveenAutomation_Pages.SideNavImplementation;
import com.naveenAutomation_Pages.SideNavigationBar;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ProductReturnPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	ProductReturnPage returnPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateUserProductReturnsMessage() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		returnPage = (ProductReturnPage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.RETURNS);
		Assert.assertEquals(returnPage.productReturnsMsgText(), "You have not made any previous returns!",
				"No Product return Message displayed");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
