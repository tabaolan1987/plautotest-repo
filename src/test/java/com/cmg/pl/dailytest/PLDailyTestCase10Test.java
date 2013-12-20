package com.cmg.pl.dailytest;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.thoughtworks.selenium.Selenium;

public class PLDailyTestCase10Test {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://pensionline.bp.com/content/pl";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		TakeScreenShot.init(driver);
	}

	@Test
	public void testPLDailyTestCase10() throws Exception {
		// Begin to check report "Checking connection to all data source" !
		System.out.println("Begin to load #9 member BPF-0122398(active member)!");
		selenium.open("/content/pl");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_request_username", "auto_daily_checker");
		selenium.type("id=_request_password", "P3nsions");
		selenium.click("id=doauth");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.click("link=Reporting Tool");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		assertTrue(selenium.isElementPresent("//div[@id='content']/div[@class='ws_report_list']/div[@class='ws_report']/div[2][@class='ws_report_text']/h2//a[contains(text(),'Checking connection to all data source')]"));
		selenium.click("link=Checking connection to all data source");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=_add_report");
		Thread.sleep(2000);
		selenium.click("id=_run_report_confirm");
		// Check if the report is generated successfully...
		Thread.sleep(60000);
		selenium.selectWindow("run_report_complete");
		assertTrue(selenium.isElementPresent("//div[@id='content']/h1[contains(text(),'Report generation completed')]"));
		// May take a snapshot here
		// Finish
		TakeScreenShot.takeScreenshoot();
		System.out.println("Generate report \"Checking connection to all data source\" successfully!");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
