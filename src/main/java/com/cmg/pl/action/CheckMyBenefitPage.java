package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckMyBenefitPage {
	
	private static String LINK_TEXT_SCHEME_BENEFITS= "Scheme benefits";
	
	private static String LINK_TEXT_STATE_BENEFITS = "State benefits";
	
	public static boolean checkLinkSchemeBenefits(WebDriver driver , int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText(LINK_TEXT_SCHEME_BENEFITS))));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkLinkStateBenefits(WebDriver driver , int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText(LINK_TEXT_STATE_BENEFITS))));
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
