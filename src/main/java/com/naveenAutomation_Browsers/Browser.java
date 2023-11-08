package com.naveenAutomation_Browsers;

public enum Browser {

	CHROME("Chrome"), 
	EDGE("Edge"), 
	FIREFOX("Firefox"),
	OPERA("Opera "),
	IE("Internet Explorer"),
	SAFARI("Safari");

	String browser;

	private Browser(String browser) {
		this.browser = browser;
	}
}
