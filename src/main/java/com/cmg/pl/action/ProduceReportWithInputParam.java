package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cmg.pl.pageObject.InputReportParamPage;

public class ProduceReportWithInputParam {
	public static String report_complete_window_name = "Report generation completed";
	public static String DOWNLOAD_REPORT_BTT_ID = "doauth";
	
	public static void ProduceReportWithDefaultParam (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(InputReportParamPage.RUN_BTT_ID)));
		
		InputReportParamPage.RunButton(driver).click();
		
		Assert.assertTrue(PageLoading.waitForNewTab(driver, 60,report_complete_window_name));
		driver.switchTo().window(report_complete_window_name);
		driver.findElement(By.id(DOWNLOAD_REPORT_BTT_ID)).click();
	}
}
