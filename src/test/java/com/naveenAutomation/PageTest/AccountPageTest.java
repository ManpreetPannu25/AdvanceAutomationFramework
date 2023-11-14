package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.AffiliateEditPage;
import com.naveenAutomation_Pages.InfoEditPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.NewsletterPage;
import com.naveenAutomation_Pages.PasswordChangePage;
import com.naveenAutomation_Pages.SideNavImplementation;
import com.naveenAutomation_Pages.SideNavigationBar;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	InfoEditPage editPage;
	NewsletterPage newsletterPage;
	PasswordChangePage passwordChangePage;
	AffiliateEditPage affiliateEditPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateUserCanUpdateAccountInfo() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		editPage = (InfoEditPage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.EDIT_ACCOUNT);
		editPage.enterFirstName("Harpreet");
		accountPage = editPage.submissionOfAccountUpdateForm();
		Assert.assertEquals(accountPage.infoUpdateSuccessMsgText(),
				"Success: Your account has been successfully updated.", "Account Info Not Changed");

	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateNewsletterSubscriptionUpdatedSuccessMsg() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		newsletterPage = (NewsletterPage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.NEWSLETTER);
		accountPage = newsletterPage.submitNewsletterSubscription();
		Assert.assertEquals(accountPage.newsletterSuccessMsgText(),
				"Success: Your newsletter subscription has been successfully updated!",
				"Newsletter Subscription not updated");
	}

	@Test(enabled = false)
	public void validatePasswordUpdatedSuccessMsg() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		passwordChangePage = (PasswordChangePage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.PASSWORD);
		accountPage = (AccountPage) passwordChangePage.submitPasswordChangedContinueBtn("Manu12345", "Manu12345");
		Assert.assertEquals(accountPage.passwordUpdatedSuccessMsgText(),
				"Success: Your password has been successfully updated.", "Password not Changed");
	}

	@Test
	public void validateSuccessMsgForAffiliateRegistrationWithValidCredentials() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		affiliateEditPage = accountPage.affilateLinkClick();
		accountPage = (AccountPage) affiliateEditPage.fillingAffiliateForm("Summer fresh", "https://manpreet-pannu.com",
				"1111", "Manpreet");
		Assert.assertEquals(accountPage.affiliateRegistrSuccessMsgMsg(),
				"Success: Your account has been successfully updated.",
				"Unsuccessful Registration for affiliate program");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
