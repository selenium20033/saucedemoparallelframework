package com.saucedemo.utils;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

import junit.framework.Assert;

public class CommonMethods extends BaseClass {

	static JSWaiter js = new JSWaiter();
	
	//** File upload by Java Robot Class

	public static String uploadFileWithRobot (String imagePath) throws AWTException, InterruptedException, HeadlessException {
	    StringSelection stringSelection = new StringSelection(imagePath);
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(stringSelection, null);
	    Robot robot = new Robot();
	    
	    robot.delay(500);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.delay(300);
	    robot.keyRelease(KeyEvent.VK_ENTER);
		return imagePath;
	  
	}

	// * This method will select a specified value from a drop down

	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text " + text + " is selected");
				isSelected = true;
				break;
			}
		}
		if (!isSelected) {
			System.out.println("Option with text " + text + "is not available");
		}
	}

	// This method will enable to scroll to the bottom o the page to trigger lazy loading for all salary answers page content

	public static void salaryAnswersLazyLoading() throws InterruptedException {
		
		//System.out.println("Lazy loading configuration is disabled");
		
		//https://devint-liq.thinkwhy.com/?appSettings=(LAZY*_LOAD*_TILES~_F)~
		
		WebDriverWait wait=new WebDriverWait(driver,30);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		
		
		System.out.println("Width is: "+x);
		System.out.println("Height is: "+y);
		
		maxSync();

		new Actions(driver).moveByOffset(x/2, y/2).click().build().perform();
		for (int i = 0; i < 125; i++) {
			actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		}

		megaSync();

	}

	// This method will enable to scroll to the bottom o the page to trigger lazy loading for all salary answers page content
	
	
public static void benchmarkingLazyLoading() throws InterruptedException {
	
	
	//System.out.println("Lazy loading configuration is disabled");

		WebDriverWait wait=new WebDriverWait(driver,30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		
		
		System.out.println("Width is: "+x);
		System.out.println("Height is: "+y);
		
		maxSync();

		new Actions(driver).moveByOffset(x/5, y/5).click().build().perform();
		for (int i = 0; i < 125; i++) {
			actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		}

		megaSync();

	}
	

	// * This method will select a specified value from a drop down by its index

	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
		} else {
			System.out.println("Invalid index has been passed");
		}
	}

	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static void megaSync() throws InterruptedException {
		Thread.sleep(2000);
		js.waitForAngularLoad();
		js.waitUntilAngularReady();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void maxSync() throws InterruptedException {
		Thread.sleep(1000);
		js.waitForAngularLoad();
		js.waitUntilAngularReady();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void midSync() throws InterruptedException {

		Thread.sleep(500);
		js.waitForAngularLoad();
		js.waitUntilAngularReady();
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void minSync() throws InterruptedException {

		Thread.sleep(500);
		js.waitForAngularLoad();
		js.waitUntilAngularReady();
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	// ***************************************************************************

	// ***********************************************************************************************

	public void waitForPageLoaded() {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public static void waitForAngular() {

		jsDriver.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 20000);");
		new NgWebDriver(jsDriver).waitForAngularRequestsToFinish();

	}

	// Click the element
	public static void focusAndClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// ** Scroll the element into view
	public static void scrollAndClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}

	// ** Scroll by specific amount
	public static Boolean scrollAndFind(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,600);", element);
		return element.isDisplayed();
	}

	// ** Scroll to the respective element
	public static void scrollPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// * Method will accept alert

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	// * Method will dismiss alert

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	// * Method will get text of an alert

	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}
	}

	// * Method that will switch control to the specified frame

	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	// * Method that will switch control to the specified frame

	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	// * Method that will switch control to the specified frame

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	// * Method that will wait for element to be visible

	public static void waitForElementBeVisible(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementBeVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementBeClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementBeClickable(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static byte[] takeScreenshot() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screen = ts.getScreenshotAs(OutputType.BYTES);

		return screen;
	}

	public static void scrollDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public static void scrollUp(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixels + ")");
	}

	public static void jsClick(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void selectList(List<WebElement> countryList, String text) {

		// List<WebElement> listLocations = element.findElements(By.tagName("li"));
		for (WebElement li : countryList) {
			String liText = li.getAttribute("innerHTML");

			if (liText.contains(text)) {
				li.click();
				break;
			}
		}
	}
}