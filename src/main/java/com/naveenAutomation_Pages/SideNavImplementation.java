package com.naveenAutomation_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class SideNavImplementation extends Page {

	public SideNavImplementation(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	@Override
	protected void isLoaded() {

	}

	public Page OpenPageByClickOnSideNavBar(SideNavigationBar item) {
		List<WebElement> sideBarItems = wd.findElements(By.cssSelector("div.list-group a"));

		for (WebElement webElement : sideBarItems) {
			if (webElement.getText().trim().equalsIgnoreCase(item.getItem())) {
				((ProxyDriver) wd).click(webElement);
				return (Page) this.waitForPageToLoad(item.getpageClass());
			}
		}
		return null;
	}

}
