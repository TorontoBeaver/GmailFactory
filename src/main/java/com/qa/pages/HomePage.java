package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {


	@FindBy(xpath = "//div[@aria-label=\"NewOne\"]")
	WebElement NEW_FOLDER_LOCATOR;

	@FindBy(xpath = "//span[text()='Tesla.jpg']")
	WebElement FILE_LOCATOR;

	@FindBy(xpath = "//span[@data-tooltip='My Drive']")
	WebElement GOOGLE_DRIVE_LOCATOR;

	@FindBy(xpath = "//a[@aria-label=\"Drive\"]")
	WebElement GOOGLE_DRIVE_LOCATOR2;

	@FindBy(xpath = "//div[@data-target=\"sortSwitcherContainer\"]")
	WebElement GOOGLE_MIDDLE_POINT;

	@FindBy(xpath = "(//input[@class=\"lb-k-Kk g-Gh\"])")
	WebElement NEW_FOLDERNAME_LOCATOR;

	@FindBy(xpath = "//button[@name=\"ok\"]")
	WebElement BUTTON_NAME_CREATE_LOCATOR;

	@FindBy(xpath = "//button[@aria-label=\"New\"]")
	WebElement NEW_BUTTON_LOCATOR;

	@FindBy(xpath = "//*[@id=\":48\"]/div/span[2]/span/div")
	WebElement LOCATOR;

	@FindBy(xpath = "/html/body/input[2]")
	WebElement LOCATOR_222;

	@FindBy(xpath = "//div[@aria-label=\"Tesla.jpg\"]")
	WebElement NEW_LOCATION_FILE_LOCATOR;

	@FindBy(xpath = "//span[@data-tooltip=\"Trashed items\"]")
	WebElement TRASH_BIN_LEFT_SIDE;


	public void dragAndDropeFile() {

		testBase.dragAndDrop(FILE_LOCATOR, NEW_FOLDER_LOCATOR);
	}


	public void openNewFolder() {

		testBase.doubleClick(NEW_FOLDER_LOCATOR);
	}

	public void relocateFileFromFolderToMyDrive() {

		testBase.dragAndDrop(NEW_LOCATION_FILE_LOCATOR, GOOGLE_DRIVE_LOCATOR);
	}

	public void removeNewFolder() {
		testBase.dragAndDrop(NEW_FOLDER_LOCATOR, TRASH_BIN_LEFT_SIDE);
	}

	public void openDrive() {
		testBase.click(GOOGLE_DRIVE_LOCATOR2);
	}

	public void mouseRightClick() {
		testBase.rightClick(GOOGLE_MIDDLE_POINT);
	}

	public void newFolderCreation() {

		testBase.highlightElement(NEW_FOLDERNAME_LOCATOR);
		testBase.type(NEW_FOLDERNAME_LOCATOR, prop.getProperty("newFolderName"));
		testBase.highlightElement(BUTTON_NAME_CREATE_LOCATOR);
		testBase.click(BUTTON_NAME_CREATE_LOCATOR);
		testBase.waitForElementVisible(NEW_FOLDER_LOCATOR);


	}

}
