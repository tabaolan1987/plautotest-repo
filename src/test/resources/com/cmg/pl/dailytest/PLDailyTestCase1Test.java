package com.cmg.pl.dailytest;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot.*;

public class PLDailyTestCase1Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://pensionline.bp.com/content/pl/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		init(driver);
	}

	@Test
	public void testPLDailyTestCase1() throws Exception {
		// Begin to load member BPF- 0103603(WALL'ed)!
		System.out.println("Begin to load member BPF- 0103603(WALL'ed)!");
		selenium.open("/content/pl");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "superuser");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(8000);
		selenium.type("id=crefno", "0103603");
		selenium.click("id=doauth");
		Thread.sleep(8000);
		selenium.click("link=My details");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(8000);
		// ensure that there is not any sub-menus under 'My details' available for this member
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'This is me')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My benefits')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Benefits')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My retirement')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Redundancy')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Annual Allowance')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Accrual Rate')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Scheme pays')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Carry Forward')]"));
		// May take a snapshot here
		takeScreenshoot();
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("//input[@class='goButton']"));
		Thread.sleep(3000);
		selenium.click("//input[@class='goButton']");
		// Finish
		System.out.println("Loading member BPF- 0103603(WALL'ed) PASS!");
		// ----------------------------------------
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
