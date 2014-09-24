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
import com.cmg.pl.action.CheckMyAnnualAllowancePage;
import com.cmg.pl.action.CheckMyBenefitPage;
import com.cmg.pl.action.CheckSchemeBenefitsPage;
import com.cmg.pl.action.CheckStateBenefitsPage;
import com.cmg.pl.action.CheckThisIsMePage;
import com.cmg.pl.action.MyDetailCheck;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.MyAnnualAllowancePage;
import com.cmg.pl.pageObject.MyBenefitPage;
import com.cmg.pl.pageObject.MyCarryForwardPage;
import com.cmg.pl.pageObject.MyDetailPage;
import com.cmg.pl.pageObject.SchemeBenefitsPage;
import com.cmg.pl.pageObject.StateBenefitsPage;
import com.cmg.pl.pageObject.ThisIsMePage;

public class LoadMember07_Securitylock {
	 private static WebDriver driver;
	  
	  private static String usernameLogin;
	  
	  private static String usernamePass;
	  
	  private static String refno;
	  
	  private static String group = "BPF";
	  
	  
	  @Parameters({"browser","super_user_name","super_user_pass","securitylock_ref_no01"})
	  @BeforeMethod
	  public void beforeMethod(String browser , String super_user_name , String super_user_pass, String securitylock_ref_no01) 
	  {
		  driver = DriverUtil.getInstance(browser);
		  TakeScreenShot.init(driver);
		  usernameLogin = super_user_name;
		  usernamePass = super_user_pass;
		  refno = securitylock_ref_no01;
				  
	  }

	  @Test(timeOut = 1200000)
	  public void LoadMember07Securitylock() throws InterruptedException {
			  LoginPage.LoadPage(driver);
			  Authenticate.Login(driver, usernameLogin, usernamePass);
			  SuperUser.loadMember(driver, 30 , group, refno);
			  Reporter.log("Superuser load member : " + refno);
			  //check for links available under 'My details'
			  MyDetailPage.loadPage(driver);
			  Reporter.log("Then access to my detail page");
			  Assert.assertTrue(MyDetailCheck.checkThisIsMeLink(driver, 5));
			  Assert.assertTrue(MyDetailCheck.checkMyBenefitsLink(driver, 5));
			  Assert.assertTrue(MyDetailCheck.checkMyAnnualAllowance(driver, 5));
			  Assert.assertTrue(MyDetailCheck.checkMyCarryForward(driver, 5));
			  Assert.assertTrue(MyDetailCheck.checkSchemePays(driver, 5));
			  Reporter.log("Then check : This is Me, My Benefits, My Annual Allowance, My Carry Forward, Scheme Pays will show under My Detail");
			  
			  //check for links unavailable under 'My details'
			  Assert.assertFalse(MyDetailCheck.checkPaySlips(driver, 5));
			  Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, 5));
			  Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, 5));
			  Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, 5));
			  Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, 5));
			  Reporter.log("Then check : PaySlips, My Retirement, My Redundancy, My Lifetime and My Accurate  will not show under My Detail");
			  //check 'This is me' page
			  ThisIsMePage.loadPage(driver);
			  Reporter.log("Then access to This is Me page");
			  CheckThisIsMePage.checkPersonalDetailTableExisted(driver, 10);
			  Reporter.log("Then check Table Personal Detail existed");
			  Assert.assertTrue(CheckThisIsMePage.checkMembershipExisted(driver, refno));
			  Reporter.log("Then check refno : " + refno + " will existed in table");
			  
			  //check 'My Benefits' page and its sub-menus
			  MyBenefitPage.loadPage(driver);
			  Reporter.log("Then access to My Benefit page");
			  Assert.assertTrue(CheckMyBenefitPage.checkLinkSchemeBenefits(driver, 10));
			  Assert.assertTrue(CheckMyBenefitPage.checkLinkStateBenefits(driver, 10));
			  Reporter.log("Then check link Scheme Benefits and State Benefits will show under My Benefit");
			  
			  //check 'Scheme Benefits' page
			  SchemeBenefitsPage.loadPage(driver);
			  Reporter.log("Then access to Scheme Benefits page");
			  Assert.assertTrue(CheckSchemeBenefitsPage.checkTablePersonalDetailsExisted(driver, 10));
			  Reporter.log("Then Check the table personal details will show");
			  Assert.assertTrue(CheckSchemeBenefitsPage.checkMemberRefNumberExisted(driver, refno));
			  Assert.assertTrue(CheckSchemeBenefitsPage.checkNinoNumberExisted(driver));
			  Reporter.log("Then check refno : " + refno + " and nino number will existed in this table");
			 
			  //check 'State Benefits' page
			  StateBenefitsPage.loadPage(driver);
			  Reporter.log("Then access to State Benefit page");
			  Assert.assertTrue(CheckStateBenefitsPage.checkTablePersonalDetailExisted(driver, 10));
			  Reporter.log("Then Check the table personal details will show");
			  Assert.assertTrue(CheckStateBenefitsPage.checkDateOfBirth(driver));
			  Assert.assertTrue(CheckStateBenefitsPage.checkNinoNumber(driver));
			  Reporter.log("Then check the date of birth and the nino number should existed in table");
			  
			  //Check 'My Annual Allowance' Page and its sub-menus
			  MyAnnualAllowancePage.loadPage(driver);
			  Reporter.log("Then access to My Annual Allowance page");
			  Assert.assertTrue(CheckMyAnnualAllowancePage.checkAAPensionSavings(driver, 5));
			  Assert.assertTrue(CheckMyAnnualAllowancePage.checkAAStatementLink(driver, 5));
			  Reporter.log("Then check AA Pension Savings, AA Statement link should show under My Annual Allowance");
			  Assert.assertFalse(CheckMyAnnualAllowancePage.checkAAProjection(driver, 5));
			  Reporter.log("Then check AA Projection should not show under My Annual Allowance");
			  
			  //Check 'My Carry Forward' page
			  MyCarryForwardPage.loadPage(driver);
			  Reporter.log("Then check My Carry Forward page should show");
			  //logout
			  Authenticate.LogOut(driver, 10);
			  Reporter.log("Finnaly logout");
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
