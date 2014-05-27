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

public class PLDailyTestCase14Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://plw1-int.bppensions.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPLDailyTestCase14() throws Exception {
		selenium.open("/content/pl/_logout_confirm.html");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "bcpensioner");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=pos");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=This is me");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1500);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("link=My benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(30000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("link=My Annual Allowance");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=My AA Projection");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(30000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isElementPresent("link=My retirement"));
		assertFalse(selenium.isElementPresent("link=My Benefits"));
		assertFalse(selenium.isElementPresent("link=Redundancy"));
		assertFalse(selenium.isElementPresent("link=My Accural Rate"));
		selenium.click("xpath=(//a[contains(text(),'My details')])[3]");
		selenium.waitForPageToLoad("30000");
		selenium.click("document.frmPosOfService.pos[1]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=This is me");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("link=My benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(30000);
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		assertTrue(selenium.isElementPresent("link=My Annual Allowance"));
		assertFalse(selenium.isElementPresent("link=My retirement"));
		assertFalse(selenium.isElementPresent("link=My Benefits"));
		assertFalse(selenium.isElementPresent("link=Redundancy"));
		assertFalse(selenium.isElementPresent("link=My Accural Rate"));
		System.out.println("BCPensioner-2periods-MyDetails-PASSED");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
