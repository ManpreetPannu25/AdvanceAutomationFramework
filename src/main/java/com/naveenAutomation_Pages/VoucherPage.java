package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class VoucherPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/voucher";

	public VoucherPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By recipientsName = By.id("input-to-name");
	private static final By recipientsEmail = By.id("input-to-email");
	private static final By yourName = By.id("input-from-name");
	private static final By yourEmail = By.id("input-from-email");
	private static final By giftTheme = By.cssSelector("input[name='voucher_theme_id']");
	private static final By inputMsg = By.id("input-message");
	private static final By giftAmount = By.id("input-amount");
	private static final By checkbox = By.cssSelector("input[type='checkbox']");
	private static final By submitBtn = By.cssSelector("input[type='submit']");
	private static final By invalidrecipientsNameWarning = By.cssSelector("div.text-danger");
	private static final By invalidrecipientsEmailWarning = By.cssSelector("div.text-danger");
	private static final By giftCertificateWarning = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	public String invalidrecipientsNameWarningText() {
		return ((ProxyDriver) wd).getText(invalidrecipientsNameWarning);
	}

	public String invalidrecipientsEmailWarningText() {
		return ((ProxyDriver) wd).getText(invalidrecipientsEmailWarning);
	}

	public String giftCertificateWarningText() {
		return ((ProxyDriver) wd).getText(giftCertificateWarning);
	}

	public void enterRecipientsName(String rName) {
		((ProxyDriver) wd).sendKeys(recipientsName, rName);
	}

	public void enterRecipientsEmail(String rEmail) {
		((ProxyDriver) wd).sendKeys(recipientsEmail, rEmail);
	}

	public void enterYourName(String name) {
		((ProxyDriver) wd).sendKeys(yourName, name);
	}

	public void enterYourEmail(String email) {
		((ProxyDriver) wd).sendKeys(yourEmail, email);
	}

	public void clickGiftTheme() {
		((ProxyDriver) wd).click(giftTheme);
	}

	public void enterGiftMessage(String msg) {
		((ProxyDriver) wd).sendKeys(inputMsg, msg);
	}

	public void enterGiftAmount(String amount) {
		((ProxyDriver) wd).clear(giftAmount);
		((ProxyDriver) wd).sendKeys(giftAmount, amount);
	}

	public void clickCheckBox() {
		((ProxyDriver) wd).click(checkbox);
	}

	public SuccessPage clickSubmitBtn() {
		((ProxyDriver) wd).click(submitBtn);
		return new SuccessPage(wd, true);
	}

	public void fillingVoucherForm(String rName, String rEmail, String name, String email, String msg, String amount) {
		enterRecipientsName(rName);
		enterRecipientsEmail(rEmail);
		enterYourName(name);
		enterYourEmail(email);
		clickGiftTheme();
		enterGiftMessage(msg);
		enterGiftAmount(amount);

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
