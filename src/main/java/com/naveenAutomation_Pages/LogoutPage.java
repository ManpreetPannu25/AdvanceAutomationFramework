package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class LogoutPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/logout";

	public LogoutPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By accountLogoutMsg = By.cssSelector("#content>h1");
	private static final By continueBtn = By.cssSelector("div.pull-right>a");

	public String accountLogoutSuccessMsgText() {
		return ((ProxyDriver) wd).getText(accountLogoutMsg);

	}

	public HomePage clickContinueAfterLogOut() {
		((ProxyDriver) wd).click(continueBtn);
		return new HomePage(wd, true);

	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}

	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

}
