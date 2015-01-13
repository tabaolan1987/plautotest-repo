package com.cmg.pl.action;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	public void checkLinkVisible(WebDriver driver, String allLinks){
		ArrayList<String> list = getLinks(allLinks);
		for(String link : list){
			if(link.equalsIgnoreCase(LINK_TEXT_THIS_IS_ME)){
				System.out.println("check link this is me");
				Assert.assertTrue(checkThisIsMeLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_RETIREMENT)){
				System.out.println("check link my retirement");
				Assert.assertTrue(checkMyRetirementLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_CARRY_FORWARD)){
				System.out.println("check link my carry forward");
				Assert.assertTrue(checkMyCarryForward(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_ANNUAL_ALLOWANCE)){
				System.out.println("check link my annual allowance");
				Assert.assertTrue(checkMyAnnualAllowance(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_SCHEME_PAYS)){
				System.out.println("check link scheme pays");
				Assert.assertTrue(checkSchemePays(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_LIFETIME)){
				System.out.println("check link my lifetime allowance");
				Assert.assertTrue(checkMyLifeTime(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_REDUNDACY)){
				System.out.println("check link redundancy");
				Assert.assertTrue(checkRedundacyLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase("My Benefits")){
				System.out.println("check link my benefits");
				Assert.assertTrue(checkMyBenefitsLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase("PaySlips")){
				System.out.println("check link payslips");
				Assert.assertTrue(checkPaySlips(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase("my accrual rate")){
				System.out.println("check link my accurual rate");
				Assert.assertTrue(checkMyAccurateLink(driver, Constant.SMALL_WAITING_TIME));
			}
		}
	}
	
	public void checkLinkInVisible(WebDriver driver, String allLinks){
		ArrayList<String> list = getLinks(allLinks);
		for(String link : list){
			if(link.equalsIgnoreCase(LINK_TEXT_THIS_IS_ME)){
				System.out.println("check link this is me");
				Assert.assertFalse(checkThisIsMeLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_RETIREMENT)){
				System.out.println("check link my retirement");
				Assert.assertFalse(checkMyRetirementLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_CARRY_FORWARD)){
				System.out.println("check link my carry forward");
				Assert.assertFalse(checkMyCarryForward(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_ANNUAL_ALLOWANCE)){
				System.out.println("check link my annual allowance");
				Assert.assertFalse(checkMyAnnualAllowance(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_SCHEME_PAYS)){
				System.out.println("check link scheme pays");
				Assert.assertFalse(checkSchemePays(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_MY_LIFETIME)){
				System.out.println("check link my lifetime allowance");
				Assert.assertFalse(checkMyLifeTime(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase(LINK_TEXT_REDUNDACY)){
				System.out.println("check link redundancy");
				Assert.assertFalse(checkRedundacyLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase("My Benefits")){
				System.out.println("check link my benefits");
				Assert.assertFalse(checkMyBenefitsLink(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase("PaySlips")){
				System.out.println("check link payslips");
				Assert.assertFalse(checkPaySlips(driver, Constant.SMALL_WAITING_TIME));
			}else if(link.equalsIgnoreCase("my accrual rate")){
				System.out.println("check link my accurual rate");
				Assert.assertFalse(checkMyAccurateLink(driver, Constant.SMALL_WAITING_TIME));
			}
		}
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
