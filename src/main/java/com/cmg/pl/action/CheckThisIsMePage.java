package com.cmg.pl.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.ThisIsMePage;

public class CheckThisIsMePage {
	
	
	public static void checkPersonalDetailTableExisted(WebDriver driver , int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ThisIsMePage.ID_TABLE_PERSONAL)));
	}
	
	public static boolean checkMembershipExisted(WebDriver driver  , String refNumber){
		WebElement table = ThisIsMePage.tablePersonalDetail(driver);
		boolean checkExisted = false;
		List<WebElement> trs = table.findElements(By.tagName("tr"));
		for(WebElement tr : trs){
			List<WebElement> tds = tr.findElements(By.tagName("td"));
			for(WebElement td : tds){
				if(td.getText().equalsIgnoreCase(refNumber)){
					checkExisted =  true;
					break;
				}
			}
		}
		return checkExisted;
	}
	
}
