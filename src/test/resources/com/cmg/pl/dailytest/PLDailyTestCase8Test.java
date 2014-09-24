package com.cmg.pl.dailytest;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot.*;

public class PLDailyTestCase8Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://pensionline.bp.com/content/pl/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		init(driver);
	}

	@Test
	public void testPLDailyTestCase8() throws Exception {
		// Begin to load member BPF-0001341(Security lock-out in place)!
		System.out.println("Begin to load member BPF-0001341(Security lock-out in place)!");
		selenium.open("/content/pl");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "superuser");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(8000);
		selenium.select("id=bgroup", "label=BPF");
		selenium.type("id=crefno", "0001341");
		selenium.click("id=doauth");
		Thread.sleep(8000);
		selenium.click("link=My details");
		selenium.waitForPageToLoad("30000");
		// Ensure this member only has 'This is me' and 'My Benefits', 'My Annual Allowance', 'My Carry Forward' under 'My details' left menu
		Thread.sleep(10000);
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'This is me')]"));
		Thread.sleep(8000);
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My  Benefits')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Annual Allowance')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Carry Forward')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Accrual Rate')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My benefits')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My retirement')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Redundancy')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Scheme pays')]"));
		// Access 'This is me' page
		selenium.click("link=This is me");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// May take a snapshot here
		takeScreenshoot();
		// Access 'My Benefits' page
		selenium.click("link=My Benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Scheme benefits')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'State benefits')]"));
		selenium.click("link=Scheme benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		assertTrue(selenium.isElementPresent("//table[@id='member_id' and @class='datatable']/tbody/tr[2]/td[1][@class='member_refno']/strong[contains(text(),'0001341')]"));
		// May take a snapshot here
		takeScreenshoot();
		// Access State benefits
		selenium.click("link=State benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// May take a snapshot here
		takeScreenshoot();
		// Access 'My Annual Allowance' page
		selenium.click("link=My Annual Allowance");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(8000);
		// Ensure that user cannot access 'My Projection' under 'My Annual Allowance'
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Projection')]"));
		// Access 'My Carry Forward' page
		selenium.click("link=My Carry Forward");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// May take a snapshot here
		takeScreenshoot();
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(8000);
		assertTrue(selenium.isElementPresent("//input[@class='goButton']"));
		Thread.sleep(8000);
		selenium.click("//input[@class='goButton']");
		// Finish
		System.out.println("Loading member BPF-0001341(Security lock-out in place) PASS!");
		// ----------------------------------------
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
