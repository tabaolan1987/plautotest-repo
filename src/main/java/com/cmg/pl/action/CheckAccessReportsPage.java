package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.AccessReportsPage;

import java.util.*;

public class CheckAccessReportsPage {

	public static String AQUILA_REPORT_TITLE = "Check Aquila Connection";
	public static String AVIARY_REPORT_TITLE = "Check connection to Aviary";
	public static String DATABASE_REPORT_TITLE = "Check connection to database ext (pensionline_ext)";
	public static String EXTRA_VIEW_REPORT_TITLE = "Check connection to Extra View";
	public static String OPENCMS_REPORT_TITLE = "Check connection to Opencms database";
	public static String WEBSTAT_REPORT_TITLE = "Check connection to webstat (pensionline_stat)";
	
	public static String INPUT_REPORT_PARAM_PAGE_TITLE = "Input report parameter values";
	
	
	
	public static boolean CheckReportSections (WebDriver driver) {
		int count = 0;
		List<WebElement> els = AccessReportsPage.ReportSections(driver);
		for(WebElement el : els){
			if(el.getText().equals(AQUILA_REPORT_TITLE)){
				count++;
			}else if(el.getText().equals(AVIARY_REPORT_TITLE)) {
				count++;
			} else if(el.getText().equals(DATABASE_REPORT_TITLE)) {
				count++;
			}
			else if(el.getText().equals(EXTRA_VIEW_REPORT_TITLE)) {
				count++;
			}
			else if(el.getText().equals(OPENCMS_REPORT_TITLE)) {
				count++;
			}
			else if(el.getText().equals(WEBSTAT_REPORT_TITLE)) {
				count++;
			}
		}
		if(count == 6){
			return true;
		}
		else {
			return false;
		}
	}
	
		
	public static void CheckSelectAllReports (WebDriver driver){
		
		List<WebElement> els = AccessReportsPage.listCheckBox(driver);
		for(WebElement el : els){
			if(!el.isSelected()){
				el.click();
			}
			
		}
	}
	
	public static void RunSelectedReports (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(AccessReportsPage.RUN_BTT_ID)));
		AccessReportsPage.RunButton(driver).click();
		PageLoading.waitForTitle(INPUT_REPORT_PARAM_PAGE_TITLE, driver, 20);
	}
}
