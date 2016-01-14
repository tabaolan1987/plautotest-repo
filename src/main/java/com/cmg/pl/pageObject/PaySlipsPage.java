package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.cmg.pl.action.PageLoading;

public class PaySlipsPage {
	
	private static String URL = Constant.URL + "content/pl/mydetails/benefit_statement_pn.html";
	
	public static String ID_TABLE_PERSONAL_DETAIL = "member_id";
	
	public static String ID_TABLE_PAYSLIPS = "tblFiscalyears";
	
	public static String ID_BTT_PREVIOUS = "PreviousTaxYear";
	
	public static String ID_CURRENT_TAX_YEAR_1 = "f_CurrentTaxYear_01";
	
	public static String ID_CURRENT_TAX_YEAR_2 = "f_CurrentTaxYear_02";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.waitForImageVisible(driver, 20);
		PageLoading.waitForImageInvisible(driver, 400);
		Assert.assertFalse(PageLoading.checkDataError(driver));
		System.out.println("load page : "+ URL);
		return driver;
	}
	
	public static WebElement tablePersonalDetail(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TABLE_PERSONAL_DETAIL));
		return el;
	}
	
	public static WebElement tablePaySlips(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TABLE_PAYSLIPS));
		return el;
	}
	
	public static WebElement bttPrevious(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_BTT_PREVIOUS));
		return el;
	}
	
	public static WebElement taxYear01(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_CURRENT_TAX_YEAR_1));
		return el;
	}
	
	public static WebElement taxYear02(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_CURRENT_TAX_YEAR_2));
		return el;
	}
	
	
	
}
