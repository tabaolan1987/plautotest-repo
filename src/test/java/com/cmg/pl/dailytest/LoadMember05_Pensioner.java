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
import com.cmg.pl.action.CheckPaySlipsPage;
import com.cmg.pl.action.CheckThisIsMePage;
import com.cmg.pl.action.MyDetailCheck;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.MyDetailPage;
import com.cmg.pl.pageObject.PaySlipsPage;
import com.cmg.pl.pageObject.ThisIsMePage;

//check loading of a pensioner member 
public class LoadMember05_Pensioner {

	private static WebDriver driver;

	private static String usernameLogin;

	private static String usernamePass;

	private static String refno;

	private static String group = "BPF";

	@Parameters({ "browser", "super_user_name", "super_user_pass" ,"pensioner_ref_no02"})
	@BeforeMethod
	public void beforeMethod(String browser, String super_user_name, String super_user_pass, String pensioner_ref_no02) 
	{
		driver = DriverUtil.getInstance(browser);
		TakeScreenShot.init(driver);
		usernameLogin = super_user_name;
		usernamePass = super_user_pass;
		refno = pensioner_ref_no02;
		
	}
	
	
	@Test(timeOut = 1200000)
	public void dailytest() {
			LoginPage.LoadPage(driver);
			Authenticate.Login(driver, usernameLogin, usernamePass);
			TakeScreenShot.takeScreenshoot();
			SuperUser.loadMember(driver, 30, group, refno);
			Reporter.log("Superuser load member : " + refno);
			//check for links available under 'My details'
			MyDetailPage.loadPage(driver);
			Reporter.log("Then access to my detail page");
			Assert.assertTrue(MyDetailCheck.checkThisIsMeLink(driver, 5));
			Assert.assertTrue(MyDetailCheck.checkPaySlips(driver, 5));
			Assert.assertTrue(MyDetailCheck.checkSchemePays(driver, 5));
			Reporter.log("Then check : This is Me, Payslips, SchemePays will show under My Detail");
			//check for links unavailable under 'My details'
			Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyBenefitsLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyAnnualAllowance(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyCarryForward(driver, 5));
			Reporter.log("Then check : My Life time , My Accurate , My Benefits,"
					+ " My Retirement , Redundacy, My Annual Allowance, My Carry Forward will not show");
			//check 'This is me' page
			ThisIsMePage.loadPage(driver);
			Reporter.log("Then access to This is Me page");
			CheckThisIsMePage.checkPersonalDetailTableExisted(driver, 10);
			Reporter.log("Then check Table Personal Detail existed");
			Assert.assertTrue(CheckThisIsMePage.checkMembershipExisted(driver, refno));
			Reporter.log("Then check refno : " + refno + " will existed in table");
			//check Payslips page 
			PaySlipsPage.loadPage(driver);
			Reporter.log("Then access to Payslips page");
			Assert.assertTrue(CheckPaySlipsPage.checkTablePaySlipsExisted(driver,10));
			Assert.assertTrue(CheckPaySlipsPage.checkTablePersonalDetailExisted(driver, 10));
			Reporter.log("Then check : table payslips , table personal detail existed");
			Assert.assertTrue(CheckPaySlipsPage.checkCurrentTaxYear(driver));
			Assert.assertTrue(CheckPaySlipsPage.checkRefno(driver, refno));
			Assert.assertTrue(CheckPaySlipsPage.checkNiNo(driver));
			Assert.assertTrue(CheckPaySlipsPage.checkBttPreviousExisted(driver, 10));
			Reporter.log("Then check : current tax year and refno and nino and button previous existed");
			//logout
			Authenticate.LogOut(driver, 10);
			Reporter.log("Finally logout");
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
