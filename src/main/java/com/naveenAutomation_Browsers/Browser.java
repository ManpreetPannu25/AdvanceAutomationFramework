package com.naveenAutomation_Browsers;

public enum Browser {


	CHROME("Chrome"),
	EDGE("Edge"), 
	FIREFOX("Firefox"), 
	IE("Internet Explorer"),
	OPERA("Opera"),
	SAFARI("Safari");

	String browser;

	private Browser(String browser) {
		this.browser = browser;
	}
}
