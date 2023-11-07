package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class WishListPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/wishlist";

	public WishListPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By wishListMsg = By.xpath("//p[text()='Your wish list is empty.']");

	public String wishListMsgText() {
		return ((ProxyDriver) wd).getText(wishListMsg);
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
