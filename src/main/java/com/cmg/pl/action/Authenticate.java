package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.LogoutPage;

public class Authenticate {
	
	public static void Login(WebDriver driver , String username , String password){
		LoginPage.txtUsername(driver).sendKeys(username);
		LoginPage.txtPassword(driver).sendKeys(password);
		LoginPage.bttGo(driver).click();
		System.out.println("click button login");
	}
	
	public static void LogOut(WebDriver driver, int timeout){
		LogoutPage.loadPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LogoutPage.XPAHT_BTT_LOGOUT)));
		
		LogoutPage.BttLogout(driver).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Logout")));
		
		System.out.println("log out");
		
	}
	
	
}
