package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class SuccessVoucherPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/voucher/success";

	public SuccessVoucherPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By giftVoucherSuccessMsg = By.cssSelector("#content>p");

	public String giftVoucherSuccessMsgText() {
		return ((ProxyDriver) wd).getText(giftVoucherSuccessMsg);
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
