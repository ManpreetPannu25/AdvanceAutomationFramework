package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class PasswordChangePage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/password";

	public PasswordChangePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By passwordInput = By.cssSelector("#input-password");
	private static final By passwordConfirmInput = By.cssSelector("#input-confirm");
	private static final By continueBtn = By.cssSelector("input[type='submit']");
	private static final By passwordMismatchMsg = By.cssSelector("div.text-danger");

	public String getPasswordMismatchMsgText() {
		return ((ProxyDriver) wd).getText(passwordMismatchMsg);
	}

	public void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordInput, password);

	}

	public void enterConfirmPassword(String confirmPassword) {
		((ProxyDriver) wd).sendKeys(passwordConfirmInput, confirmPassword);
	}

	public AccountPage submitPasswordChangedContinueBtn(String password, String confirmPassword) {
		((ProxyDriver) wd).sendKeys(passwordInput, password);
		((ProxyDriver) wd).sendKeys(passwordConfirmInput, confirmPassword);
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
