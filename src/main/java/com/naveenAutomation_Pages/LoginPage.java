package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class LoginPage extends Page {

	public static final String PAGE_URL = "/opencart/index.php?route=account/login";

	public LoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By emailInput = By.id("input-email");
	private static final By passwordInput = By.id("input-password");
	private static final By loginBtn = By.cssSelector("input[type='submit']");
	private static final By loginFailedAlert = By.cssSelector(".alert-danger");
	private static final By forgotPassword = By.cssSelector("div.form-group:last-of-type>a");
	private static final By continueToRegisterPage = By.cssSelector("div.well>a");
	private static final By contactUs = By.xpath("//a[text()='Contact Us']");
	private static final By giftCertificate = By.xpath("//a[text()='Gift Certificates']");
	private static final By brands = By.xpath("//a[text()='Brands']");

	public ManufacturerPage brandsLinkClick() {
		((ProxyDriver) wd).click(brands);
		return new ManufacturerPage(wd, true);
	}

	public VoucherPage giftCertificateLinkClick() {
		((ProxyDriver) wd).click(giftCertificate);
		return new VoucherPage(wd, true);
	}

	public RegisterPage continueToRegisterClick() {
		((ProxyDriver) wd).click(continueToRegisterPage);
		return new RegisterPage(wd, true);
	}

	public ContactPage contactUsClick() {
		((ProxyDriver) wd).click(contactUs);
		return new ContactPage(wd, true);
	}

	private void enterEmail(String email) {
		((ProxyDriver) wd).sendKeys(emailInput, email);
	}

	private void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordInput, password);
	}

	public GeneralPage loginPageSubmission(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		((ProxyDriver) wd).click(loginBtn);
		return this.waitForPageToLoad(AccountPage.class, LoginPage.class);
	}

	public String loginFailedAlertText() {
		return ((ProxyDriver) wd).getText(loginFailedAlert);
	}

	public PasswordForgottenPage clickForgotPasswordBtn() {
		((ProxyDriver) wd).click(forgotPassword);
		return new PasswordForgottenPage(wd, true);
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

	@Override
	public LoginPage get() {
		return (LoginPage) super.get();
	}
}
