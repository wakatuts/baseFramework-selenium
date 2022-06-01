package com.wakatuts.pages;

import org.openqa.selenium.By;

import com.wakatuts.element.base.Element;
import com.wakatuts.element.base.ElementImpl;
import com.wakatuts.element.widget.Label;
import com.wakatuts.element.widget.LabelImpl;
import com.wakatuts.element.widget.TextInput;
import com.wakatuts.element.widget.TextInputImpl;

public class ContactPage {
	
	protected static final Label messageHeaderInBold = new LabelImpl(By.xpath("//*[@id='header-message']//strong"), "Header message in bold");
	protected static final Label messageHeader = new LabelImpl(By.xpath("//div[contains(@class,'alert')]"), "Header message");
	protected static final Label errorMessageForename = new LabelImpl(By.id("forename-err"), "Forename error message");
	protected static final Label errorMessageSurname = new LabelImpl(By.id("email-err"), "Username error message");
	protected static final Label errorMessageMessage = new LabelImpl(By.id("message-err"), "Message error message");
	protected static final TextInput textInputForename = new TextInputImpl(By.id("forename"), "Forename text input");
	protected static final TextInput textInputSurname = new TextInputImpl(By.id("surname"), "Surname text input");
	protected static final TextInput textInputEmail = new TextInputImpl(By.id("email"), "Email text input");
	protected static final TextInput textInputTelephone = new TextInputImpl(By.id("telephone"), "Telephone text input");
	protected static final TextInput textInputMessage = new TextInputImpl(By.id("message"), "Message text input");
	protected static final Element buttonSubmit = new ElementImpl(By.xpath("//*[text()='Submit']"), "Submit button");
	protected static final Element buttonBack = new ElementImpl(By.xpath("//a[contains(.,'Back')]"), "Back button");

}
