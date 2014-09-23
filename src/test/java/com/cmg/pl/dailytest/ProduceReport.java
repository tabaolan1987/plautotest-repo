package com.cmg.pl.dailytest;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.CheckAccessReportsPage;
import com.cmg.pl.action.ProduceReportWithInputParam;
import com.cmg.pl.action.RunCheckingConnectionReportGroup;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.ReportingToolPage;

public class ProduceReport {

	private static String report_runner_username;
	private static String report_runner_password;
	private static WebDriver driver;

	@Parameters({ "browser", "report_runner_name", "report_runner_pass" })
	@BeforeMethod
	public void beforeMethod(String browser, String report_runner_name,
			String report_runner_pass) {
		driver = DriverUtil.getInstance(browser);
		TakeScreenShot.init(driver);
		report_runner_username = report_runner_name;
		report_runner_password = report_runner_pass;

	}

	@Test(timeOut = 600000)
	public void dailytest() throws InterruptedException {
			LoginPage.LoadPage(driver);
			Authenticate.Login(driver, report_runner_username,
					report_runner_password);
			ReportingToolPage.loadPage(driver);
			RunCheckingConnectionReportGroup
					.runReportGroupCheckingConnection(driver);
			Assert.assertTrue(CheckAccessReportsPage
					.CheckReportSections(driver));
			CheckAccessReportsPage.CheckSelectAllReports(driver);
			// Thread.sleep(10000);
			CheckAccessReportsPage.RunSelectedReports(driver);
			Thread.sleep(2000);
			ProduceReportWithInputParam.ProduceReportWithDefaultParam(driver);

			// logout
			Authenticate.LogOut(driver, 10);

	}


	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
