package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

	@FindBy(xpath = "identifierId")
	WebElement USER_NAME_FIELD_LOCATOR;

	@FindBy(xpath = "identifierNext")
	WebElement NEXT_BUTTON_LOCATOR;

	@FindBy(xpath = "passwordNext")
	WebElement NEXT_BUTTON2_LOCATOR;

	@FindBy(xpath = "//input[@name='password']")
	WebElement PASSWORD_LOCATOR;


	public HomePage logIn(String email, String password) {
		testBase.type(USER_NAME_FIELD_LOCATOR, email);
		testBase.click(NEXT_BUTTON_LOCATOR);
		testBase.type(PASSWORD_LOCATOR, password);
		testBase.click(NEXT_BUTTON2_LOCATOR);
		return new HomePage();
	}

}
