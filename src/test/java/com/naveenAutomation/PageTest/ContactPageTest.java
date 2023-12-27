package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.ContactPage;
import com.naveenAutomation_Pages.LoginPage;

public class ContactPageTest extends TestBase {
	LoginPage loginPage;
	ContactPage contactPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Test
	public void validateWarningMsgWithInvalidFirstNameCharRange() {
		contactPage = loginPage.contactUsClick();
		contactPage.fillingEnquiryForm("m", "manpreet202025@yahoo.com", "Need more Product Information");
		contactPage.enterSubmitBtn();
		Assert.assertEquals(contactPage.invalidNameWarningText(), "Name must be between 3 and 32 characters!",
				"Enquiry Not sent");
	}

	@Test
	public void validateWarningMsgWithInvalidEmailCharRange() {
		contactPage = loginPage.contactUsClick();
		contactPage.fillingEnquiryForm("manpreet", "mm", "Need more Product Information");
		contactPage.enterSubmitBtn();
		Assert.assertEquals(contactPage.InvalidEmailWarningText(), "E-Mail Address does not appear to be valid!",
				"Enquiry Not sent");
	}

	@Test
	public void validateWarningMsgWithInvalidEnquiryCharRange() {
		contactPage = loginPage.contactUsClick();
		contactPage.fillingEnquiryForm("manpreet", "manpreet202025@yahoo.com", "N");
		contactPage.enterSubmitBtn();
		Assert.assertEquals(contactPage.InvalidEnquiryWarningText(), "Enquiry must be between 10 and 3000 characters!",
				"Enquiry Not sent");
	}
	@Test(groups = "NewTestCase")
	public void validateWarningMsgWithInvalidFirstNameCharRange_Aman() {
		contactPage = loginPage.contactUsClick();
		contactPage.fillingEnquiryForm("m", "manpreet202025@yahoo.com", "Need more Product Information");
		contactPage.enterSubmitBtn();
		Assert.assertEquals(contactPage.invalidNameWarningText(), "Name must be between 3 and 32 characters!",
				"Enquiry Not sent");
		
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
