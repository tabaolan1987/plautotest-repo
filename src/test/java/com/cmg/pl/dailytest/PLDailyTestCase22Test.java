package com.cmg.pl.dailytest;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class PLDailyTestCase22Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase22() throws Exception {
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
		assertTrue(selenium.isTextPresent("Email"));
		assertTrue(selenium.isTextPresent("submitting this form"));
		assertFalse(selenium.isElementPresent("link=Contributions"));
		assertFalse(selenium.isElementPresent("link=Newsletter delivery"));
		assertFalse(selenium.isElementPresent("link=Bank details"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input.goButton");
		selenium.waitForPageToLoad("30000");
		System.out.println("BPDeffered-Update sth-PASSED");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
