package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class HomePage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=common/home";

	public HomePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By naveenImage = By.cssSelector("img[title='naveenopencart']");

	public boolean isImageDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(naveenImage);
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
