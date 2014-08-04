package com.cmg.pl.pageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.cmg.pl.action.PageLoading;

public class MyCarryForwardPage {
	
	private static String URL = Constant.URL + "content/pl/mydetails/carryfwd/";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.waitForImageVisible(driver, 20);
		PageLoading.waitForImageInvisible(driver, 20);
		Assert.assertFalse(PageLoading.checkDataError(driver));
		System.out.println("Load page : " + URL);
		return driver;
	}
}
