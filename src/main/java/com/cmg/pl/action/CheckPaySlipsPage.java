package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.PaySlipsPage;

public class CheckPaySlipsPage {
	
	private static String XPATH_REFNO = "//span[@id='f_Refno_01']";
	
	private static String XPATH_NINO = "//span[@id='f_Nino_01'] ";
	
	public static boolean checkTablePersonalDetailExisted(WebDriver driver, int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(PaySlipsPage.tablePersonalDetail(driver)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkTablePaySlipsExisted(WebDriver driver, int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(PaySlipsPage.tablePaySlips(driver)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkBttPreviousExisted(WebDriver driver , int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(PaySlipsPage.bttPrevious(driver)));
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static boolean checkCurrentTaxYear(WebDriver driver){
		try {
			String tax01 = PaySlipsPage.taxYear01(driver).getText();
			String tax02 = PaySlipsPage.taxYear02(driver).getText();
			if(tax01!=null && tax02!=null && tax01.equals(tax02)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkRefno(WebDriver driver , String refno){
		try {
			String refTable = driver.findElement(By.xpath(XPATH_REFNO)).getText();
			if(refno.equalsIgnoreCase(refTable)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkNiNo(WebDriver driver){
		try {
			String ninoTbale = driver.findElement(By.xpath(XPATH_NINO)).getText();
			if(ninoTbale!=null && ninoTbale!=""){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
}
