package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class NewsletterPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/newsletter";

	public NewsletterPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By continueBtn = By.cssSelector("input[type='submit']");

	public AccountPage submitNewsletterSubscription() {
		((ProxyDriver) wd).click(continueBtn);
		return new AccountPage(wd, true);
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