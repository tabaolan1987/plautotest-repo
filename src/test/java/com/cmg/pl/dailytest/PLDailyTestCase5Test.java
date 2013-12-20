package com.cmg.pl.dailytest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.thoughtworks.selenium.Selenium;

public class PLDailyTestCase5Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://pensionline.bp.com/content/pl";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		TakeScreenShot.init(driver);
	}

	@Test
	public void testPLDailyTestCase5() throws Exception {
		// Begin to load #5 member BPF-0100027(Pensioner)!
		System.out.println("Begin to load #5 member BPF-0100027(Pensioner)!");
		selenium.open("/content/pl");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "superuser");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		selenium.select("id=bgroup", "label=BPF");
		selenium.type("id=crefno", "0100027");
		selenium.click("id=doauth");
		Thread.sleep(2000);
		selenium.click("link=My details");
		selenium.waitForPageToLoad("30000");
		// Ensure this member only has 'This is me' and 'My benefits' under 'My details' left menu
		Thread.sleep(3000);
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'This is me')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My benefits')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Benefits')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My retirement')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Redundancy')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Annual Allowance')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Accrual Rate')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Carry Forward')]"));
		// Access 'This is me' page
		selenium.click("link=This is me");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(15000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// May take a snapshot here
		// Access 'My benefits' page
		selenium.click("link=My benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(300000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		assertTrue(selenium.isElementPresent("//span[@id='f_Refno_01'][contains(text(),'0100027')]"));
		assertTrue(selenium.isElementPresent("//input[@id='PreviousTaxYear' and @class='goButton']"));
		assertTrue(selenium.isElementPresent("//table[@id='tblFiscalyears' and @class='datatable']"));
		// May take a snapshot here
		TakeScreenShot.takeScreenshoot();
		// Finish
		System.out.println("Loading #5 member BPF-0100027(Pensioner) PASS!");
		// ----------------------------------------
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
