package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class SuccessContactPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=information/contact/success";

	public SuccessContactPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By enquirySuccessMsg = By.cssSelector("#content>p");

	public String enquirySuccessMsgText() {
		return ((ProxyDriver) wd).getText(enquirySuccessMsg);
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
