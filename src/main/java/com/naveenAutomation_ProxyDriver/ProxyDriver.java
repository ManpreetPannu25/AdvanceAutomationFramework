package com.naveenAutomation_ProxyDriver;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProxyDriver implements WebDriver, JavascriptExecutor, TakesScreenshot {

	public WebDriver wd;

	public ProxyDriver(WebDriver wd) {
		this.wd = wd;
	}

	@Override
	public void get(String url) {
		ProxyDriver.this.wd.get(url);
	}

	@Override
	public String getCurrentUrl() {
		return ProxyDriver.this.wd.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return ProxyDriver.this.wd.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return ProxyDriver.this.wd.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return ProxyDriver.this.wd.findElement(by);
	}

	@Override
	public String getPageSource() {
		return ProxyDriver.this.wd.getPageSource();
	}

	@Override
	public void close() {
		ProxyDriver.this.wd.close();
	}

	@Override
	public void quit() {
		ProxyDriver.this.wd.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		return wd.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return wd.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return null;
	}

	@Override
	public Navigation navigate() {
		new Navigation() {

			@Override
			public void to(URL url) {

			}

			@Override
			public void to(String url) {
				ProxyDriver.this.wd.get(url);

			}

			@Override
			public void refresh() {
				ProxyDriver.this.wd.navigate().refresh();

			}

			@Override
			public void forward() {
				ProxyDriver.this.wd.navigate().forward();

			}

			@Override
			public void back() {
				ProxyDriver.this.wd.navigate().back();
			}
		};
		return null;
	}

	@Override
	public Options manage() {
		return wd.manage();
	}

	@Override
	public Object executeScript(String script, Object... args) {
		return ((JavascriptExecutor) wd).executeScript(script, args);
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {
		return ((JavascriptExecutor) wd).executeAsyncScript(script, args);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return (X) ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementToBeClickable(WebElement element, int timeOutInSeconds) {
		return new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeSelectable(WebElement element) {
		new WebDriverWait(this, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	public WebElement waitForElementToBeVisible(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToBePresent(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void click(By by) {
		waitForElementToBeClickable(by, 10).click();
	}

	public void click(WebElement element) {
		waitForElementToBeClickable(element, 10).click();
	}

	public void selectItemFromDropDown(WebElement element, String text) {
		waitForElementToBeSelectable(element);
		Select sc = new Select(element);
		try {
			sc.selectByVisibleText(text);
		} catch (Exception e) {
			sc.selectByValue(text);
		}
	}

	public void submit(By by) {
		waitForElementToBeClickable(by, 20).submit();
	}

	public void clear(By by) {
		waitForElementToBePresent(by, 10).clear();
	}

	public void sendKeys(By by, String inputText) {
		waitForElementToBeVisible(by, 10).sendKeys(inputText);
	}

	public String getText(By by) {
		return getText(by, 10);
	}

	public String getText(By by, int waitForElementToBeVisibleInSec) {
		try {
			WebElement element = this.waitForElementToBeVisible(by, waitForElementToBeVisibleInSec);
			return element.getText().trim();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean isDisplayed(By by) {
		return waitForElementToBePresent(by, 10).isDisplayed();
	}

	public boolean isEnabled(By by) {
		return waitForElementToBeVisible(by, 10).isEnabled();
	}

	public void acceptAlert() {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert() {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public void switchToNewTab(By element) {
		String parentHandle = this.getWindowHandle();
		waitForElementToBeClickable(element, 5);
		Set<String> allWindowHandles = this.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentHandle)) {
				this.switchTo().window(windowHandle);
			}
		}

	}

}
