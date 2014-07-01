package com.cmg.pl.action;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.InputReportParamPage;

public class ProduceReportWithInputParam {
	public static String DOWNLOAD_REPORT_BTT_ID = "doauth";
	public static String TITLE_DOWNLOAD_REPORT_PAGE = "run_report_complete";
	public static void ProduceReportWithDefaultParam (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(InputReportParamPage.RUN_BTT_ID)));
		
		InputReportParamPage.RunButton(driver).click();
		
		PageLoading.waitForNewTab(driver, 60);
		
		String tabID = PageLoading.getTabIdByTitle(driver, TITLE_DOWNLOAD_REPORT_PAGE);
		
		driver.switchTo().window(tabID);
		
		driver.findElement(By.id(DOWNLOAD_REPORT_BTT_ID)).click();
	}
}
