package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class ProductCategory_CamerasPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=product/category&path=33";

	public ProductCategory_CamerasPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By nikonCameraLink = By.xpath("//a[text()='Nikon D300']");

	public Product_CamerasPage nikonCameraLinkClick() {
		((ProxyDriver) wd).click(nikonCameraLink);
		return new Product_CamerasPage(wd, true);
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
