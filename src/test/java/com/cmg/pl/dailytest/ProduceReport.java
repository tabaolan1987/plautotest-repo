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
import com.c_mg.pl.selenium.PLAUTOTEST.ParameterMap;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.CheckAccessReportsPage;
import com.cmg.pl.action.ProduceReportWithInputParam;
import com.cmg.pl.action.RunCheckingConnectionReportGroup;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.ReportingToolPage;

public class ProduceReport {

	private static WebDriver driver;

	@Parameters({ "browser"})
	@BeforeMethod
	public void beforeMethod(String browser) {
		driver = DriverUtil.getInstance(browser);
		TakeScreenShot.init(driver);

	}

	@Test(timeOut = 1200000)
	public void dailytest_ProduceReport() throws InterruptedException {
			LoginPage.LoadPage(driver);
			Thread.sleep(3000);
			Authenticate.Login(driver, ParameterMap.getValue("reportusername"),
					ParameterMap.getValue("reportuserpass"));
			Thread.sleep(3000);
			Reporter.log("login with report runner : "  + ParameterMap.getValue("reportusername"));
			ReportingToolPage.loadPage(driver);
			Thread.sleep(3000);
			Reporter.log("Then access to Reporting Tool page");
			RunCheckingConnectionReportGroup.runReportGroupCheckingConnection(driver);
			Assert.assertTrue(CheckAccessReportsPage
					.CheckReportSections(driver),"There are no or missing some report sections");
			CheckAccessReportsPage.CheckSelectAllReports(driver);
			Reporter.log("Then check all report");
			// Thread.sleep(10000);
			CheckAccessReportsPage.RunSelectedReports(driver);
			Reporter.log("Then Run the report");
			Thread.sleep(5000);
			Assert.assertTrue(ProduceReportWithInputParam.ProduceReportWithDefaultParam(driver)
					,"Produce Report fail");
			Reporter.log("Then Check successful report page is shown");
			// logout
			Authenticate.LogOut(driver, Constant.SMALL_WAITING_TIME);
			Reporter.log("Finnaly logout");
			System.out.println("------------------------------------------------------------------------------");

	}


	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		try {
			//driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
