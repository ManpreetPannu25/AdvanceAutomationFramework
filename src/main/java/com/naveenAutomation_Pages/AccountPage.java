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
	private static final By phonePdaLink = By.xpath("//a[text()='Phones & PDAs']");
	private static final By camerasLink = By.xpath("//a[text()='Cameras']");

	public ProductCategory_CamerasPage camerasLinkClick() {
		((ProxyDriver) wd).getText(camerasLink);
		return new ProductCategory_CamerasPage(wd, true);
	}

	public ProductCategory_TabPage tabletsLinkClickLink() {
		((ProxyDriver) wd).getText(tabletsLink);
		return new ProductCategory_TabPage(wd, true);
	}

	public ProductCategory_PhonesPage phonePdaLinkClick() {
		((ProxyDriver) wd).getText(phonePdaLink);
		return new ProductCategory_PhonesPage(wd, true);
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
