package com.cmg.pl.action;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;

public class CheckMyAnnualAllowancePage {
	
	private static String LINK_TEXT_AA_STATEMENT = "My AA Statement";
	
	private static String LINK_TEXT_AA_PENSION_SAVINGS = "AA Pension savings";
	
	private static String LINK_TEXT_MY_AA_PROJECTION = "My AA Projection";
	
	
	
	
	public ArrayList<String> getLinks(String data){
		ArrayList<String> temp = new ArrayList<String>();
		if(data!=null && data.length() > 0){
			String[] links = data.split(",");
			for(String link : links){
				temp.add(link.trim());
			}
		}
		return temp;
	}
	
	
	public void checkLinkVisible(WebDriver driver, String links){
		ArrayList<String> list = getLinks(links);
		for(String link : list){
			if(link.equalsIgnoreCase(LINK_TEXT_AA_STATEMENT)){
				Assert.assertTrue(checkAAStatementLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_AA_PENSION_SAVINGS)){
				Assert.assertTrue(checkAAPensionSavings(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_AA_PROJECTION)){
				Assert.assertTrue(checkAAProjection(driver, Constant.SMALL_WAITING_TIME));
			}
		}
	}
	
	public void checkLinkInvisible(WebDriver driver, String links){
		ArrayList<String> list = getLinks(links);
		for(String link : list){
			if(link.equalsIgnoreCase(LINK_TEXT_AA_STATEMENT)){
				Assert.assertFalse(checkAAStatementLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_AA_PENSION_SAVINGS)){
				Assert.assertFalse(checkAAPensionSavings(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_AA_PROJECTION)){
				Assert.assertFalse(checkAAProjection(driver, Constant.SMALL_WAITING_TIME));
			}
		}
	}
	
	
	
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
