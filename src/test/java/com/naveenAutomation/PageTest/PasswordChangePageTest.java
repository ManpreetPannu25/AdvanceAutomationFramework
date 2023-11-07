package com.naveenAutomation.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.naveenAutomation_Base.TestBase;
import com.naveenAutomation_Pages.AccountPage;
import com.naveenAutomation_Pages.LoginPage;
import com.naveenAutomation_Pages.PasswordChangePage;
import com.naveenAutomation_Pages.SideNavImplementation;
import com.naveenAutomation_Pages.SideNavigationBar;
import com.naveenAutomation_Utils.ExcelUtils;

public class PasswordChangePageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	PasswordChangePage passwordChangePage;

	@BeforeMethod
	public void browserLaunch() {
		initialisation();
		loginPage = new LoginPage(driver, false).get();
	}

	@Test(dataProvider = "UserMismatchedInputPasswords")
	public void validateNoPswrdUpdateWithMismatchPswrdInputs(String password, String confirmedPassword) {
		accountPage = loginPage.loginPageSubmission("Manpreet202025@yahoo.com", "Manu1234");
		passwordChangePage = (PasswordChangePage) new SideNavImplementation(driver, false)
				.OpenPageByClickOnSideNavBar(SideNavigationBar.PASSWORD);
		passwordChangePage.submitPasswordChangedContinueBtn(password, confirmedPassword);
		Assert.assertEquals(passwordChangePage.getPasswordMismatchMsgText(),
				"Password confirmation does not match password!", "Password Changed Successfully");
	}

	@DataProvider(name = "UserMismatchedInputPasswords")
	public Object[][] getPasswordDataFromExcelSheet() throws Exception {
		logger.info("Reading from data Provider");
		String fileName = "C:\\Users\\16476\\Desktop\\Naveen.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(fileName, sheetName);
		int cellCount = ExcelUtils.getCellCount(fileName, sheetName, rowCount);
		String[][] virtualSheet = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(fileName, sheetName, i, j);
			}
		}
		return virtualSheet;

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
