package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class ProductCategory_TabPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=product/category&path=57";

	public ProductCategory_TabPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By price = By.xpath("//span[text()='Ex Tax: $199.99']");

	public String priceText() {
		return ((ProxyDriver) wd).getText(price);

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
