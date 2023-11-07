package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class RewardsPointPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/reward";

	public RewardsPointPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By rewardsPointMsg = By.xpath("//td[text()='You do not have any reward points!']");

	public String rewardsPointMsgText() {
		return ((ProxyDriver) wd).getText(rewardsPointMsg);

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
