package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.RewardsPointPage;
import com.naveenAutomation_Pages.SideNavImplementation;
import com.naveenAutomation_Pages.SideNavigationBar;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RewardsPointPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	RewardsPointPage rewardsPointPage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateUserCanNavigateToRewardsPointPageWithSuccessMsg() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		rewardsPointPage = (RewardsPointPage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.REWARD_POINTS);
		Assert.assertEquals(rewardsPointPage.rewardsPointMsgText(), "You do not have any reward points!",
				"Rewards point page Not Found");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
