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

public class PLDailyTestCase10Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://pensionline.bp.com/content/pl/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		init(driver);
	}

	@Test
	public void testPLDailyTestCase10() throws Exception {
		// Begin to load member BPF-0000445(active member)!
		System.out.println("Begin to load member BPF-0000445(active member)!");
		selenium.open("/content/pl");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "superuser");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(8000);
		selenium.select("id=bgroup", "label=BPF");
		selenium.type("id=crefno", "0000445");
		selenium.click("id=doauth");
		Thread.sleep(5000);
		selenium.click("link=My details");
		selenium.waitForPageToLoad("30000");
		// Ensure this member only has 'This is me' and 'My Benefits', 'My retirement', 'Redundancy', 'My Annual Allowance' & 'My Carry Forward' under 'My details' left menu
		Thread.sleep(8000);
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'This is me')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My  Benefits')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Annual Allowance')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Accrual Rate')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Carry Forward')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My benefits')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My retirement')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Redundancy')]"));
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
		assertTrue(selenium.isElementPresent("//table[@id='member_id' and @class='datatable']/tbody/tr[2]/td[1][@class='member_refno']/strong[contains(text(),'0000445')]"));
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
		// Access 'My retirement' page
		selenium.click("link=My retirement");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// Model some values in Retirement page...
		selenium.click("link=Retirement age");
		selenium.type("//input[@id='input_co_nra' and @class='slider_value']", "65");
		Thread.sleep(2000);
		selenium.click("//div[@id='age_panel' and @class='controlable_panel']/form/div[@class='slider_panel']/span[@class='goButton']");
		Thread.sleep(5000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// Model Contributory options
		selenium.click("link=Contributory options");
		selenium.select("id=input_co_option", "label=2:54");
		Thread.sleep(2000);
		selenium.click("//div[@id='contrib_option_panel' and @class='controlable_panel']/div[@class='slider_panel']/input[@class='goButton']");
		Thread.sleep(5000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// Model Cash lump sum
		selenium.click("link=Cash lump sum");
		selenium.type("//input[@id='input_co_cash' and @class='slider_value']", "152000");
		Thread.sleep(2000);
		selenium.click("//div[@id='cash_panel' and @class='controlable_panel']/div[@class='slider_panel']/input[2][@class='goButton']");
		Thread.sleep(5000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// May take a snapshot here
		takeScreenshoot();
		// Access 'Redundancy' page
		selenium.click("link=Redundancy");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.click("link=Redundancy date");
		selenium.type("//input[@id='input_co_nra' and @class='slider_,']", "20 November 2014");
		selenium.click("//div[@id='date_panel' and @class='controlable_panel']/form/div[@class='slider_panel']/input[2][@class='goButton']");
		Thread.sleep(5000);
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
		Thread.sleep(3000);
		// Ensure that user cannot access 'My Projection' under 'My Annual Allowance'
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Projection')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My AA Statement')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'AA Pension savings')]"));
		selenium.click("link=My AA Statement");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		selenium.click("link=AA Pension savings");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
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
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("//input[@class='goButton']"));
		Thread.sleep(3000);
		selenium.click("//input[@class='goButton']");
		// Finish
		System.out.println("Loading member BPF-0000445(active member) PASS!");
		// ----------------------------------------
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
