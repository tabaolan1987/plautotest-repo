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

public class PLDailyTestCase17Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase17() throws Exception {
		selenium.open("/content/pl/_logout_confirm.html");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "bpactive");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=This is me");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
		assertFalse(selenium.isTextPresent("[[null]]"));
		assertFalse(selenium.isTextPresent("NULL"));
		selenium.click("link=My Benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		selenium.click("link=Scheme benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		selenium.click("link=State benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		selenium.click("link=My retirement");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		selenium.click("link=My Annual Allowance");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=My AA Statement");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
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
		selenium.click("link=My Accrual Rate");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("[[NULL]]"));
		assertFalse(selenium.isElementPresent("link=My benefits"));
		assertFalse(selenium.isElementPresent("link=Redundancy"));
		System.out.println("BPActive-MyDetails-PASS");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
