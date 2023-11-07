package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.ProductCategory_TabPage;

public class ProductCategory_TabPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ProductCategory_TabPage productCategoryTabPage;

	@Test
	public void validateSuccessMsgAfterPuttingItemToCart() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		productCategoryTabPage = accountPage.tabletsLinkClickLink();
		productCategoryTabPage.addToCartLinkClick();
		Assert.assertEquals(productCategoryTabPage.addToCartSuccessMsgText(),
				"Success: You have added Samsung Galaxy Tab 10.1 to your shopping cart!", "Item not added to the Cart");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
