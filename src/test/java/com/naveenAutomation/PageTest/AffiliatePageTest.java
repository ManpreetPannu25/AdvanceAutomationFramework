package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.AffiliateEditPage;
import com.naveenAutomation_Pages.ContactPage;
import com.naveenAutomation_Pages.LoginPage;

public class AffiliatePageTest extends TestBase {
	LoginPage loginPage;
	ContactPage contactPage;
	AccountPage accountPage;
	AffiliateEditPage affiliateEditPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Test
	public void validateWarningMsgWithInvalidPayeeNameCharToEditAffiliateInfo() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		affiliateEditPage = accountPage.affilateLinkClick();
		affiliateEditPage.fillingAffiliateForm("Summer fresh", "https://manpreet-pannu.com", "1111", "");
		Assert.assertEquals(affiliateEditPage.invalidPayeeNameMsgText(), "Cheque Payee Name required!",
				"successful Registration for affiliate program");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
