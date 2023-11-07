package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.RecurringPaymentsPage;
import com.naveenAutomation_Pages.SideNavImplementation;
import com.naveenAutomation_Pages.SideNavigationBar;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RecurringPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	RecurringPaymentsPage recurringPaymentsPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();

	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateUserCanNavigateToRecurringPaymentsPageWithSuccessMsg() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		recurringPaymentsPage = (RecurringPaymentsPage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.RECURRING_PAYMENTS);
		Assert.assertEquals(recurringPaymentsPage.recurringPaymentsMsgText(), "No recurring payments found!",
				"Recurring Payments Page Not Found");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
