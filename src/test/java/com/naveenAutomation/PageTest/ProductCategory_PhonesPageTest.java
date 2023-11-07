package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.ProductCategory_PhonesPage;

public class ProductCategory_PhonesPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ProductCategory_PhonesPage productCategoryPhonesPage;

	@Test
	public void validateSuccessMsgAfterSelectingItemForProductComparison() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		productCategoryPhonesPage = accountPage.phonePdaLinkClick();
		productCategoryPhonesPage.productComparisonLinkClick();
		Assert.assertEquals(productCategoryPhonesPage.productComparisonSuccessMsgText(),
				"Success: You have added HTC Touch HD to your product comparison!",
				"Item not selected for Product Comparison");
	}

	@Test
	public void validateSuccessMsgAfterAddingItemToWishlist() {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		productCategoryPhonesPage = accountPage.phonePdaLinkClick();
		productCategoryPhonesPage.addToWishListLinkClick();
		Assert.assertEquals(productCategoryPhonesPage.itemAddedToWishListSuccessMsgText(),
				"Success: You have added HTC Touch HD to your wish list!", "Item not added to Wishlist");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
