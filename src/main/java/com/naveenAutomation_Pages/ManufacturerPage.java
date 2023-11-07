package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class ManufacturerPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=product/manufacturer";

	public ManufacturerPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By htcProductLabel = By.xpath("//a[text()='HTC']");

	public String htcProductLabelText() {
		return ((ProxyDriver) wd).getText(htcProductLabel);
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
