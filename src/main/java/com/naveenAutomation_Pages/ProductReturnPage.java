package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class ProductReturnPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/return";

	public ProductReturnPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By returnsMsg = By.cssSelector("#content>p");

	public String productReturnsMsgText() {
		return ((ProxyDriver) wd).getText(returnsMsg);
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
