package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.VoucherPage;

public class VoucherPageTest extends TestBase {
	LoginPage loginPage;
	VoucherPage voucherPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Test
	public void validateWarningMsgWithInvalidRecipientName() {
		voucherPage = loginPage.giftCertificateLinkClick();
		voucherPage.fillingVoucherForm("", "harry@gmail.com", "garry", "garry@yahoo.com", "Happy bday", "1");
		voucherPage.clickCheckBox();
		voucherPage = (VoucherPage) voucherPage.clickSubmitBtn();
		Assert.assertEquals(voucherPage.invalidrecipientsNameWarningText(),
				"Recipient's Name must be between 1 and 64 characters!", "Unsuccessfull Gift Certificate Purchase");
	}

	@Test
	public void validateWarningMsgWithInvalidRecipientEmail() {
		voucherPage = loginPage.giftCertificateLinkClick();
		voucherPage.fillingVoucherForm("harry", "harry@gmail.com", "garry", "g", "Happy bday", "1");
		voucherPage.clickCheckBox();
		voucherPage = (VoucherPage) voucherPage.clickSubmitBtn();
		Assert.assertEquals(voucherPage.invalidrecipientsEmailWarningText(),
				"E-Mail Address does not appear to be valid!", "Unsuccessfull Gift Certificate Purchase");
	}

	@Test
	public void validateWarningMsgIfCheckBoxIsSkipped() {
		voucherPage = loginPage.giftCertificateLinkClick();
		voucherPage.fillingVoucherForm("harry", "harry@gmail.com", "garry", "garry@yahoo.com", "Happy bday", "1");
		voucherPage = (VoucherPage) voucherPage.clickSubmitBtn();
		Assert.assertEquals(voucherPage.giftCertificateWarningText(),
				"Warning: You must agree that the gift certificates are non-refundable!",
				"Unsuccessfull Gift Certificate Purchase");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
