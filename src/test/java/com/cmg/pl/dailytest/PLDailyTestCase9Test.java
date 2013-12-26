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
import com.thoughtworks.selenium.SeleniumException;

public class PLDailyTestCase9Test {
	private Selenium selenium;
	int retried = 0;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://pensionline.bp.com/content/pl";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		TakeScreenShot.init(driver);
	}

	@Test
	public void testPLDailyTestCase9() throws Exception {
		// Begin to load #9 member BPF-0122398(active member)!
		System.out.println("Case #9: Begin to load #9 member BPF-0122398(active member)!");
		try {
			selenium.open("/content/pl");
			selenium.click("link=Login");
			selenium.waitForPageToLoad("30000");
			selenium.type("id=_request_username", "superuser");
			selenium.type("id=_request_password", "P3nsions");
			selenium.click("id=doauth");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(2000);
			selenium.select("id=bgroup", "label=BPF");
			selenium.type("id=crefno", "0122398");
			selenium.click("id=doauth");
			Thread.sleep(2000);
			selenium.click("link=My details");
			selenium.waitForPageToLoad("30000");
			// Ensure this member only has 'This is me' and 'My benefits' under 'My details' left menu
			Thread.sleep(3000);
			assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'This is me')]"));
			assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My  Benefits')]"));
			assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Annual Allowance')]"));
			assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Accrual Rate')]"));
			assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Carry Forward')]"));
			assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My benefits')]"));
			assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My retirement')]"));
			assertTrue(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'Redundancy')]"));
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
			assertTrue(selenium.isElementPresent("//table[@id='member_id' and @class='datatable']/tbody/tr[2]/td[1][@class='member_refno']/strong[contains(text(),'0122398')]"));
			// May take a snapshot here
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
			// Access 'My retirement' page
			selenium.click("link=My retirement");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(15000);
			// Ensure that the page is loaded normally: there should be not any 'null' value or java tags started with '[['
			assertFalse(selenium.isTextPresent("null"));
			assertFalse(selenium.isTextPresent("Null"));
			assertFalse(selenium.isTextPresent("NULL"));
			assertFalse(selenium.isTextPresent("[["));
			assertFalse(selenium.isTextPresent("]]"));
			// Model some values in Retirement page...
			selenium.click("link=Retirement age");
			selenium.type("//input[@id='input_co_nra' and @class='slider_value']", "65");
			Thread.sleep(2000);
			selenium.click("//div[@id='age_panel' and @class='controlable_panel']/form/div[@class='slider_panel']/span[@class='goButton']");
			Thread.sleep(5000);
			assertFalse(selenium.isTextPresent("null"));
			assertFalse(selenium.isTextPresent("Null"));
			assertFalse(selenium.isTextPresent("NULL"));
			assertFalse(selenium.isTextPresent("[["));
			assertFalse(selenium.isTextPresent("]]"));
			// Model Contributory options
			selenium.click("link=Contributory options");
			selenium.select("id=input_co_option", "label=2:54");
			Thread.sleep(2000);
			selenium.click("//div[@id='contrib_option_panel' and @class='controlable_panel']/div[@class='slider_panel']/input[@class='goButton']");
			Thread.sleep(5000);
			assertFalse(selenium.isTextPresent("null"));
			assertFalse(selenium.isTextPresent("Null"));
			assertFalse(selenium.isTextPresent("NULL"));
			assertFalse(selenium.isTextPresent("[["));
			assertFalse(selenium.isTextPresent("]]"));
			// Model Cash lump sum
			selenium.click("link=Cash lump sum");
			selenium.type("//input[@id='input_co_cash' and @class='slider_value']", "152000");
			Thread.sleep(2000);
			selenium.click("//div[@id='cash_panel' and @class='controlable_panel']/div[@class='slider_panel']/input[2][@class='goButton']");
			Thread.sleep(5000);
			assertFalse(selenium.isTextPresent("null"));
			assertFalse(selenium.isTextPresent("Null"));
			assertFalse(selenium.isTextPresent("NULL"));
			assertFalse(selenium.isTextPresent("[["));
			assertFalse(selenium.isTextPresent("]]"));
			// May take a snapshot here
			// Access 'Redundancy' page
			selenium.click("link=Redundancy");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(5000);
			selenium.click("link=Redundancy date");
			selenium.type("//input[@id='input_co_nra' and @class='slider_,']", "20 November 2014");
			selenium.click("//div[@id='date_panel' and @class='controlable_panel']/form/div[@class='slider_panel']/input[2][@class='goButton']");
			Thread.sleep(5000);
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
			assertFalse(selenium.isElementPresent("//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Projection')]"));
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
			Thread.sleep(10000);
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
			Thread.sleep(10000);
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
			Thread.sleep(10000);
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
			// Try to model an accrual rate ...
			selenium.click("id=accrual_select");
			selenium.select("id=accrual_select", "label=54th");
			selenium.click("//div[@id='accrual_modelling_balloon' and @class='aa_popup_show']/div[2]/div/div/p/input[@class='goButton']");
			Thread.sleep(10000);
			assertFalse(selenium.isTextPresent("null"));
			assertFalse(selenium.isTextPresent("Null"));
			assertFalse(selenium.isTextPresent("NULL"));
			assertFalse(selenium.isTextPresent("[["));
			assertFalse(selenium.isTextPresent("]]"));
			assertTrue(selenium.isElementPresent("//div[@id='modelled_accrual_flag']"));
			// Check Salary Change pop-up...
			selenium.click("id=salary_plus_img");
			Thread.sleep(5000);
			assertTrue(selenium.isElementPresent("//div[@id='salary_modelling_balloon' and @class='aa_popup_show']"));
			selenium.type("//input[@id='salary_select' and @class='slider_value']", "90000");
			selenium.click("//div[@id='salary_modelling_balloon' and @class='aa_popup_show']/div[2]/div/div/table/tbody/tr[2]/td/div/input[2][@class='goButton']");
			Thread.sleep(10000);
			assertFalse(selenium.isTextPresent("null"));
			assertFalse(selenium.isTextPresent("Null"));
			assertFalse(selenium.isTextPresent("NULL"));
			assertFalse(selenium.isTextPresent("[["));
			assertFalse(selenium.isTextPresent("]]"));
			assertTrue(selenium.isElementPresent("//div[@id='modelled_salary_flag']"));
			// Model cash lump sum
			selenium.click("id=coins");
			Thread.sleep(10000);
			assertTrue(selenium.isElementPresent("//div[@id='coin_info']/b"));
			assertFalse(selenium.isElementPresent("//div[@id='coin_info']/b[contains(text(),'£0')]"));
			// Check the whole page again...
			assertFalse(selenium.isTextPresent("null"));
			assertFalse(selenium.isTextPresent("Null"));
			assertFalse(selenium.isTextPresent("NULL"));
			assertFalse(selenium.isTextPresent("[["));
			assertFalse(selenium.isTextPresent("]]"));
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
			assertTrue(selenium.isElementPresent("//div[@id='modelled_accrual_flag']"));
			assertTrue(selenium.isElementPresent("//div[@id='modelled_salary_flag']"));
			// Reset modelling
			selenium.click("//div[@id='journey_container']/div/img[1]");
			Thread.sleep(10000);
			// Check the whole page again
			assertFalse(selenium.isTextPresent("null"));
			assertFalse(selenium.isTextPresent("Null"));
			assertFalse(selenium.isTextPresent("NULL"));
			assertFalse(selenium.isTextPresent("[["));
			assertFalse(selenium.isTextPresent("]]"));
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
			assertFalse(selenium.isElementPresent("//div[@id='modelled_accrual_flag']"));
			assertFalse(selenium.isElementPresent("//div[@id='modelled_salary_flag']"));
			assertTrue(selenium.isElementPresent("//div[@id='coin_info']/b[contains(text(),'£0')]"));
			assertTrue(selenium.isElementPresent("//div[@id='info1'] /b[contains(text(),'65th')]"));
			// Finish
			System.out.println("Case #9: Loading #9 member BPF-0122398(active member) PASS!");
			// ----------------------------------------
			// May take a snapshot here
			TakeScreenShot.takeScreenshoot();
		} catch(SeleniumException se) {
			retried++;
			System.out.println("retried case9:" + retried);
			System.out.println(se.getMessage());
			if(retried < 5) {
				testPLDailyTestCase9();
			} else {
				System.out.println("Case #9: Loading #9 member BPF-0122398(active member) FAILURE!");
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
