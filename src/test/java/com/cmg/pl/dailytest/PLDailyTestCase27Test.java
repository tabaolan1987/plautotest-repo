package com.cmg.pl.dailytest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class PLDailyTestCase27Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase27() throws Exception {
		selenium.click("link=I want to...");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Change my password");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("New password"));
		System.out.println("BPPensioner-change password-PASSED");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
