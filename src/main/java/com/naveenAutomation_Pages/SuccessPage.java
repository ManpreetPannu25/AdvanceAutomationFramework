package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class SuccessPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/success";

	public SuccessPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By successMsg = By.xpath("//h1[text()='Your Account Has Been Created!']");

	public String successMsgText() {
		return ((ProxyDriver) wd).getText(successMsg);
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
