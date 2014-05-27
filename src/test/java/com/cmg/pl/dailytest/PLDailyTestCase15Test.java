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

public class PLDailyTestCase15Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase15() throws Exception {
		selenium.open("/content/pl/mydetails/benefit_statement_pn.html");
		selenium.click("link=I want to...");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Change my password");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("New password"));
		System.out.println("BCPensioner-change password-PASSED");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
