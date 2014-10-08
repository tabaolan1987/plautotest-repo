package com.cmg.pl.dailytest.Cucumber.Runner;

import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.CheckAccessReportsPage;
import com.cmg.pl.action.ProduceReportWithInputParam;
import com.cmg.pl.action.RunCheckingConnectionReportGroup;

import cucumber.api.java.en.Then;

public class ReportDefine {

	@Then("^I check all report$")
	public void i_check_all_report() {
		RunCheckingConnectionReportGroup
				.runReportGroupCheckingConnection(DriverUtil.driverCurrent);
		Assert.assertTrue(CheckAccessReportsPage.CheckReportSections(DriverUtil.driverCurrent));
		CheckAccessReportsPage.CheckSelectAllReports(DriverUtil.driverCurrent);
	}

	@Then("^I run the report$")
	public void i_run_the_report() {
		CheckAccessReportsPage.RunSelectedReports(DriverUtil.driverCurrent);
	}

	@Then("^I check successful report page is shown$")
	public void i_check_successful_report_page_is_shown() throws InterruptedException {
		Thread.sleep(2000);
		ProduceReportWithInputParam.ProduceReportWithDefaultParam(DriverUtil.driverCurrent);
	}

}
