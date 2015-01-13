package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.cmg.pl.pageObject.MyDetailPage;

public class MyDetailCheck {
	
	private static String LINK_TEXT_THIS_IS_ME = "This is me";
	
	private static String XPATH_LINK_MY_BENEFIT = "//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Benefits')]";
	
	private static String LINK_TEXT_MY_RETIREMENT = "My retirement";
	
	private static String LINK_TEXT_REDUNDACY = "Redundancy";
	
	private static String XPATH_ACCURATE_LINK = "//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My Accrual Rate')]";
	
	private static String XPATH_PAYSLIPS_LINK = "//div[@id='menu' and @class='lefty']/ul//a[contains(text(),'My benefits')]";
	
	private static String LINK_TEXT_MY_ANNUAL_ALLOWANCE = "My Annual Allowance";
	
	private static String LINK_TEXT_MY_CARRY_FORWARD = "My Carry Forward";
	
	private static String LINK_TEXT_SCHEME_PAYS = "Scheme pays";
	
	private static String LINK_TEXT_MY_LIFETIME = "My LifeTime Allowance";
	
	
	
	public boolean checkLinkVisible(WebDriver driver, String link){
		if(link.equalsIgnoreCase("this is me")){
			return checkThisIsMeLink(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my retirement")){
			return checkMyRetirementLink(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my carry forward")){
			return checkMyCarryForward(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my annual allowance")){
			return checkMyAnnualAllowance(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("scheme pays")){
			return checkSchemePays(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my lifeTime allowance")){
			return checkMyLifeTime(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("redundancy")){
			return checkRedundacyLink(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my benefits")){
			return checkMyBenefitsLink(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("payslips")){
			return checkPaySlips(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my accrual rate")){
			return checkMyAccurateLink(driver, Constant.SMALL_WAITING_TIME);
		}
		return false;
	}
	
	public boolean checkLinkInVisible(WebDriver driver, String link){
		if(link.equalsIgnoreCase("this is me")){
			return checkThisIsMeLink(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my retirement")){
			return checkMyRetirementLink(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my carry forward")){
			return checkMyCarryForward(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my annual allowance")){
			return checkMyAnnualAllowance(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("scheme pays")){
			return checkSchemePays(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my lifeTime allowance")){
			return checkMyLifeTime(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("redundancy")){
			return checkRedundacyLink(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my benefits")){
			return checkMyBenefitsLink(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("payslips")){
			return checkPaySlips(driver, Constant.SMALL_WAITING_TIME);
		}else if(link.equalsIgnoreCase("my accrual rate")){
			return checkMyAccurateLink(driver, Constant.SMALL_WAITING_TIME);
		}
		return true;
	}
	
	
	public static boolean checkThisIsMeLink(WebDriver driver , int timeout){
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.elementToBeClickable(MyDetailPage.subMenu(driver, By.linkText(LINK_TEXT_THIS_IS_ME))));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkMyBenefitsLink(WebDriver driver , int timeout){
		System.out.println("check my benefit link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.elementToBeClickable(MyDetailPage.subMenu(driver, By.xpath(XPATH_LINK_MY_BENEFIT))));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkMyRetirementLink(WebDriver driver , int timeout){
		System.out.println("check my retirement link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.elementToBeClickable(MyDetailPage.subMenu(driver, By.linkText(LINK_TEXT_MY_RETIREMENT))));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkRedundacyLink(WebDriver driver , int timeout){
		System.out.println("check redundacy link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.elementToBeClickable(MyDetailPage.subMenu(driver, By.linkText(LINK_TEXT_REDUNDACY))));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkMyAccurateLink(WebDriver driver , int timeout){
		System.out.println("check my accurate link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_ACCURATE_LINK)));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkPaySlips(WebDriver driver , int timeout){
		System.out.println("check paylips link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_PAYSLIPS_LINK)));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkMyAnnualAllowance(WebDriver driver , int timeout){
		System.out.println("check MyAnnualAllowance link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT_MY_ANNUAL_ALLOWANCE)));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkMyCarryForward(WebDriver driver, int timeout){
		System.out.println("check MyCarryForward link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT_MY_CARRY_FORWARD)));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkSchemePays(WebDriver driver , int timeout){
		System.out.println("check SchemePays link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT_SCHEME_PAYS)));
			if(el.isDisplayed() && el.isEnabled()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkMyLifeTime(WebDriver driver , int timeout){
		System.out.println("check MyLifeTime link");
		WebDriverWait wait = new WebDriverWait(driver , timeout);
		try {
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT_MY_LIFETIME)));
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
