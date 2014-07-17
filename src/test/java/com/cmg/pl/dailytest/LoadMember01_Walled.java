package com.cmg.pl.dailytest;

import java.util.concurrent.TimeUnit;

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
		if (browser.equalsIgnoreCase("firefox")) {
			try {
				System.out.println("Start firefox : LoadMember01_Walled");
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setPreference(FirefoxProfile.PORT_PREFERENCE, 7056);
				driver = new FirefoxDriver(profile);
			}
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Start chrome : LoadMember01_Walled");
			System.setProperty("webdriver.chrome.driver",
					DriverUtil.getChromeDriver());
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("Start ie : LoadMember01_Walled");
			System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(
			    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			    true);
			driver = new InternetExplorerDriver(caps);
			driver.manage().deleteAllCookies();
		}
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		TakeScreenShot.init(driver);
		usernameLogin = super_user_name;
		usernamePass = super_user_pass;
		refno = walled_ref_no01;
		
	}
	
	@Test
	public void dailytest() {
		try {
			LoginPage.LoadPage(driver);
			Authenticate.Login(driver, usernameLogin, usernamePass);
			SuperUser.loadMember(driver, 30, group, refno);
			
			//check for links unavailable under 'My details'
			MyDetailPage.loadPage(driver);
			TakeScreenShot.takeScreenshoot();
			Assert.assertFalse(MyDetailCheck.checkThisIsMeLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkPaySlips(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkSchemePays(driver, 5));
					
			Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyBenefitsLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyAnnualAllowance(driver, 5));
			Assert.assertFalse(MyDetailCheck.checkMyCarryForward(driver, 5));
			
			//logout
			Authenticate.LogOut(driver, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
