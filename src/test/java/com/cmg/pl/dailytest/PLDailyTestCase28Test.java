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

public class PLDailyTestCase28Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase28() throws Exception {
		selenium.open("/content/pl/I_want_to/change_password.html");
		selenium.click("link=Update something");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Expression of wish");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isTextPresent("Part A"));
		assertTrue(selenium.isTextPresent("Part B"));
		assertTrue(selenium.isTextPresent("Part C"));
		selenium.click("link=Address");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isTextPresent("review your details"));
		assertTrue(selenium.isTextPresent("Post code"));
		selenium.click("link=Phone numbers");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isTextPresent("Telephone"));
		assertTrue(selenium.isTextPresent("Mobile"));
		selenium.click("link=Email address");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isTextPresent("update my email address"));
		assertTrue(selenium.isTextPresent("submitting this form"));
		selenium.click("link=Newsletter delivery");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertTrue(selenium.isTextPresent("New delivery choice"));
		assertFalse(selenium.isElementPresent("link=Contributions"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input.goButton");
		selenium.waitForPageToLoad("30000");
		System.out.println("BPPensioner-Update sth-PASSED");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
