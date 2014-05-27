package com.cmg.pl.dailytest;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class PLDailyTestCase11Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase11() throws Exception {
		selenium.open("content/pl");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "bcactive");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=This is me");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		selenium.click("link=My Benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("null"));
		selenium.click("link=Scheme benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("null"));
		selenium.click("link=State benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("null"));
		selenium.click("link=My Annual Allowance");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("null"));
		selenium.click("link=My AA Statement");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		selenium.click("link=AA Pension savings");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		selenium.click("link=My Carry Forward");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isElementPresent("link=My retirement"));
		assertFalse(selenium.isElementPresent("link=My benefits"));
		assertFalse(selenium.isElementPresent("link=Redundancy"));
		assertFalse(selenium.isElementPresent("link=My Accrual Rate"));
		System.out.println("BC active- access to My details-PASS");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
