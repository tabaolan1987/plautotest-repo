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

public class PLDailyTestCase19Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase19() throws Exception {
		selenium.open("/content/pl/I_want_to/change_password.html");
		selenium.click("link=Update something");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Expression of wish");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
		assertTrue(selenium.isTextPresent("Part A"));
		selenium.click("link=Contributions");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		assertTrue(selenium.isTextPresent("current contributory option"));
		selenium.click("link=Address");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		assertTrue(selenium.isTextPresent("contacting your MyHR service center"));
		selenium.click("link=Phone numbers");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		assertTrue(selenium.isTextPresent("contacting your MyHR service center"));
		assertFalse(selenium.isElementPresent("link=Bank details"));
		assertFalse(selenium.isElementPresent("link=Email address"));
		System.out.println("BPActive Update sth- PASSED");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
