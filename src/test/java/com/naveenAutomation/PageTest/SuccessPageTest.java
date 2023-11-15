package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.ContactPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.RegisterPage;
import com.naveenAutomation_Pages.SuccessContactPage;
import com.naveenAutomation_Pages.SuccessPage;
import com.naveenAutomation_Pages.SuccessVoucherPage;
import com.naveenAutomation_Pages.VoucherPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SuccessPageTest extends TestBase {
	LoginPage loginPage;
	RegisterPage registerPage;
	SuccessPage successPage;
	ContactPage contactPage;
	VoucherPage voucherPage;
	SuccessContactPage successContactPage;
	SuccessVoucherPage successVoucherPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateSuccessMsgAfterRegistrationWithValidCredentials() {
		registerPage = loginPage.continueToRegisterClick();
		registerPage.fillingRegistrationForm("Harry", "Sharmaan", "horryy@yahoo.com", "123456777", "Harry1234",
				"Harry1234");
		registerPage.clickPolicyCheckBox();
		successPage = (SuccessPage) registerPage.clickContinueButton();
		Assert.assertEquals(successPage.successMsgText(), "Your Account Has Been Created!",
				"Registration Unsuccessfull");
	}

	@Test
	public void validateSuccessMsgAfterSendingEnquiryWithValidCredentials() {
		contactPage = loginPage.contactUsClick();
		contactPage.fillingEnquiryForm("Manpreet", "manpreet202025@yahoo.com", "Need More Product Information");
		successContactPage = (SuccessContactPage) contactPage.enterSubmitBtn();
		Assert.assertEquals(successContactPage.enquirySuccessMsgText(),
				"Your enquiry has been successfully sent to the store owner!", "Enquiry Not Sent");
	}

	@Test
	public void validateSuccessMsgForVoucherWithValidCredentials() {
		voucherPage = loginPage.giftCertificateLinkClick();
		voucherPage.fillingVoucherForm("harry", "harry@gmail.com", "garry", "garry@yahoo.com", "Happy bday", "1");
		voucherPage.clickCheckBox();
		successVoucherPage = (SuccessVoucherPage) voucherPage.clickSubmitBtn();
		Assert.assertEquals(successVoucherPage.giftVoucherSuccessMsgText(),
				"Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.",
				"Unsuccessfull Gift Certificate Purchase");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
