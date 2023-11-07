package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.ProductCategory_CamerasPage;
import com.naveenAutomation_Pages.ProductCategory_PhonesPage;
import com.naveenAutomation_Pages.Product_CamerasPage;

public class Product_CamerasPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	Product_CamerasPage product_CamerasPage;
	ProductCategory_CamerasPage productCategory_CamerasPage;

	@Test
	public void validateCartAfterAdjustingProductQuantity() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		productCategory_CamerasPage = accountPage.camerasLinkClick();
		product_CamerasPage=productCategory_CamerasPage.nikonCameraLinkClick();
		product_CamerasPage.adjustingQuantityOfProduct("2");
		product_CamerasPage.addToCartLinkClick();
		Assert.assertEquals(product_CamerasPage.cartTotalText(),
				" 2 item(s) - $196.00",
				"Item not added to the cart");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}

