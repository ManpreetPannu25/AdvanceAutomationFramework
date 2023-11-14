package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class ContactPage extends Page {

	public static final String PAGE_URL = "/opencart/index.php?route=information/contact";

	public ContactPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By nameInput = By.id("input-name");
	private static final By emailInput = By.id("input-email");
	private static final By enquiryInput = By.id("input-enquiry");
	private static final By submitBtn = By.cssSelector("input[type='submit']");
	private static final By invalidNameWarning = By.cssSelector("div.text-danger");
	private static final By InvalidEmailWarning = By.cssSelector("div.text-danger");
	private static final By InvalidEnquiryWarning = By.cssSelector("div.text-danger");

	public String invalidNameWarningText() {
		return ((ProxyDriver) wd).getText(invalidNameWarning);
	}

	public String InvalidEmailWarningText() {
		return ((ProxyDriver) wd).getText(InvalidEmailWarning);
	}

	public String InvalidEnquiryWarningText() {
		return ((ProxyDriver) wd).getText(InvalidEnquiryWarning);
	}

	public void enterNameInput(String name) {
		((ProxyDriver) wd).sendKeys(nameInput, name);
	}

	public void enterEmailInput(String email) {
		((ProxyDriver) wd).sendKeys(emailInput, email);
	}

	public void enterEnquiryInput(String enquiry) {
		((ProxyDriver) wd).sendKeys(enquiryInput, enquiry);
	}

	public GeneralPage enterSubmitBtn() {
		((ProxyDriver) wd).submit(submitBtn);
		return this.waitForPageToLoad(SuccessContactPage.class, ContactPage.class);
	}

	public void fillingEnquiryForm(String name, String email, String enquiry) {
		enterNameInput(name);
		enterEmailInput(email);
		enterEnquiryInput(enquiry);

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
