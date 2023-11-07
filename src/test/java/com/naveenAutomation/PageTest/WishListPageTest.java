package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.SideNavImplementation;
import com.naveenAutomation_Pages.SideNavigationBar;
import com.naveenAutomation_Pages.WishListPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class WishListPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	WishListPage wishListPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();

	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateUserCanNavigateToWishListPageWithSuccessMsg() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		wishListPage = (WishListPage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.WISH_LIST);
		Assert.assertEquals(wishListPage.wishListMsgText(), "Your wish list is empty.", "Wish list page Not Found");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
