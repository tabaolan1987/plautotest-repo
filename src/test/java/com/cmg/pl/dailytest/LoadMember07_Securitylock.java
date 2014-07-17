package com.cmg.pl.dailytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
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
		  if(browser.equalsIgnoreCase("firefox")){
			  try {
					System.out.println("Start firefox : LoadMember07_Securitylock");
					driver = new FirefoxDriver();
					driver.manage().deleteAllCookies();
				} catch (WebDriverException e) {
					System.out.println(e.getMessage());
					FirefoxProfile profile = new FirefoxProfile();
					profile.setAcceptUntrustedCertificates(true);
					profile.setPreference(FirefoxProfile.PORT_PREFERENCE, 7056);
					driver = new FirefoxDriver(profile);
				}
		  }else if(browser.equalsIgnoreCase("chrome")){
			  System.out.println("Start chrome : LoadMember07_Securitylock");
			  System.setProperty("webdriver.chrome.driver", DriverUtil.getChromeDriver());
			  driver= new ChromeDriver();
			  driver.manage().deleteAllCookies();
		  }else if(browser.equalsIgnoreCase("ie")){
			  System.out.println("Start ie : LoadMember07_Securitylock");
			  System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
			  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(
				    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				    true);
				driver = new InternetExplorerDriver(caps);
				driver.manage().deleteAllCookies();
		  }
		  driver.manage().deleteAllCookies();
		  TakeScreenShot.init(driver);
		  usernameLogin = super_user_name;
		  usernamePass = super_user_pass;
		  refno = securitylock_ref_no01;
				  
	  }

	  @Test
	  public void dailyTest() throws InterruptedException {
			  LoginPage.LoadPage(driver);
			  Authenticate.Login(driver, usernameLogin, usernamePass);
			  SuperUser.loadMember(driver, 30 , group, refno);
			  
			  //check for links available under 'My details'
			  MyDetailPage.loadPage(driver);
			  TakeScreenShot.takeScreenshoot();
			  Assert.assertTrue(MyDetailCheck.checkThisIsMeLink(driver, 5));
			  Assert.assertTrue(MyDetailCheck.checkMyBenefitsLink(driver, 5));
			  Assert.assertTrue(MyDetailCheck.checkMyAnnualAllowance(driver, 5));
			  Assert.assertTrue(MyDetailCheck.checkMyCarryForward(driver, 5));
			  Assert.assertTrue(MyDetailCheck.checkSchemePays(driver, 5));
			  
			  //check for links unavailable under 'My details'
			  Assert.assertFalse(MyDetailCheck.checkPaySlips(driver, 5));
			  Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, 5));
			  Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, 5));
			  Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, 5));
			  Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, 5));
			  
			  //check 'This is me' page
			  ThisIsMePage.loadPage(driver);
			  CheckThisIsMePage.checkPersonalDetailTableExisted(driver, 10);
			  CheckThisIsMePage.checkMembershipExisted(driver, refno);
			  
			  //check 'My Benefits' page and its sub-menus
			  MyBenefitPage.loadPage(driver);
			  Assert.assertTrue(CheckMyBenefitPage.checkLinkSchemeBenefits(driver, 10));
			  Assert.assertTrue(CheckMyBenefitPage.checkLinkStateBenefits(driver, 10));
			  
			  //check 'Scheme Benefits' page
			  SchemeBenefitsPage.loadPage(driver);
			  Assert.assertTrue(CheckSchemeBenefitsPage.checkTablePersonalDetailsExisted(driver, 10));
			  Assert.assertTrue(CheckSchemeBenefitsPage.checkMemberRefNumberExisted(driver, refno));
			  Assert.assertTrue(CheckSchemeBenefitsPage.checkNinoNumberExisted(driver));
			  
			  //check 'State Benefits' page
			  StateBenefitsPage.loadPage(driver);
			  Assert.assertTrue(CheckStateBenefitsPage.checkTablePersonalDetailExisted(driver, 10));
			  Assert.assertTrue(CheckStateBenefitsPage.checkDateOfBirth(driver));
			  Assert.assertTrue(CheckStateBenefitsPage.checkNinoNumber(driver));
			  
			  //Check 'My Annual Allowance' Page and its sub-menus
			  MyAnnualAllowancePage.loadPage(driver);
			  Assert.assertTrue(CheckMyAnnualAllowancePage.checkAAPensionSavings(driver, 5));
			  Assert.assertTrue(CheckMyAnnualAllowancePage.checkAAStatementLink(driver, 5));
			  Assert.assertFalse(CheckMyAnnualAllowancePage.checkAAProjection(driver, 5));
			  
			  //Check 'My Carry Forward' page
			  MyCarryForwardPage.loadPage(driver);
			  
			  //logout
			  Authenticate.LogOut(driver, 10);
		  
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
}
