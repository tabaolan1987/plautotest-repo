package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cmg.pl.action.PageLoading;

public class ThisIsMePage {
	private static String URL = "https://pensionline.bp.com/content/pl/mydetails/this_is_me.html";
	
	public static String ID_TABLE_PERSONAL = "tim";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.waitForImageVisible(driver, 20);
		PageLoading.waitForImageInvisible(driver, 30);
		PageLoading.checkDataError(driver);
		return driver;
	}
	
	
	
	public static WebElement tablePersonalDetail(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TABLE_PERSONAL));
		return el;
	}
}
