package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class RegisterPage extends Page {

	public static final String PAGE_URL = "/opencart/index.php?route=account/register";

	public RegisterPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By firstNameInput = By.id("input-firstname");
	private static final By lastNameInput = By.id("input-lastname");
	private static final By inputEmail = By.id("input-email");
	private static final By telephoneInput = By.id("input-telephone");
	private static final By passwordInput = By.id("input-password");
	private static final By passwordConfirmInput = By.id("input-confirm");
	private static final By policyCheckBox = By.cssSelector("input[type='checkbox']");
	private static final By continueButton = By.cssSelector("input[type='submit']");
	private static final By invalidEmailWarning = By.cssSelector("div.text-danger");
	private static final By fNameCharWarning = By.cssSelector("div.text-danger");
	private static final By lNameCharWarning = By.cssSelector("div.text-danger");
	private static final By pswrdNotMatchedWarning = By.cssSelector("div.text-danger");
	private static final By privacyPolicyWarning = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	private static final By emailExistAlreadyWarning = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	private static final By telephoneCharWarning = By.cssSelector("div.text-danger");

	public String pswrdNotMatchedWarningText() {
		return ((ProxyDriver) wd).getText(pswrdNotMatchedWarning);
	}

	public String privacyPolicyWarningText() {
		return ((ProxyDriver) wd).getText(privacyPolicyWarning);
	}

	public void enterEmail(String email) {
		((ProxyDriver) wd).sendKeys(inputEmail, email);
	}

	public void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordInput, password);
	}

	public void enterConfirmPassword(String passwordConfirmed) {
		((ProxyDriver) wd).sendKeys(passwordConfirmInput, passwordConfirmed);
	}

	public void enterTelephone(String telephone) {
		((ProxyDriver) wd).sendKeys(telephoneInput, telephone);
	}

	public void enterFirstName(String firstName) {
		((ProxyDriver) wd).sendKeys(firstNameInput, firstName);
	}

	public void enterLastName(String lastName) {
		((ProxyDriver) wd).sendKeys(lastNameInput, lastName);
	}

	public String emailExistAlreadyWarningText() {
		return ((ProxyDriver) wd).getText(emailExistAlreadyWarning);
	}

	public String telephoneCharWarningText() {
		return ((ProxyDriver) wd).getText(telephoneCharWarning);
	}

	public String fNameCharWarningText() {
		return ((ProxyDriver) wd).getText(fNameCharWarning);
	}

	public String invalidEmailWarningText() {
		return ((ProxyDriver) wd).getText(invalidEmailWarning);
	}

	public String lNameCharWarningText() {
		return ((ProxyDriver) wd).getText(lNameCharWarning);
	}

	public void clickPolicyCheckBox() {
		((ProxyDriver) wd).click(policyCheckBox);
	}

	public GeneralPage clickContinueButton() {
		((ProxyDriver) wd).click(continueButton);
		return this.waitForPageToLoad(SuccessPage.class, RegisterPage.class);

	}

	public void fillingRegistrationForm(String firstName, String lastName, String email, String telephone,
			String password, String passwordConfirmed) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterTelephone(telephone);
		enterPassword(password);
		enterConfirmPassword(passwordConfirmed);

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
