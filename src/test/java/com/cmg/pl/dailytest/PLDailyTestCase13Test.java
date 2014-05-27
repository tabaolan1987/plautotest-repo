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

public class PLDailyTestCase13Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase13() throws Exception {
		selenium.open("/content/pl/I_want_to/");
		selenium.click("link=Update something");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Address");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("MyHR service center"));
		selenium.click("link=Phone numbers");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("MyHR service center"));
		assertFalse(selenium.isElementPresent("link=Contributions"));
		assertFalse(selenium.isElementPresent("link=Expression of wish"));
		assertFalse(selenium.isElementPresent("link=Bank details"));
		assertFalse(selenium.isElementPresent("link=Email address"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input.goButton");
		selenium.waitForPageToLoad("30000");
		System.out.println("BCActive-Update sth- PASS");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
