package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputReportParamPage {
	
	public static String RUN_BTT_ID = "_run_report_confirm";


	public static WebElement RunButton(WebDriver driver) {
		WebElement el = driver.findElement(By.id(RUN_BTT_ID));
		return el;
	}
	
	
}
