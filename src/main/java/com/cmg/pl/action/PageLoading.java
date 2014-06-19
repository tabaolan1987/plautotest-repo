package com.cmg.pl.action;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageLoading {

	private static String XPATH_IMAGE_SPINNING = "//img[@alt='waiting']";
	
	private static String XPATH_ERROR_SPAN = "//span[contains(., '[[')]";
	
	public static void waitForTitle(String title , WebDriver driver , int timeout){
		int size = 0 ;
		try {
			while (!driver.getTitle().equalsIgnoreCase(title)) {
				Thread.sleep(1000);
				size++;
				if(size > timeout){
					break;
				}
			}
		} catch (Exception e) {
		}
		
	}
	
	public static void waitForImageVisible(WebDriver driver , int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(XPATH_IMAGE_SPINNING)));
	}
	
	
	public static void waitForImageInvisible(WebDriver driver,int timeout){
		try {
			int count = 0;
			List<WebElement> images = driver.findElements(By.xpath(XPATH_IMAGE_SPINNING));
			while(getAllElementVisiable(images) > 0){
				Thread.sleep(1000);
				count++;
				//System.out.println(count+ "-" + timeout);
				if(count > timeout){
					break;
				}
			}
		} catch (Exception e) {
			
		}
		
	}
	
	private static int getAllElementVisiable(List<WebElement> list){
		int size = 0; 
		for(WebElement e : list){
			try {
				if(e.isDisplayed()){
					size++;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return size;
	}
	
	
	public static void waitForElementExistedInDomVisible(WebElement el , int timeout){
		int count = 0 ;
		while(!el.isDisplayed()){
			try {
				count++;
				//System.out.println(count + "-" + timeout);
				Thread.sleep(1000);
				if(count > timeout){
					break;
				}
			} catch (Exception e) {
				
			}
		}
	}
	

	public static boolean checkDataError(WebDriver driver){
		boolean check = false;
		try {
			List<WebElement> els = driver.findElements(By.xpath(XPATH_ERROR_SPAN));
			if(els!=null && els.size() >0 ){
				for(WebElement el : els){
					if(el.isDisplayed()){
						check = true;
						break;
					}
				}
			}
		} catch (Exception e) {
		}
		
		Actions complex = new Actions(driver);
		return check;
	}
}
