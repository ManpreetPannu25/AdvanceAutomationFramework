package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class AccountAddressEditPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/address/edit&address_id=4023";

	public AccountAddressEditPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	// private static final By province = By.id("input-zone");
	WebElement province = ((ProxyDriver) wd).findElement(By.id("input-zone"));
	private static final By address = By.id("input-address-1");
	private static final By continueBtn = By.cssSelector("input[type='submit']");
	private static final By warningMsg = By.cssSelector("div.text-danger");

	public void selectingProvince(String visibleText) {
		selectByVisibleText(province, visibleText);
	}

	public String warningMsgText() {
		return ((ProxyDriver) wd).getText(warningMsg);
	}

	public GeneralPage continueBtnClick() {
		((ProxyDriver) wd).click(continueBtn);
		return this.waitForPageToLoad(AccountAddressPage.class, AccountAddressEditPage.class);

	}

	public void enterAddress(String address1) {
		((ProxyDriver) wd).clear(address);
		((ProxyDriver) wd).sendKeys(address, address1);
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
