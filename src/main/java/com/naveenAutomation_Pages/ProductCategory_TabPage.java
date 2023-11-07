package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class ProductCategory_TabPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=product/category&path=57";

	public ProductCategory_TabPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By addToCartLink = By.xpath("//span[text()='Add to Cart']");
	private static final By addToCartSuccessMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public String addToCartSuccessMsgText() {
		return ((ProxyDriver) wd).getText(addToCartSuccessMsg);

	}

	public void addToCartLinkClick() {
		((ProxyDriver) wd).click(addToCartLink);

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
