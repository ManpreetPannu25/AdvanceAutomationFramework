package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.LogoutPage;
import com.naveenAutomation_Pages.SideNavImplementation;
import com.naveenAutomation_Pages.SideNavigationBar;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LogoutPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	LogoutPage logoutPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateLogoutSuccessMsg() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		logoutPage = (LogoutPage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.LOGOUT);
		Assert.assertEquals(logoutPage.accountLogoutSuccessMsgText(), "Account Logout", "Account Not Logged Out");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
