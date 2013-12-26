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
import com.thoughtworks.selenium.SeleniumException;

public class PLDailyTestCase10Test {
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
	public void testPLDailyTestCase10() throws Exception {
		// Begin to check report "Checking connection to all data source" !
		System.out.println("Case #10: Begin check connection to all data sources!");
		try {
			selenium.open("/content/pl");
			selenium.click("link=Login");
			selenium.waitForPageToLoad("30000");
			selenium.type("id=_request_username", "auto_daily_checker");
			selenium.type("id=_request_password", "P3nsions");
			selenium.click("id=doauth");
			selenium.waitForPageToLoad("60000");
			Thread.sleep(5000);
			selenium.click("link=Reporting Tool");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(2000);
			assertTrue(selenium.isElementPresent("//div[@id='content']/div[@class='ws_report_list']/div[@class='ws_report']/div[2][@class='ws_report_text']/h2//a[contains(text(),'Checking connection to all data sources')]"));
			selenium.click("link=Checking connection to all data sources");
			selenium.waitForPageToLoad("30000");
			selenium.click("id=_add_report");
			Thread.sleep(2000);
			selenium.click("id=_run_report_confirm");
			// Check if the report is generated successfully...
			Thread.sleep(20000);
			selenium.selectWindow("Report_Complete");
			assertTrue(selenium.isElementPresent("//div[@id='content']/h1[contains(text(),'Report generation completed')]"));
			System.out.println("Case #10 : Check connection to all data sources PASS!");
			// May take a snapshot here
			// Finish
			TakeScreenShot.takeScreenshoot();
		} catch(SeleniumException se) {
			retried++;
			System.out.println("retried case10:" + retried);
			System.out.println(se.getMessage());
			if(retried < 5) {
				testPLDailyTestCase10();
			} else {
				System.out.println("Case #10 : Check connection to all data sources FAILURE!");
			}
		}
		
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
