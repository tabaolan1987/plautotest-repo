package com.cmg.pl.dailytest;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class PLDailyTestCase29Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase29() throws Exception {
		selenium.open("/content/pl/_logout_confirm.html");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "britoilactive");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.click("link=This is me");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("link=My Benefits");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Scheme benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("link=State benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("link=My Annual Allowance");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=My AA Statement");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("link=AA Pension savings");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("link=Additional info");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=My Carry Forward");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		assertFalse(selenium.isElementPresent("link=My Accural Rate"));
		assertFalse(selenium.isElementPresent("link=My retirement"));
		assertFalse(selenium.isElementPresent("link=Redundacy"));
		assertFalse(selenium.isElementPresent("link=My benefits"));
		System.out.println("BritoilActive-Mydtails-PASSED");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
