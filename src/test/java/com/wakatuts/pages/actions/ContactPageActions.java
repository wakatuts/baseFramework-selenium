package com.wakatuts.pages.actions;

import com.wakatuts.pages.ContactPage;

public class ContactPageActions extends ContactPage {
	
	public static void submit() {
		buttonSubmit.click();
	}
	
	public static void fillRequiredContactDetails(String forname, String email, String message) {
		textInputForename.set(forname);
		textInputEmail.set(email);
		textInputMessage.set(message);
	}
	
	public static boolean areContactTextInputErrorsDisplayed() {
		return (errorMessageForename.isDisplayed() && errorMessageSurname.isDisplayed() 
				&& errorMessageMessage.isDisplayed());
	}
	
	public static boolean areContactTextInputErrorsPresent() {
		return (errorMessageForename.isPresent() && errorMessageSurname.isPresent() 
				&& errorMessageMessage.isPresent());
	}
	
	public static String getStrongHeaderMessage() {
		return messageHeaderInBold.getText();
	}
	
	public static String getHeaderMessage() {
		return messageHeader.getText();
	}
	
	public static void goBack() {
		buttonBack.click();
	}

}
