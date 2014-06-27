package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;

public class ReportingToolPage {
	private static String URL = Constant.URL + "content/pl/reporting/";
	
	public static String CHECK_CONNECTION_REPORT_GROUP_TEXT = "Checking connection to all data sources";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		return driver;
	}
	
	public static WebElement LinkCheckingConnectionReportGroup(WebDriver driver){
		WebElement el = driver.findElement(By.linkText(CHECK_CONNECTION_REPORT_GROUP_TEXT));
		return el;
	}
}
