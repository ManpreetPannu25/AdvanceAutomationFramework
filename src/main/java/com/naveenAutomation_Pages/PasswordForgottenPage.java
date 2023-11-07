package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class PasswordForgottenPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/forgotten";

	public PasswordForgottenPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By emailInput = By.cssSelector("input[name='email']");
	private static final By continueBtn = By.cssSelector("input[type='submit']");
	private static final By emailNotFoundAlert = By.cssSelector("div.alert-danger");

	public void enterEmailAddress(String email) {
		((ProxyDriver) wd).sendKeys(emailInput, email);

	}

	public void enterContinueBtn(String email) {
		enterEmailAddress(email);
		((ProxyDriver) wd).click(continueBtn);
	}

	public String emailNotFoundAlertText() {
		return ((ProxyDriver) wd).getText(emailNotFoundAlert);
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
