package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckMyAnnualAllowancePage {
	
	private static String LINK_TEXT_AA_STATEMENT = "My AA Statement";
	
	private static String LINK_TEXT_AA_PENSION_SAVINGS = "AA Pension savings";
	
	private static String LINK_TEXT_MY_AA_PROJECTION = "My AA Projection";
	
	public static boolean checkAAStatementLink(WebDriver driver, int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT_AA_STATEMENT)));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static boolean checkAAPensionSavings(WebDriver driver, int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT_AA_PENSION_SAVINGS)));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static boolean checkAAProjection(WebDriver driver, int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT_MY_AA_PROJECTION)));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
