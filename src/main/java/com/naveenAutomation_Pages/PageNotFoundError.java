package com.naveenAutomation_Pages;

@SuppressWarnings("serial")
public class PageNotFoundError extends Error {

	public PageNotFoundError(Class<? extends GeneralPage> pageNotFound) {
		super(String.format("%s not found", pageNotFound));
	}
}