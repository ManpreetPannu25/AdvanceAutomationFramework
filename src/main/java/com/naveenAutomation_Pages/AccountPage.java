package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class AccountPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/account";

	public AccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By myAccountText = By.cssSelector("#content>h2:first-of-type");
	private static final By infoUpdateSuccessMsg = By.cssSelector(".alert-success");
	private static final By newsletterSuccessMsg = By.cssSelector("div.alert-success");
	private static final By passwordUpdatedSuccessMsg = By.cssSelector("div.alert-success");
	private static final By tabletsLink = By.xpath("//a[text()='Tablets']");
	private static final By addressBookEntryLink = By.xpath("//a[text()='Modify your address book entries']");
	private static final By returnsLink = By.xpath("//h5[text()='Customer Service']/following::li[2]/a");
	private static final By affilateLink = By.xpath("//a[text()='Edit your affiliate information']");
	private static final By affiliateRegistrSuccessMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public String affiliateRegistrSuccessMsgMsg() {
		return ((ProxyDriver) wd).getText(affiliateRegistrSuccessMsg);
	}

	public AccountAddressPage addressBookEntryLinkClick() {
		((ProxyDriver) wd).click(addressBookEntryLink);
		return new AccountAddressPage(wd, true);
	}

	public AffiliateEditPage affilateLinkClick() {
		((ProxyDriver) wd).click(affilateLink);
		return new AffiliateEditPage(wd, true);
	}

	public ReturnAddProductPage returnsLinkClick() {
		((ProxyDriver) wd).click(returnsLink);
		return new ReturnAddProductPage(wd, true);
	}

	public GeneralPage tabletsLinkClickLink() {
		((ProxyDriver) wd).click(tabletsLink);
		return this.waitForPageToLoad(ProductCategory_TabPage.class, AccountPage.class);

	}

	public String myAccountTextMsg() {
		return ((ProxyDriver) wd).getText(myAccountText);
	}

	public String infoUpdateSuccessMsgText() {
		return ((ProxyDriver) wd).getText(infoUpdateSuccessMsg);
	}

	public String newsletterSuccessMsgText() {
		return ((ProxyDriver) wd).getText(newsletterSuccessMsg);
	}

	public String passwordUpdatedSuccessMsgText() {
		return ((ProxyDriver) wd).getText(passwordUpdatedSuccessMsg);
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new PageNotFoundError(AccountPage.class);
		}

	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

}
