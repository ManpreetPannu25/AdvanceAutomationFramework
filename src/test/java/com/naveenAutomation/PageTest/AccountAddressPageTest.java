package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountAddressEditPage;
import com.naveenAutomation_Pages.AccountAddressPage;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;

public class AccountAddressPageTest extends TestBase {
	LoginPage loginPage;
	AccountAddressPage accountAddressPage;
	AccountPage accountPage;
	AccountAddressEditPage accountAddressEditPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Test
	public void validateSuccessMsgToUpdateAddressWithValidCredentials() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		accountAddressPage = accountPage.addressBookEntryLinkClick();
		accountAddressEditPage = accountAddressPage.editLinkClick();
		accountAddressEditPage.selectingProvince("Ontario");
		accountAddressPage = (AccountAddressPage) accountAddressEditPage.continueBtnClick();
		Assert.assertEquals(accountAddressPage.updateAddressSuccessMsgText(),
				"Your address has been successfully updated", "Unsuccessful address update");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
