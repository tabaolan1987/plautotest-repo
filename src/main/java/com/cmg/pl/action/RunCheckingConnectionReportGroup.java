package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.AccessReportsPage;
import com.cmg.pl.pageObject.IndexSuperUserPage;
import com.cmg.pl.pageObject.ReportingToolPage;

public class RunCheckingConnectionReportGroup {
	public static String TITLE_ACCESS_REPORTS = "Access reports: Checking connection to all data sources";

	public static void runReportGroupCheckingConnection (WebDriver driver) {
		ReportingToolPage.LinkCheckingConnectionReportGroup(driver).click();
		PageLoading.waitForTitle(TITLE_ACCESS_REPORTS, driver, 20);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(AccessReportsPage.RUN_BTT_ID)));
		
		AccessReportsPage.RunButton(driver).click();
		
	}
}
