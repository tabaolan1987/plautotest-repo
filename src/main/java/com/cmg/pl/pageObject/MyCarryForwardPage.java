package com.cmg.pl.pageObject;

import org.openqa.selenium.WebDriver;

import com.cmg.pl.action.PageLoading;

public class MyCarryForwardPage {
	
	private static String URL = "https://pensionline.bp.com/content/pl/mydetails/carryfwd/";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.waitForImageVisible(driver, 20);
		PageLoading.waitForImageVisible(driver, 50);
		return driver;
	}
}
