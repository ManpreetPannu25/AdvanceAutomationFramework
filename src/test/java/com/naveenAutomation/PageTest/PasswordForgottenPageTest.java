package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Pages.PasswordForgottenPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.LoginPage;

public class PasswordForgottenPageTest extends TestBase {
	LoginPage loginPage;
	PasswordForgottenPage accountForgottenPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void validateUserCannotResetPaswdWithInvalidEmail() {
		accountForgottenPage = loginPage.clickForgotPasswordBtn();
		accountForgottenPage.enterContinueBtn("Pawan@123");
		Assert.assertEquals(accountForgottenPage.emailNotFoundAlertText(),
				"Warning: The E-Mail Address was not found in our records, please try again!",
				"Password reset link sent to the associated email");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
