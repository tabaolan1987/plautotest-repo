package com.cmg.pl.dailytest;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
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

	@Test(timeOut = 1200000)
	public void dailytest_ProduceReport() throws InterruptedException {
			LoginPage.LoadPage(driver);
			Thread.sleep(3000);
			Authenticate.Login(driver, report_runner_username,
					report_runner_password);
			Thread.sleep(3000);
			Reporter.log("login with report runner : "  + report_runner_username);
			ReportingToolPage.loadPage(driver);
			Thread.sleep(3000);
			Reporter.log("Then access to Reporting Tool page");
			RunCheckingConnectionReportGroup
					.runReportGroupCheckingConnection(driver);
			Assert.assertTrue(CheckAccessReportsPage
					.CheckReportSections(driver));
			CheckAccessReportsPage.CheckSelectAllReports(driver);
			Reporter.log("Then check all report");
			// Thread.sleep(10000);
			CheckAccessReportsPage.RunSelectedReports(driver);
			Reporter.log("Then Run the report");
			Thread.sleep(2000);
			Assert.assertTrue(ProduceReportWithInputParam.ProduceReportWithDefaultParam(driver));
			Reporter.log("Then Check successful report page is shown");
			// logout
			Authenticate.LogOut(driver, Constant.SMALL_WAITING_TIME);
			Reporter.log("Finnaly logout");
			System.out.println("------------------------------------------------------------------------------");

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
