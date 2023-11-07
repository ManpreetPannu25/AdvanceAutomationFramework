package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class InfoEditPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/edit";

	public InfoEditPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By fNameInput = By.id("input-firstname");
	private static final By lNameInput = By.id("input-lastname");
	private static final By emailInput = By.id("input-email");
	private static final By telephoneInput = By.id("input-telephone");
	private static final By submitBtn = By.cssSelector("input[type='submit']");

	public void enterFirstName(String fName) {
		((ProxyDriver) wd).clear(fNameInput);
		((ProxyDriver) wd).sendKeys(fNameInput, fName);
	}

	public void enterLastName(String lName) {
		((ProxyDriver) wd).clear(lNameInput);
		((ProxyDriver) wd).sendKeys(lNameInput, lName);
	}

	public void enterEmail(String email) {
		((ProxyDriver) wd).clear(emailInput);
		((ProxyDriver) wd).sendKeys(emailInput, email);
	}

	public void enterTelephone(String telephone) {
		((ProxyDriver) wd).clear(telephoneInput);
		((ProxyDriver) wd).sendKeys(telephoneInput, telephone);
	}

	public AccountPage submissionOfAccountUpdateForm() {
		((ProxyDriver) wd).submit(submitBtn);
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
