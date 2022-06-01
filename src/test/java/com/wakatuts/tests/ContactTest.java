package com.wakatuts.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wakatuts.pages.actions.CommonObjectActions;
import com.wakatuts.pages.actions.ContactPageActions;

public class ContactTest extends BaseTest {

	@Test
	public static void contactPageErrorsTest() {
		openBrowser("http://jupiter.cloud.planittesting.com");
		CommonObjectActions.goToContact();
		ContactPageActions.submit();
		Assert.assertTrue(ContactPageActions.areContactTextInputErrorsDisplayed());
		Assert.assertEquals(ContactPageActions.getHeaderMessage(), 
				"We welcome your feedback - but we won't get it unless you complete the form correctly.");
		ContactPageActions.fillRequiredContactDetails("John", "testEmail@gmail.com", "This is a test message");
		Assert.assertFalse(ContactPageActions.areContactTextInputErrorsPresent());
		Assert.assertEquals(ContactPageActions.getHeaderMessage(), 
				"We welcome your feedback - tell it how it is.");
	}
	
	@Test(invocationCount=5)
	public static void submitFeedbackTest() {
		openBrowser("http://jupiter.cloud.planittesting.com");
		CommonObjectActions.goToContact();
		ContactPageActions.fillRequiredContactDetails("John", "testEmail@gmail.com", "This is a test message");
		ContactPageActions.submit();
		Assert.assertTrue(CommonObjectActions.isLoadingAnimationNotPresent());
		Assert.assertEquals(ContactPageActions.getHeaderMessage(), 
				"Thanks John, we appreciate your feedback.");
		ContactPageActions.goBack();
	}

}
