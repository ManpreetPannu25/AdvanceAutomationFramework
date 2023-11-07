package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.SideNavImplementation;
import com.naveenAutomation_Pages.SideNavigationBar;
import com.naveenAutomation_Pages.TransactionPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TransactionPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	TransactionPage transactionPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateUserCanNavigateToTransactionPageWithSuccessMsg() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		transactionPage = (TransactionPage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.TRANSACTIONS);
		Assert.assertEquals(transactionPage.transactionMsgText(), "You do not have any transactions!",
				"Transaction page Not Found");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
