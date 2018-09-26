package com.qa.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

	private static final String DOWNLOAD_DIR = "DownloadsFolder";
	private static int PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS = 15;
	private static int COMMAND_DEFAULT_TIMEOUT_SECONDS = 20;
	private static int WAIT_ELEMENT_TIMEOUT = 10;
	private static String SCREENSHOTS_NAME_TPL = "screenshots/scr";

	private WebDriver driver;

	private static TestBase instance = null;

	private TestBase(WebDriver driver) {
		this.driver = driver;
	}


	public static TestBase getInstance() {

		if (instance != null) {
			return instance;
		}
		return instance = init();
	}

	private static TestBase init() {
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(COMMAND_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		return new TestBase(driver);
	}

	public void open(String url) {
		System.out.println("Going to URL: " + url);
		driver.get(url);
	}

	public static void kill() {
		if (instance != null) {
			try {
				instance.driver.quit();
			} finally {
				instance = null;
			}
		}
	}

	public void waitForElementVisible(WebElement element) {
		new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}

	public void highlightElement(WebElement element) {
		((JavascriptExecutor) element).executeScript("arguments[0].style.border='3px solid orange'", element);

	}

	public void unHighlightElement(WebElement element) {
		((JavascriptExecutor) element).executeScript("arguments[0].style.border='0px'", element);
	}

	public void click(WebElement element) {
		waitForElementVisible(element);
		System.out.println("Clicking element '" + element.getText() + "' (Located: " + element.getTagName());
		highlightElement(element);
		takeScreenshot();
		unHighlightElement(element);
		element.click();
	}

	public void clickForTwoArrowsDown(WebElement element) {

		System.out.println("Clicking element '" + element.getText() + "' (Located: " + element + ")");
		highlightElement(element);
		takeScreenshot();
		unHighlightElement(element);

		element.sendKeys("/src/main/java/com/qa/config/config.properties");
		takeScreenshot();
	}

	public void rightClick(WebElement element) {
		waitForElementVisible(element);
		System.out.println("Clicking right button on the element '" + element.getText() + "' (Located: " + element + ")");
		highlightElement(element);
		takeScreenshot();
		unHighlightElement(element);
		new Actions(driver).contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}

	public void doubleClick(WebElement element) {

		waitForElementVisible(element);
		System.out.println("Double clicking element '" + element.getText() + "' (Located: " + element + ")");
		highlightElement(element);
		takeScreenshot();
		unHighlightElement(element);
		new Actions(driver).doubleClick(element).perform();
		takeScreenshot();

	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void dragAndDrop(WebElement element, WebElement targetElement) {
		waitForElementVisible(element);
		waitForElementVisible(targetElement);
		takeScreenshot();
		System.out.println("Dragging element '" + element.getText() + "' (Located: " + element + ")" +
				"to '" + targetElement.getText() + "' (Located: " + targetElement + ")");
		(new Actions(driver)).dragAndDrop(element, targetElement).perform();
		takeScreenshot();
	}

	public void type(WebElement element, String text) {
		waitForElementVisible(element);
		highlightElement(element);
		System.out.println("Typing text '" + text + "' to input form '" + element.getAttribute("name") + "' (Located: " + element + ")");
		element.sendKeys(text);
		takeScreenshot();
		unHighlightElement(element);
	}

	public void takeScreenshot() {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
			File copy = new File(screenshotName + ".png");
			FileUtils.copyFile(screenshot, copy);
			System.out.println("Saved screenshot: " + screenshotName);
		} catch (IOException e) {
			System.out.println("Failed to make screenshot");
		}
	}
}


