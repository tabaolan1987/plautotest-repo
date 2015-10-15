package com.cmg.pl.dailytest;



import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.c_mg.pl.selenium.PLAUTOTEST.ParameterMap;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.MyDetailCheck;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.MyDetailPage;

public class LoadMember01_Walled {
	
	private static WebDriver driver;

	@Parameters({ "browser"})
	@BeforeMethod
	public void beforeMethod(String browser) 
	{
		System.out.println("come to set driver manager 0 : " + browser);
		driver = DriverUtil.getInstance(browser);
		Reporter.log("setup beforemethod");
		TakeScreenShot.init(driver);
	}
	
	@Test(timeOut = 1200000)
	public void LoadMember01Walled() {
			LoginPage.LoadPage(driver);
			Authenticate.Login(driver, ParameterMap.getValue("superusername"), ParameterMap.getValue("superuserpass"));
			SuperUser.loadMember(driver, Constant.NORMAL_WAITING_TIME, ParameterMap.getValue("group"), ParameterMap.getValue("refno"));
			Reporter.log("Superuser load memeber : " + ParameterMap.getValue("refno"));
			MyDetailPage.loadPage(driver);
			Reporter.log(" Then Access to My Detail Page");
			MyDetailCheck mdCheck = new MyDetailCheck();
			mdCheck.checkLinkInVisible(driver, ParameterMap.getValue("invisibleLinkUnderMyDetails"));
			Authenticate.LogOut(driver, Constant.SMALL_WAITING_TIME);
			Reporter.log("Finally Logout");
			System.out.println("------------------------------------------------------------------------------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
