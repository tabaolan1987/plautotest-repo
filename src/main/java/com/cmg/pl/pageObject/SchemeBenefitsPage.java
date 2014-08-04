package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.cmg.pl.action.PageLoading;

public class SchemeBenefitsPage {
	
	private static String URL = Constant.URL +  "content/pl/mydetails/benefit_statement_ac/scheme_pension/";
	
	public static String ID_TABLE_PERSONAL_DETAILS = "member_id";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.waitForImageVisible(driver, 20);
		PageLoading.waitForImageInvisible(driver, 30);
		Assert.assertFalse(PageLoading.checkDataError(driver));
		System.out.println("Load page : " + URL);
		return driver;
	}
	
	public static WebElement tablePersonalDetails(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TABLE_PERSONAL_DETAILS));
		return el;
	}
	
	
	
	
}
