package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.RegisterPage;
import com.naveenAutomation_Pages.SuccessPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegisterPageTest extends TestBase {
	LoginPage loginPage;
	RegisterPage registerPage;
	SuccessPage successPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void validateWarningMsgIfFirstNameCharExceedsRange() {
		registerPage = loginPage.continueToRegisterClick();
		registerPage.fillingRegistrationForm("Harryharryharryharryahrryahrryharryharr", "Sharma", "harry@yahoo.com",
				"123456777", "Harry1234", "Harry1234");
		registerPage.clickPolicyCheckBox();
		registerPage = (RegisterPage) registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.fNameCharWarningText(), "First Name must be between 1 and 32 characters!",
				"Registration successfull");
	}

	@Test
	public void validateWarningMsgIfLastNameCharExceedsRange() {
		registerPage = loginPage.continueToRegisterClick();
		registerPage.fillingRegistrationForm("Harry", "Sharmaharryharryharryahrryahrryharryharr", "harry@yahoo.com",
				"123456777", "Harry1234", "Harry1234");
		registerPage.clickPolicyCheckBox();
		registerPage = (RegisterPage) registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.lNameCharWarningText(), "Last Name must be between 1 and 32 characters!",
				"Registration successfull");
	}

	@Test
	public void validateWarningMsgIfTelephoneCharIsNotInRange() {
		registerPage = loginPage.continueToRegisterClick();
		registerPage.fillingRegistrationForm("Harry", "Sharma", "harry1@yahoo.com", "12", "Harry1234", "Harry1234");
		registerPage.clickPolicyCheckBox();
		registerPage = (RegisterPage) registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.telephoneCharWarningText(), "Telephone must be between 3 and 32 characters!",
				"Registration successfull");
	}

	@Test
	public void validateWarningMsgWithMisMatchedPasswords() {
		registerPage = loginPage.continueToRegisterClick();
		registerPage.fillingRegistrationForm("Harry", "Sharma", "harry2@yahoo.com", "123456789", "Harry123456",
				"Harry1234");
		registerPage.clickPolicyCheckBox();
		registerPage = (RegisterPage) registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.pswrdNotMatchedWarningText(), "Password confirmation does not match password!",
				"Registration successfull");
	}

	@Test
	public void validatePrivacyPolicyWarningMsgIfGotSkipped() {
		registerPage = loginPage.continueToRegisterClick();
		registerPage.fillingRegistrationForm("Harry", "Sharma", "manpreet202025@yahoo.com", "123456789", "Harry1234",
				"Harry1234");
		registerPage = (RegisterPage) registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.privacyPolicyWarningText(), "Warning: You must agree to the Privacy Policy!",
				"Registration successfull");
	}

	@Test
	public void validateWarningMsgAfterRegistrationWithAlreadyExistEmail() {
		registerPage = loginPage.continueToRegisterClick();
		registerPage.fillingRegistrationForm("manpreet", "kaur", "manpreet202025@yahoo.com", "123456777", "Harry1234",
				"Harry1234");
		registerPage.clickPolicyCheckBox();
		registerPage = (RegisterPage) registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.emailExistAlreadyWarningText(),
				"Warning: E-Mail Address is already registered!", "Registration successfull");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
