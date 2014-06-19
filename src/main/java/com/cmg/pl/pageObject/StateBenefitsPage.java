package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cmg.pl.action.PageLoading;

public class StateBenefitsPage {
	private static String URL = "https://pensionline.bp.com/content/pl/mydetails/benefit_statement_ac/state_pension.html";
	
	public static String ID_TABLE_PERSONAL_DETAIL = "member_id";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.waitForImageVisible(driver, 20);
		PageLoading.waitForImageInvisible(driver, 30);
		Assert.assertFalse(PageLoading.checkDataError(driver));
		return driver;
	}
	
	public static WebElement tablePersonalDetail(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TABLE_PERSONAL_DETAIL));
		return el;
	}
}
