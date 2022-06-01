package com.wakatuts.pages.actions;

import com.wakatuts.pages.CommonObjects;

public class CommonObjectActions implements CommonObjects{
	
	public static void goToContact() {
		menuContact.click();
	}

	public static boolean isLoadingAnimationNotPresent() {
		return loader.isNotPresent(15);
	}

}
