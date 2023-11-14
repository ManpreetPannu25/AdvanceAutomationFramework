package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class AccountAddressPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/address";

	public AccountAddressPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By editLink = By.xpath("//a[text()='Edit']");
	private static final By updateAddressSuccessMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public String updateAddressSuccessMsgText() {
		return ((ProxyDriver) wd).getText(updateAddressSuccessMsg);
	}

	public AccountAddressEditPage editLinkClick() {
		((ProxyDriver) wd).click(editLink);
		return new AccountAddressEditPage(wd, true);

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
