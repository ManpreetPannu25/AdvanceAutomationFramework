package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.ManufacturerPage;

public class ManufacturerPageTest extends TestBase {
	LoginPage loginPage;
	ManufacturerPage manufacturerPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Test
	public void validateWarningMsgWithInvalidRecipientName() {
		manufacturerPage = loginPage.brandsLinkClick();
		Assert.assertEquals(manufacturerPage.htcProductLabelText(), "HTC", "HTC product label link is not present");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
