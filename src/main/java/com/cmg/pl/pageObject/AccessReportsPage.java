package com.cmg.pl.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccessReportsPage {
	
	public static String RUN_BTT_ID = "_add_report";
	public static String CHECKBOX_XPATH = "//input[@type='checkbox']";
	public static String REPORT_TAG_NAME = "h2";
	
	public static WebElement RunButton(WebDriver driver) {
		WebElement el = driver.findElement(By.id(RUN_BTT_ID));
		return el;
	}
	
	public static List<WebElement> ReportSections(WebDriver driver){
		List<WebElement> els = driver.findElements(By.tagName(REPORT_TAG_NAME));
		return els;
	}
	
	public static List<WebElement> listCheckBox(WebDriver driver){
		List<WebElement> els = driver.findElements(By.xpath(CHECKBOX_XPATH));
		return els;
	}
}
