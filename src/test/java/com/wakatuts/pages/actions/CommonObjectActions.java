package com.wakatuts.pages.actions;

import com.wakatuts.pages.CommonObjects;

public class CommonObjectActions extends CommonObjects {
	
	public static ContactPageActions goToContact() {
		menuContact.click();
		return new ContactPageActions();
	}

	public static boolean isLoadingAnimationNotPresent() {
		return loader.isNotPresent(15);
	}

}
