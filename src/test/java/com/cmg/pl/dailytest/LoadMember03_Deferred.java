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
import com.cmg.pl.action.CheckThisIsMePage;
import com.cmg.pl.action.MyDetailCheck;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.MyDetailPage;
import com.cmg.pl.pageObject.ThisIsMePage;

public class LoadMember03_Deferred {
	private static WebDriver driver;

	private static String usernameLogin;

	private static String usernamePass;

	private static String refno;

	private static String group = "BPF";

	@Parameters({ "browser", "super_user_name", "super_user_pass" ,"deferred_ref_no02"})
	@BeforeMethod
	public void beforeMethod(String browser, String super_user_name, String super_user_pass, String deferred_ref_no02) 
	{
		driver = DriverUtil.getInstance(browser);
		TakeScreenShot.init(driver);
		usernameLogin = super_user_name;
		usernamePass = super_user_pass;
		refno = deferred_ref_no02;
		
	}
	
	@Test(timeOut = 1200000)
	public void LoadMember03Deferred() {
			LoginPage.LoadPage(driver);
			Authenticate.Login(driver, usernameLogin, usernamePass);
			SuperUser.loadMember(driver, Constant.NORMAL_WAITING_TIME, group, refno);
			Reporter.log("Superuser load member : " + refno);
			//check for links available under 'My details'
			MyDetailPage.loadPage(driver);
			Reporter.log("Then access to My detail page");
			Assert.assertTrue(MyDetailCheck.checkThisIsMeLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertTrue(MyDetailCheck.checkSchemePays(driver, Constant.SMALL_WAITING_TIME));
			Reporter.log("Then check : This is Me and Scheme Pays will show");
			//check for links unavailable under 'My details'	
			Assert.assertFalse(MyDetailCheck.checkPaySlips(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyBenefitsLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyAnnualAllowance(driver, Constant.SMALL_WAITING_TIME));
			Assert.assertFalse(MyDetailCheck.checkMyCarryForward(driver, Constant.SMALL_WAITING_TIME));
			Reporter.log("Then check : Payslips , My Life time , My Accurate , My Benefits,"
					+ " My Retirement , Redundacy, My Annual Allowance, My Carry Forward will not show");
			//check 'This is me' page
			ThisIsMePage.loadPage(driver);
			Reporter.log("Then access to This is Me");
			CheckThisIsMePage.checkPersonalDetailTableExisted(driver, Constant.SMALL_WAITING_TIME);
			Reporter.log("Then check the personal detail table will show");
			Assert.assertTrue(CheckThisIsMePage.checkMembershipExisted(driver, refno));
			Reporter.log("Then check the refno : " + refno + " will existed in this table");
			//logout
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
