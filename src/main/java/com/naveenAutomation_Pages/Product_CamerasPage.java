package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class Product_CamerasPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=product/product&path=33&product_id=31&limit=15";

	public Product_CamerasPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By quantity = By.id("input-quantity");
	private static final By addToCart = By.id("button-cart");
	private static final By cartTotal = By.id("cart-total");

	public void adjustingQuantityOfProduct(String quantityInput) {
		((ProxyDriver) wd).click(quantity);
		((ProxyDriver) wd).clear(quantity);
		((ProxyDriver) wd).sendKeys(quantity, quantityInput);
	}

	public void addToCartLinkClick() {
		((ProxyDriver) wd).click(addToCart);
	}

	public String cartTotalText() {
		return ((ProxyDriver) wd).getText(cartTotal);
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
