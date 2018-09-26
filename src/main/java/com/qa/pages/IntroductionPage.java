package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntroductionPage extends AbstractPage {


	@FindBy(xpath = "//a[@data-g-event=\"Drive\" and @data-g-action=\"Intro\"]")
	WebElement SIGNIN_BUTTON_LOCATOR;


	public IntroductionPage open() {

		testBase.open(prop.getProperty("googleWelcomePage"));

		return new IntroductionPage();
	}

	public LoginPage clickSignInButton() {

		testBase.click(SIGNIN_BUTTON_LOCATOR);

		return new LoginPage();
	}

}
