package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class RecurringPaymentsPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/recurring";

	public RecurringPaymentsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By recurringPaymentsMsg = By.xpath("//p[text()='No recurring payments found!']");

	public String recurringPaymentsMsgText() {
		return ((ProxyDriver) wd).getText(recurringPaymentsMsg);
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
