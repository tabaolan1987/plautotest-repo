package com.cmg.pl.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.SchemeBenefitsPage;

public class CheckSchemeBenefitsPage {
	
	
	private static String XPATH_TD_CONTAINT_NINO = "//table[@id='member_id' and @class='datatable']/tbody/tr[2]/td[2]";
	
	public static boolean checkTablePersonalDetailsExisted(WebDriver driver , int timeout){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SchemeBenefitsPage.ID_TABLE_PERSONAL_DETAILS)));
			if(el.isDisplayed()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkMemberRefNumberExisted(WebDriver driver , String refNumber){
		WebElement table = SchemeBenefitsPage.tablePersonalDetails(driver);
		boolean check = false;
		List<WebElement> strongTags = table.findElements(By.tagName("strong"));
		for(WebElement str : strongTags){
			if(str.getText().equalsIgnoreCase(refNumber)){
				check = true;
			}
		}
		return check;
	}
	
	public static boolean checkNinoNumberExisted(WebDriver driver){
		WebElement tdContain = driver.findElement(By.xpath(XPATH_TD_CONTAINT_NINO));
		WebElement strongTag = tdContain.findElement(By.tagName("strong"));
		if(strongTag.getText()!= null && strongTag.getText()!=""){
			return true;
		}
		return false;
	}
	
}
