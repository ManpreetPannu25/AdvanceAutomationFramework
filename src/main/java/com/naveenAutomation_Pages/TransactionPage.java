package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class TransactionPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/transaction";

	public TransactionPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By transactionMsg = By.xpath("//td[text()='You do not have any transactions!']");

	public String transactionMsgText() {
		return ((ProxyDriver) wd).getText(transactionMsg);

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
