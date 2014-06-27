package com.cmg.pl.dailytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.CheckThisIsMePage;
import com.cmg.pl.action.MyDetailCheck;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.MyDetailPage;
import com.cmg.pl.pageObject.ThisIsMePage;

public class LoadMember02_Deferred {
	private static WebDriver driver;

	private static String usernameLogin;

	private static String usernamePass;

	private static String refno;

	private static String group = "BPF";

	@Parameters({ "browser", "super_user_name", "super_user_pass" ,"deferred_ref_no01"})
	@BeforeMethod
	public void beforeMethod(String browser, String super_user_name, String super_user_pass, String deferred_ref_no01) 
	{
		if (browser.equalsIgnoreCase("firefox")) {
			try {
				System.out.println("Start firefox : LoadMember02_Deferred");
				driver = new FirefoxDriver();
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setPreference(FirefoxProfile.PORT_PREFERENCE, "7056");
				driver = new FirefoxDriver(profile);
			}
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Start chrome : LoadMember02_Deferred");
			System.setProperty("webdriver.chrome.driver",
					DriverUtil.getChromeDriver());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("Start ie : LoadMember02_Deferred");
			System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
			driver = new InternetExplorerDriver();
		}
		driver.manage().deleteAllCookies();
		TakeScreenShot.init(driver);
		usernameLogin = super_user_name;
		usernamePass = super_user_pass;
		refno = deferred_ref_no01;
		
	}
	
	@Test
	public void dailytest() {
			LoginPage.LoadPage(driver);
			Authenticate.Login(driver, usernameLogin, usernamePass);
			SuperUser.loadMember(driver, 30, group, refno);

			//check for links available under 'My details'
			MyDetailPage.loadPage(driver);
			TakeScreenShot.takeScreenshoot();
			Assert.assertTrue(MyDetailCheck.checkThisIsMeLink(driver, 5));
			Assert.assertTrue(MyDetailCheck.checkSchemePays(driver, 5));
			//check for links unavailable under 'My details'	
			Assert.assertFalse(MyDetailCheck.checkPaySlips(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyBenefitsLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyAnnualAllowance(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyCarryForward(driver, 5));
			//check 'This is me' page
			ThisIsMePage.loadPage(driver);
			CheckThisIsMePage.checkPersonalDetailTableExisted(driver, 10);
			CheckThisIsMePage.checkMembershipExisted(driver, refno);

			//logout
			Authenticate.LogOut(driver, 10);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
}
