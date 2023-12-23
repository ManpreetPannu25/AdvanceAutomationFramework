package com.naveenAutomation_Browsers;

public enum Browser {


	CHROME("Chrome"),
	EDGE("Edge"), 
	FIREFOX("Firefox"), 
	IE("Internet Explorer"),
	OPERA("Opera"),
	SAFARI("Safari");

	public String getBrowser() {
		return browser;
	}

	String browser;

	private Browser(String browser) {
		this.browser = browser;
	}
}
