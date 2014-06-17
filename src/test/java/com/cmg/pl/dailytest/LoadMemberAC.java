package com.cmg.pl.dailytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.CheckMyAnnualAllowancePage;
import com.cmg.pl.action.CheckMyBenefitPage;
import com.cmg.pl.action.CheckMyRetirementPage;
import com.cmg.pl.action.CheckSchemeBenefitsPage;
import com.cmg.pl.action.CheckStateBenefitsPage;
import com.cmg.pl.action.CheckThisIsMePage;
import com.cmg.pl.action.MyDetailCheck;
import com.cmg.pl.action.RedundancyCheck;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.MyAnnualAllowancePage;
import com.cmg.pl.pageObject.MyBenefitPage;
import com.cmg.pl.pageObject.MyCarryForwardPage;
import com.cmg.pl.pageObject.MyDetailPage;
import com.cmg.pl.pageObject.MyRetirementPage;
import com.cmg.pl.pageObject.RedundancyPage;
import com.cmg.pl.pageObject.SchemeBenefitsPage;
import com.cmg.pl.pageObject.StateBenefitsPage;
import com.cmg.pl.pageObject.ThisIsMePage;

public class LoadMemberAC {
	
  private static WebDriver driver;
  
  private static String usernameLogin;
  
  private static String usernamePass;
  
  private static String refno = "0122398";
  
  private static String group = "BPF";
  
  
  @Parameters({"browser","super_user_name","super_user_pass"})
  @BeforeMethod
  public void beforeMethod(String browser , String super_user_name , String super_user_pass) {
	  if(browser.equalsIgnoreCase("firefox")){
		  driver = new FirefoxDriver();
	  }else if(browser.equalsIgnoreCase("chrome")){
		  System.setProperty("webdriver.chrome.driver", DriverUtil.getChromeDriver());
		  driver= new ChromeDriver();
	  }else if(browser.equalsIgnoreCase("ie")){
		  System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
	      driver = new InternetExplorerDriver();
	  }
	  
	  usernameLogin = super_user_name;
	  usernamePass = super_user_pass;
			  
  }

  @Test
  public void dailyTest() throws InterruptedException {
	  LoginPage.LoadPage(driver);
	  Authenticate.Login(driver, usernameLogin, usernamePass);
	  SuperUser.loadMember(driver, 50 , group, refno);
	  
	  //link need show up in submenu
	  MyDetailPage.loadPage(driver);
	  Assert.assertTrue(MyDetailCheck.checkThisIsMeLink(driver, 10));
	  Assert.assertTrue(MyDetailCheck.checkMyBenefitsLink(driver, 10));
	  Assert.assertTrue(MyDetailCheck.checkMyRetirementLink(driver, 10));
	  Assert.assertTrue(MyDetailCheck.checkRedundacyLink(driver, 10));
	  Assert.assertTrue(MyDetailCheck.checkMyAnnualAllowance(driver, 10));
	  Assert.assertTrue(MyDetailCheck.checkMyCarryForward(driver, 10));
	  Assert.assertTrue(MyDetailCheck.checkSchemePays(driver, 10));
	  
	  //link need do not show up in submenu
	  Assert.assertFalse(MyDetailCheck.checkPaySlips(driver, 10));
	  Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, 10));
	  Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, 10));
	  
	  //check this is me page
	  ThisIsMePage.loadPage(driver);
	  CheckThisIsMePage.checkPersonalDetailTableExisted(driver, 20);
	  CheckThisIsMePage.checkMembershipExisted(driver, refno);
	  
	  //check MyBenefit page and link existed
	  MyBenefitPage.loadPage(driver);
	  Assert.assertTrue(CheckMyBenefitPage.checkLinkSchemeBenefits(driver, 20));
	  Assert.assertTrue(CheckMyBenefitPage.checkLinkStateBenefits(driver, 20));
	  
	  //check SchemeBenefits
	  SchemeBenefitsPage.loadPage(driver);
	  Assert.assertTrue(CheckSchemeBenefitsPage.checkTablePersonalDetailsExisted(driver, 20));
	  Assert.assertTrue(CheckSchemeBenefitsPage.checkMemberRefNumberExisted(driver, refno));
	  Assert.assertTrue(CheckSchemeBenefitsPage.checkNinoNumberExisted(driver));
	  
	  //check state benefits
	  StateBenefitsPage.loadPage(driver);
	  Assert.assertTrue(CheckStateBenefitsPage.checkTablePersonalDetailExisted(driver, 20));
	  Assert.assertTrue(CheckStateBenefitsPage.checkDateOfBirth(driver));
	  Assert.assertTrue(CheckStateBenefitsPage.checkNinoNumber(driver));
	  
	  //check My Retirement Page and model 3 option
	  MyRetirementPage.loadPage(driver);
	  CheckMyRetirementPage.modelRetirementAge(driver, -30);
	  CheckMyRetirementPage.modelCashLumpSum(driver, 20);
	  CheckMyRetirementPage.modelContributoryOptions(driver, 10 , 2);
	  
	  
	  //Check Redundancy Page and model future date
	  RedundancyPage.loadPage(driver);
	  RedundancyCheck.modelRedundancy(driver);
	  
	  //Check My Annual Allowance Page
	  MyAnnualAllowancePage.loadPage(driver);
	  Assert.assertTrue(CheckMyAnnualAllowancePage.checkAAPensionSavings(driver, 10));
	  Assert.assertTrue(CheckMyAnnualAllowancePage.checkAAStatementLink(driver, 10));
	  Assert.assertFalse(CheckMyAnnualAllowancePage.checkAAProjection(driver, 5));
	  
	  //Check My Carry Forward loading
	  MyCarryForwardPage.loadPage(driver);
	  
	  //logout system
	  Authenticate.LogOut(driver, 10);
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
