package com.naveenAutomation_Base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import com.naveenAutomation_Browsers.Browser;

public class ManageInGridOptions {
	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-infobars");
		return options;

	}

	private EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.setCapability("InPrivate", true);
		options.addArguments("start-maximized");
		options.addArguments("--headless=new");
		options.addArguments("start-maximized");
		return options;

	}

	private FirefoxOptions getFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless=new");
		options.addArguments("-private");
		return options;

	}

	private SafariOptions getSafariOptions() {
		SafariOptions options = new SafariOptions();
		return options;
	}

	public MutableCapabilities getOption(Browser gridBrowser) {
		switch (gridBrowser) {
		case CHROME:
			return this.getChromeOptions();

//		case EDGE:
//			return this.getEdgeOptions();
//
//		case FIREFOX:
//			return this.getFireFoxOptions();

		case SAFARI:
			return this.getSafariOptions();

		default:
			throw new IllegalArgumentException();
		}

	}

}
