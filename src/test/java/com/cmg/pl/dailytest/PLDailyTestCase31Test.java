package com.cmg.pl.dailytest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class PLDailyTestCase31Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase31() throws Exception {
		selenium.open("/content/pl/I_want_to/change_password.html");
		selenium.click("link=Update something");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Address");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("MyHR service center"));
		selenium.click("link=Phone numbers");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("MyHR service center"));
		assertFalse(selenium.isElementPresent("link"));
		assertFalse(selenium.isElementPresent("link=Contributions"));
		assertFalse(selenium.isElementPresent("link=Expression of wish"));
		assertFalse(selenium.isElementPresent("link=Bank details"));
		assertFalse(selenium.isElementPresent("link=Email address"));
		assertFalse(selenium.isElementPresent("link=Newsletter delivery"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input.goButton");
		selenium.waitForPageToLoad("30000");
		System.out.println("BritoilActive-Update sth-PASSED");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
