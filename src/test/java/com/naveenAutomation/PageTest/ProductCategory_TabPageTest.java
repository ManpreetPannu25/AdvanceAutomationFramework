package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.ProductCategory_TabPage;
import com.naveenAutomation_Pages.VoucherPage;

public class ProductCategory_TabPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ProductCategory_TabPage productCategoryTabPage;;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Test
	public void validateProductPriceIsDisplayedUnderProduct() {
		accountPage = (AccountPage) loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		productCategoryTabPage = (ProductCategory_TabPage) accountPage.tabletsLinkClickLink();
		Assert.assertEquals(productCategoryTabPage.priceText(), "Ex Tax: $199.99", "Price is not mentioned");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
