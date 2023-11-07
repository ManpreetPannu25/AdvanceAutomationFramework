package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class ProductCategory_PhonesPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=product/category&path=24";

	public ProductCategory_PhonesPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By productComparisonLink = By.cssSelector("button[data-toggle='tooltip']:nth-of-type(3)");
	private static final By productComparisonSuccessMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");
	private static final By addToWishListLink = By.cssSelector("div.button-group>button:nth-of-type(2)");
	private static final By itemAddedToWishListSuccessMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public String productComparisonSuccessMsgText() {
		return ((ProxyDriver) wd).getText(productComparisonSuccessMsg);

	}

	public void productComparisonLinkClick() {
		((ProxyDriver) wd).click(productComparisonLink);

	}

	public String itemAddedToWishListSuccessMsgText() {
		return ((ProxyDriver) wd).getText(itemAddedToWishListSuccessMsg);

	}

	public void addToWishListLinkClick() {
		((ProxyDriver) wd).click(addToWishListLink);

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
