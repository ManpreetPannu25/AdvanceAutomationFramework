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

public class AccountAddressEditPageTest extends TestBase {
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
	public void validateWarningMsgWithInvalidAddressEntryToUpdateAddress() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		accountAddressPage=accountPage.addressBookEntryLinkClick();
		accountAddressEditPage=accountAddressPage.editLinkClick();
		accountAddressEditPage.enterAddress("");
		accountAddressEditPage.continueBtnClick();
		Assert.assertEquals(accountAddressEditPage.warningMsgText(), "Address must be between 3 and 128 characters!",
				"successfully address updated");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}


