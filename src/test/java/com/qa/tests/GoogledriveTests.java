package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.IntroductionPage;
import com.qa.pages.LoginPage;
import com.qa.pages.Utils.PropertyLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class GoogledriveTests {
	Properties prop = PropertyLoader.loadProps("/Users/vladimirnemtcev/Google Drive/Google Drive/GmailPageFactoryTests/src/main/java/com/qa/config/config.properties");

	@Test
	public void createFolderTest() {
		new IntroductionPage().open().clickSignInButton();
		new LoginPage().logIn(prop.getProperty("username"), prop.getProperty("password"));
		new HomePage().mouseRightClick();
		new HomePage().newFolderCreation();
		new HomePage().openDrive();
		new HomePage().removeNewFolder();
		new HomePage().openDrive();

	}

	@Test
	public void moveFileToNewFolder() {
		new IntroductionPage().open().clickSignInButton();
		new LoginPage().logIn(prop.getProperty("username"), prop.getProperty("password"));
		new HomePage().mouseRightClick();
		new HomePage().newFolderCreation();
		new HomePage().dragAndDropeFile();
		new HomePage().openNewFolder();
		new HomePage().relocateFileFromFolderToMyDrive();
		new HomePage().openDrive();
		new HomePage().removeNewFolder();
		new HomePage().openDrive();
	}




	@AfterMethod(description = "close browser")
	public void kill() {
		TestBase.kill();
	}
}
