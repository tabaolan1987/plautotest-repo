package com.cmg.pl.action;



import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.InputReportParamPage;

public class ProduceReportWithInputParam {
	public static String DOWNLOAD_REPORT_BTT_ID = "doauth";
	
	public static String XPATH = "//div[@id='content']/h1";
	
	public static String H1 = "Report generation complete";
	
	public static String TITLE_DOWNLOAD_REPORT_PAGE = "run_report_complete";
	
	public static boolean ProduceReportWithDefaultParam (WebDriver driver) {
		boolean result = false;
		try {
			Set<String> handles = driver.getWindowHandles();
			 String firstWinHandle = driver.getWindowHandle();
			 handles.remove(firstWinHandle);
			 String winHandle=(String) handles.iterator().next();
			 if (winHandle!=firstWinHandle){
			 String secondWinHandle=winHandle;
			 System.out.println("swith to second" + secondWinHandle);
			 driver.switchTo().window(secondWinHandle);
			 System.out.println("title second" + driver.getTitle());
			 }
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleIs(TITLE_DOWNLOAD_REPORT_PAGE));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(DOWNLOAD_REPORT_BTT_ID)));
			//driver.findElement(By.id(DOWNLOAD_REPORT_BTT_ID)).click();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
