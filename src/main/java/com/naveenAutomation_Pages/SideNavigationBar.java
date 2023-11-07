package com.naveenAutomation_Pages;

public enum SideNavigationBar {
	EDIT_ACCOUNT("Edit Account", InfoEditPage.class), 
	PASSWORD("Password", PasswordChangePage.class),
	WISH_LIST("Wish List", WishListPage.class), 
	RECURRING_PAYMENTS("Recurring payments", RecurringPaymentsPage.class),
	REWARD_POINTS("Reward Points", RewardsPointPage.class), 
	TRANSACTIONS("Transactions", TransactionPage.class),
	RETURNS("Returns", ProductReturnPage.class), 
	NEWSLETTER("Newsletter", NewsletterPage.class),
	LOGOUT("Logout", LogoutPage.class);

	private String item;
	private Class<? extends Page> _pageClass;

	SideNavigationBar(String sideNavBarMenu, Class<? extends Page> pageClass) {
		this.item = sideNavBarMenu;
		this._pageClass = pageClass;
	}

	public String getItem() {
		return item;
	}

	public Class<? extends Page> getpageClass() {
		return _pageClass;
	}

	public static SideNavigationBar getItemByText(String text) {
		SideNavigationBar[] all = SideNavigationBar.values();
		for (int i = 0; i < all.length; i++) {
			if (all[i].name().toLowerCase().equalsIgnoreCase(text)) {
				return all[i];
			}
		}
		return null;

}
}
