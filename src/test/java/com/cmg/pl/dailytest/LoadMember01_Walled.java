package com.cmg.pl.dailytest;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.MyDetailCheck;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.MyDetailPage;

public class LoadMember01_Walled {
	private static WebDriver driver;

	private static String usernameLogin;

	private static String usernamePass;

	private static String refno;

	private static String group = "BPF";

	@Parameters({ "browser", "super_user_name", "super_user_pass" ,"walled_ref_no01"})
	@BeforeMethod
	public void beforeMethod(String browser, String super_user_name, String super_user_pass, String walled_ref_no01) 
	{
		driver = DriverUtil.getInstance(browser);
		TakeScreenShot.init(driver);
		usernameLogin = super_user_name;
		usernamePass = super_user_pass;
		refno = walled_ref_no01;
		
	}
	
	@Test(timeOut = 600000)
	public void dailytest() {
			LoginPage.LoadPage(driver);
			Authenticate.Login(driver, usernameLogin, usernamePass);
			SuperUser.loadMember(driver, 30, group, refno);
			Reporter.log("Superuser load memeber : " + refno);
			
			//check for links unavailable under 'My details'
			MyDetailPage.loadPage(driver);
			//TakeScreenShot.takeScreenshoot();
			Reporter.log(" Then Access to My Detail Page");
			Assert.assertFalse(MyDetailCheck.checkThisIsMeLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkPaySlips(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkSchemePays(driver, 5));
			Reporter.log("Then check : This is Me, PaySlips , SchemePays showing");		
			Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyBenefitsLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyAnnualAllowance(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyCarryForward(driver, 5));
			Reporter.log("Then check : My Life Time , My Accurate, My Benefits, My Retirement , Redundacy, Annual Allowance, Carray Forward not show");
			//logout
			Authenticate.LogOut(driver, 10);
			Reporter.log("Finally Logout");
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
