package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class Page extends GeneralPage {

	private static final String URL = "https://naveenautomationlabs.com";

	public Page(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		if (waitForPageToLoad) {
			this.waitForPageToLoad();
		}
	}
	public void selectByVisibleText(WebElement element, String visibleText) {
		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);

	}

	public String getDomain() {
		return URL;
	}

	@Override
	protected String getPageUrl() {
		return getDomain();
	}

	private void waitForPageToLoad() {
		this.isLoaded();
	}

}
