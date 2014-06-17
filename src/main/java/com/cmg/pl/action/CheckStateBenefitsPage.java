package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.StateBenefitsPage;

public class CheckStateBenefitsPage {
	
	private static String XPATH_DATE_OF_BIRTH = "//table[@id='member_id' and @class='datatable']/tbody/tr[2]/td[1][@class='member_refno']/strong ";
	
	private static String XPATH_NINO_NUMBER = "//table[@id='member_id' and @class='datatable']/tbody/tr[2]/td[2][@class='member_nino']/strong";
	
	public static boolean checkTablePersonalDetailExisted(WebDriver driver, int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement el = wait.until(ExpectedConditions.visibilityOf(StateBenefitsPage.tablePersonalDetail(driver)));
			if(el.isDisplayed()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static boolean checkDateOfBirth(WebDriver driver){
		WebElement dob = driver.findElement(By.xpath(XPATH_DATE_OF_BIRTH));
		if(dob.getText()!=null && dob.getText()!=""){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean checkNinoNumber(WebDriver driver){
		WebElement number = driver.findElement(By.xpath(XPATH_NINO_NUMBER));
		if(number.getText()!=null && number.getText()!=""){
			return true;
		}else{
			return false;
		}
	}
}
