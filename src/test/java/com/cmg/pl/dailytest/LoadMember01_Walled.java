package com.cmg.pl.dailytest;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
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
		System.out.println("setup beforemethod");
		TakeScreenShot.init(driver);
		usernameLogin = super_user_name;
		usernamePass = super_user_pass;
		refno = walled_ref_no01;
		
	}
	
	@Test(timeOut = 1200000)
	public void LoadMember01Walled() {
			try {
				System.out.println("load login page");
				LoginPage.LoadPage(driver);
			} catch (Exception e) {
				driver.close();
				LoginPage.LoadPage(driver);
			}
			Authenticate.Login(driver, usernameLogin, usernamePass);
			SuperUser.loadMember(driver, Constant.NORMAL_WAITING_TIME, group, refno);
			Reporter.log("Superuser load memeber : " + refno);
			
			//check for links unavailable under 'My details'
			MyDetailPage.loadPage(driver);
			Reporter.log(" Then Access to My Detail Page");
			Assert.assertFalse(MyDetailCheck.checkThisIsMeLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkPaySlips(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkSchemePays(driver, Constant.SMALL_WAITING_TIME));
			Reporter.log("Then check : This is Me, PaySlips , SchemePays showing");		
			Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyBenefitsLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyAnnualAllowance(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyCarryForward(driver, Constant.SMALL_WAITING_TIME));
			Reporter.log("Then check : My Life Time , My Accurate, My Benefits, My Retirement , Redundacy, Annual Allowance, Carray Forward not show");
			//logout
			Authenticate.LogOut(driver, Constant.SMALL_WAITING_TIME);
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
