package com.cmg.pl.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cmg.pl.pageObject.ThisIsMePage;

public class CheckThisIsMePage {
	
	
	public static void checkPersonalDetailTableExisted(WebDriver driver , int timeout){
		System.out.println("check personal detail table");
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ThisIsMePage.ID_TABLE_PERSONAL)));
		PageLoading.waitForElementExistedInDomVisible(ThisIsMePage.tablePersonalDetail(driver), timeout);
	}
	
	public static boolean checkMembershipExisted(WebDriver driver  , String refNumber){
		System.out.println("check membership existed");
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
