package com.naveenAutomation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class ReturnAddProductPage extends Page {
	public static final String PAGE_URL = "/opencart/index.php?route=account/return/add";

	public ReturnAddProductPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By calendarPreviosbtn = By.cssSelector("table.table-condensed>thead>tr>th:first-of-type");
	private static final By calendarBtn = By.cssSelector("div.input-group.date>span>button");
	private static final By selectingDate = By.xpath("//td[text()='20']");
	private static final By fName = By.id("input-firstname");
	private static final By lName = By.id("input-lastname");
	private static final By inputEmail = By.id("input-email");
	private static final By inputTelephone = By.id("input-telephone");
	private static final By orderId = By.id("input-order-id");
	private static final By productName = By.id("input-product");
	private static final By productModel = By.id("input-model");
	private static final By returnReason = By.cssSelector("div.radio>label>input");
	private static final By comment = By.id("input-comment");
	private static final By submitBtn = By.xpath("//input[@value='Submit']");
	private static final By orderIDWarningMsg = By.cssSelector("div.text-danger");
	private static final By invalidProductNameWarningMsg = By.cssSelector("div.text-danger");
	private static final By productModelWarning = By.cssSelector("div.text-danger");

	public void orderInformationForm(String firstName, String lastName, String email, String telephone,
			String orderID) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterTelephone(telephone);
		enterOrderId(orderID);
		calendarBtn();
		calendarPrevBtn();
		selectingDateBtn();

	}

	public String productModelWarningText() {
		return ((ProxyDriver) wd).getText(productModelWarning);

	}

	public String invalidProductNameWarningMsgText() {
		return ((ProxyDriver) wd).getText(invalidProductNameWarningMsg);

	}

	public String orderIDWarningMsgText() {
		return ((ProxyDriver) wd).getText(orderIDWarningMsg);
	}

	private void enterFirstName(String firstName) {
		((ProxyDriver) wd).clear(fName);
		((ProxyDriver) wd).sendKeys(fName, firstName);
	}

	private void enterLastName(String lastName) {
		((ProxyDriver) wd).clear(lName);
		((ProxyDriver) wd).sendKeys(lName, lastName);
	}

	private void enterEmail(String email) {
		((ProxyDriver) wd).clear(inputEmail);
		((ProxyDriver) wd).sendKeys(inputEmail, email);
	}

	private void enterTelephone(String telephone) {
		((ProxyDriver) wd).clear(inputTelephone);
		((ProxyDriver) wd).sendKeys(inputTelephone, telephone);
	}

	private void enterOrderId(String orderID) {
		((ProxyDriver) wd).sendKeys(orderId, orderID);
	}

	public void productInformationForm(String nameOfProduct, String model, String message) {
		enterProductName(nameOfProduct);
		enterProductModel(model);
		clickReturnReason();
		enterComment(message);
		clickOnSubmitBtn();
	}

	private void enterProductName(String nameOfProduct) {
		((ProxyDriver) wd).clear(productName);
		((ProxyDriver) wd).sendKeys(productName, nameOfProduct);
	}

	private void enterProductModel(String model) {
		((ProxyDriver) wd).clear(productModel);
		((ProxyDriver) wd).sendKeys(productModel, model);
	}

	private void enterComment(String message) {
		((ProxyDriver) wd).sendKeys(comment, message);
	}

	private void clickOnSubmitBtn() {
		((ProxyDriver) wd).click(submitBtn);
	}

	private void clickReturnReason() {
		((ProxyDriver) wd).click(returnReason);
	}

	private void calendarPrevBtn() {
		((ProxyDriver) wd).click(calendarPreviosbtn);
	}

	private void calendarBtn() {
		((ProxyDriver) wd).click(calendarBtn);
	}

	private void selectingDateBtn() {
		((ProxyDriver) wd).click(selectingDate);
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
