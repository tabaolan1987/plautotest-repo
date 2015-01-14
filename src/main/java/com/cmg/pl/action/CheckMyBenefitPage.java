package com.cmg.pl.action;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;

public class CheckMyBenefitPage {
	
	private static String LINK_TEXT_SCHEME_BENEFITS= "Scheme benefits";
	
	private static String LINK_TEXT_STATE_BENEFITS = "State benefits";
	
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
			if(link.equalsIgnoreCase(LINK_TEXT_SCHEME_BENEFITS)){
				Assert.assertTrue(checkLinkSchemeBenefits(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_STATE_BENEFITS)){
				Assert.assertTrue(checkLinkStateBenefits(driver, Constant.SMALL_WAITING_TIME));
			}
		}
	}
	
	public void checkLinkInvisible(WebDriver driver, String links){
		ArrayList<String> list = getLinks(links);
		for(String link : list){
			if(link.equalsIgnoreCase(LINK_TEXT_SCHEME_BENEFITS)){
				Assert.assertFalse(checkLinkSchemeBenefits(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_STATE_BENEFITS)){
				Assert.assertFalse(checkLinkStateBenefits(driver, Constant.SMALL_WAITING_TIME));
			}
		}
	}
	
	
	
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
