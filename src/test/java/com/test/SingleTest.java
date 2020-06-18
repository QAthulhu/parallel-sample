package com.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SingleTest extends BrowserStackTestNGTest {
	
	@Test
	public void test() throws Exception {
		Log.info("Creating driver");
		driver = new AndroidDriver(new URL("http://localhost:10000/wd/hub"), capabilities);
		Log.info("Starting test");
		assertTrue(true);
		waitForElementToBeDisplayed(By.xpath("//android.support.v7.widget.LinearLayoutCompat//android.widget.ImageView?"));
//		assertTrue(isElementDisplayed(By.id("com.loginmodule.learning:id/textInputEditTextEmail")));
	}
	@Test
	public void test2() throws Exception {
		driver = new AndroidDriver(new URL("http://localhost:10001/wd/hub"), capabilities);
		Log.info("Starting test2");
		assertTrue(true);
		waitForElementToBeDisplayed(By.xpath("//android.support.v7.widget.LinearLayoutCompat//android.widget.ImageView?"));
//		assertTrue(isElementDisplayed(By.id("com.loginmodule.learning:id/textInputEditTextEmail")));
	}
	private boolean waitForElementToBeDisplayed(By element) {
		Log.info("Waiting for element with Locator to be displayed: {}", element);
		FluentWait<AndroidDriver<MobileElement>> longWait = new FluentWait<AndroidDriver<MobileElement>>(driver)
    			.withTimeout(Duration.ofSeconds(5))
    			.pollingEvery(Duration.ofMillis(50))
    			.ignoring(NoSuchElementException.class);
		Log.info("\tWait object created");
		try {
			longWait.until(ExpectedConditions.visibilityOfElementLocated(element));
			Log.info("\tElement is displayed");
			return true;
		} catch( TimeoutException e ) {
			Log.warn("\tElement '{}' not displayed within {} seconds", element, 10);
			return false;
		}
	}
	protected boolean isElementDisplayed(By element) {
		Log.info("Verifying if {} element is displayed", element);
		try {
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(element));
//			driver.findElement(element).isDisplayed();
			Log.info("\tElement is displayed");
			return true;
		} catch( TimeoutException e ) {
			Log.info("\tElement is not displayed");
			return false;
		}
	}
}
