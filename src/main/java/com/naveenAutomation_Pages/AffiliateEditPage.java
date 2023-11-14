package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class AffiliateEditPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/affiliate/edit";

	public AffiliateEditPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By companyInput = By.id("input-company");
	private static final By websiteInput = By.id("input-website");
	private static final By taxInput = By.id("input-tax");
	private static final By payeeName = By.id("input-cheque");
	private static final By submitBtn = By.cssSelector("input[type='submit']");
	private static final By invalidPayeeNameMsg = By.cssSelector("div.text-danger");

	public String invalidPayeeNameMsgText() {
		return ((ProxyDriver) wd).getText(invalidPayeeNameMsg);
	}

	private void taxInputFiled(String tax) {
		((ProxyDriver) wd).clear(taxInput);
		((ProxyDriver) wd).sendKeys(taxInput, tax);
	}

	private void enterCompanyName(String companyName) {
		((ProxyDriver) wd).clear(companyInput);
		((ProxyDriver) wd).sendKeys(companyInput, companyName);
	}

	private void enterWebsiteName(String websiteName) {
		((ProxyDriver) wd).clear(websiteInput);
		((ProxyDriver) wd).sendKeys(websiteInput, websiteName);
	}

	private void submitBtnClick() {
		((ProxyDriver) wd).click(submitBtn);
	}

	private void enterPayeeName(String namePayee) {
		((ProxyDriver) wd).clear(payeeName);
		((ProxyDriver) wd).sendKeys(payeeName, namePayee);
	}

	public GeneralPage fillingAffiliateForm(String companyName, String websiteName, String tax, String namePayee) {
		enterCompanyName(companyName);
		enterWebsiteName(websiteName);
		taxInputFiled(tax);
		enterPayeeName(namePayee);
		submitBtnClick();
		return this.waitForPageToLoad(AccountPage.class, AffiliateEditPage.class);
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
