package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.IndexSuperUserPage;
import com.cmg.pl.pageObject.LoginPage;

public class SuperUser {
	
	private static String TITLE_AFTER_LOAD_MEMBER = "welcome to PensionLine";
	
	
	public static void Login(WebDriver driver , String username , String password){
		LoginPage.txtUsername(driver).sendKeys(username);
		LoginPage.txtPassword(driver).sendKeys(password);
		LoginPage.bttGo(driver).click();
	}
	
	public static void loadMember(WebDriver driver ,int timeout, String group , String refno){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(IndexSuperUserPage.ID_SELECT_BGROUP)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(IndexSuperUserPage.ID_TXT_REFNO)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(IndexSuperUserPage.ID_BTT_GO)));
		
		Select select = new Select(IndexSuperUserPage.SelectBgroup(driver));
		select.selectByValue(group);
		IndexSuperUserPage.TxtRefNo(driver).sendKeys(refno);
		IndexSuperUserPage.BttGo(driver).click();
		PageLoading.waitForTitle(TITLE_AFTER_LOAD_MEMBER, driver, 20);
	}
	
	
	
}
