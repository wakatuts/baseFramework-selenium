package com.wakatuts.pages.actions;

import com.wakatuts.page.actions.IActions;
import com.wakatuts.pages.ContactPage;

public class ContactPageActions extends ContactPage implements IActions {
	
	@Override
	public Boolean isNavigatedToPage() {
		return messageHeader.isDisplayed();
	}
	
	public ContactPageActions submit() {
		buttonSubmit.click();
		return this;
	}
	
	public ContactPageActions fillRequiredContactDetails(String forname, String email, String message) {
		textInputForename.set(forname);
		textInputEmail.set(email);
		textInputMessage.set(message);
		return this;
	}
	
	public ContactPageActions goBack() {
		buttonBack.click();
		return this;
	}
	
	public boolean areContactTextInputErrorsDisplayed() {
		return (errorMessageForename.isDisplayed() && errorMessageSurname.isDisplayed() 
				&& errorMessageMessage.isDisplayed());
	}
	
	public boolean areContactTextInputErrorsPresent() {
		return (errorMessageForename.isPresent() && errorMessageSurname.isPresent() 
				&& errorMessageMessage.isPresent());
	}
	
	public String getStrongHeaderMessage() {
		return messageHeaderInBold.getText();
	}
	
	public String getHeaderMessage() {
		return messageHeader.getText();
	}

}
