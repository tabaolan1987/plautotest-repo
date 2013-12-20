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

public class PLDailyTestCase8Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://pensionline.bp.com/content/pl";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		TakeScreenShot.init(driver);
	}

	@Test
	public void testPLDailyTestCase8() throws Exception {
		// Begin to load #8 member BPF-0001794(Security lock-out in place)!
		System.out.println("Begin to load #8 member BPF-0001794(Security lock-out in place)!");
		selenium.open("/content/pl");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "superuser");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		selenium.select("id=bgroup", "label=BPF");
		selenium.type("id=crefno", "0001794");
		selenium.click("id=doauth");
		Thread.sleep(2000);
		selenium.click("link=My details");
		selenium.waitForPageToLoad("30000");
		// Ensure this member only has 'This is me' and 'My benefits' under 'My details' left menu
		Thread.sleep(3000);
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'This is me')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Benefits')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Annual Allowance')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Accrual Rate')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Carry Forward')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My benefits')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My retirement')]"));
		assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Redundancy')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Scheme pays')]"));
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
		// Access 'My Benefits' page
		selenium.click("link=My Benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Scheme benefits')]"));
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'State benefits')]"));
		selenium.click("link=Scheme benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		assertTrue(selenium.isElementPresent("//table[@id='member_id' and @class='datatable']/tbody/tr[2]/td[1][@class='member_refno']/strong[contains(text(),'0001794')]"));
		// May take  a snapshot here
		// Access State benefits
		selenium.click("link=State benefits");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// May take a snapshot here
		// Access 'My Annual Allowance' page
		selenium.click("link=My Annual Allowance");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		// Ensure that user cannot access 'My Projection' under 'My Annual Allowance'
		assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Projection')]"));
		// Access 'My Carry Forward' page
		selenium.click("link=My Carry Forward");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// May take a snapshot here
		// Access 'My Accrual Rate' page
		selenium.click("link=My Accrual Rate");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		// Check some objects' visibility 
		assertTrue(selenium.isElementPresent("//div[@id='info1']"));
		assertTrue(selenium.isElementPresent("//div[@id='info2']"));
		assertTrue(selenium.isElementPresent("//div[@id='coin_info']"));
		assertTrue(selenium.isElementPresent("//img[@id='flag1Img']"));
		assertTrue(selenium.isElementPresent("//div[@id='journey_container']/div/img[1]"));
		assertTrue(selenium.isElementPresent("//div[@id='road']"));
		assertTrue(selenium.isElementPresent("//div[@id='car']/img"));
		assertTrue(selenium.isElementPresent("//div[@id='coins']"));
		assertTrue(selenium.isElementPresent("//div[@id='pipyear_marker']"));
		assertTrue(selenium.isElementPresent("//div[@id='accrual_flag']"));
		assertTrue(selenium.isElementPresent("//div[@id='salary_flag']"));
		// Check the pop-ups
		// Check Pension at chosen Retirement Age pop-up...
		selenium.click("id=info_PensionInfo");
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("//div[@id='pension_info_balloon' and @class='aa_popup_show']"));
		// Check no invalid data displayed in the pop-up...
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("//div[@id='pension_info_balloon' and @class='aa_popup_show']/div[1]/img");
		// Check AA Taxable Amount pop-up...
		selenium.click("id=info_TaxInfo");
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("//div[@id='tax_info_balloon' and @class='aa_popup_show']"));
		// Check no invalid data displayed in the pop-up...
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("//div[@id='tax_info_balloon' and @class='aa_popup_show']/div[1]/img");
		// Check Cash Lump Sum pop-up...
		selenium.click("id=info_CashInfo");
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("//div[@id='cash_info_balloon' and @class='aa_popup_show']"));
		// Check no invalid data displayed in the pop-up...
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("//div[@id='cash_info_balloon' and @class='aa_popup_show']/div[1]/img");
		// Check Accrual Rate Change pop-up...
		selenium.click("id=accrual_plus_img");
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("//div[@id='accrual_modelling_balloon' and @class='aa_popup_show']"));
		// Check no invalid data displayed in the pop-up...
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("//div[@id='accrual_modelling_balloon' and @class='aa_popup_show']/div[1]/img");
		// Check Salary Change pop-up...
		selenium.click("id=salary_plus_img");
		Thread.sleep(5000);
		assertTrue(selenium.isElementPresent("//div[@id='salary_modelling_balloon' and @class='aa_popup_show']"));
		// Check no invalid data displayed in the pop-up...
		assertFalse(selenium.isTextPresent("null"));
		assertFalse(selenium.isTextPresent("Null"));
		assertFalse(selenium.isTextPresent("NULL"));
		assertFalse(selenium.isTextPresent("[["));
		assertFalse(selenium.isTextPresent("]]"));
		selenium.click("//div[@id='salary_modelling_balloon' and @class='aa_popup_show']/div[1]/img");
		// May take a snapshot here
		TakeScreenShot.takeScreenshoot();
		// Finish
		System.out.println("Loading #8 member BPF-0001794(Security lock-out in place) PASS!");
		// ----------------------------------------
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
