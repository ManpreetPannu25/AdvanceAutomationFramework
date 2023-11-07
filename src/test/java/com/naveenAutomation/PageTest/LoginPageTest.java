package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void validateUserLoginWithValidCredentials() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		Assert.assertEquals(accountPage.myAccountTextMsg(), "My Account", "Unsuccessfull Login");
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void validateUserFailedLoginWithInValidCredentials() {
		loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234Manu");
		Assert.assertEquals(loginPage.loginFailedAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"Successfull Login");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
