package com.wakatuts.tests;

import org.testng.annotations.Test;

import com.wakatuts.core.Verify;
import com.wakatuts.pages.actions.CommonObjectActions;
import com.wakatuts.pages.actions.ContactPageActions;

public class ContactTest extends BaseTest {

	@Test(description="Test Case 1")
	public static void contactPageErrorsTest() {
		openBrowser("http://jupiter.cloud.planittesting.com");
		CommonObjectActions.goToContact();
		ContactPageActions.submit();
		Verify.isTrue(ContactPageActions.areContactTextInputErrorsDisplayed(),
				"Contact Page errors are displayed");
		Verify.equals(ContactPageActions.getHeaderMessage(), 
				"We welcome your feedback - but we won't get it unless you complete the form correctly.");
		ContactPageActions.fillRequiredContactDetails("John", "testEmail@gmail.com", "This is a test message");
		Verify.isFalse(ContactPageActions.areContactTextInputErrorsPresent(), 
				"Contact Page errors are no longer present");
		Verify.equals(ContactPageActions.getHeaderMessage(), 
				"We welcome your feedback - tell it how it is.");
	}
	
	@Test(invocationCount=5)
	public static void submitFeedbackTest() {
		openBrowser("http://jupiter.cloud.planittesting.com");
		CommonObjectActions.goToContact();
		ContactPageActions.fillRequiredContactDetails("John", "testEmail@gmail.com", "This is a test message");
		ContactPageActions.submit();
		Verify.isTrue(CommonObjectActions.isLoadingAnimationNotPresent(),
				"Loading animations are not present");
		Verify.equals(ContactPageActions.getHeaderMessage(), 
				"Thanks John, we appreciate your feedback.");
		ContactPageActions.goBack();
	}

}
