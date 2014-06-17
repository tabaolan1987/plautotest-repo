package com.cmg.pl.dailytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.CheckPaySlipsPage;
import com.cmg.pl.action.CheckThisIsMePage;
import com.cmg.pl.action.MyDetailCheck;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.MyDetailPage;
import com.cmg.pl.pageObject.PaySlipsPage;
import com.cmg.pl.pageObject.ThisIsMePage;

public class LoadMember_BPF_0100027 {

	private static WebDriver driver;

	private static String usernameLogin;

	private static String usernamePass;

	private static String refno = "0100027";

	private static String group = "BPF";

	@Parameters({ "browser", "super_user_name", "super_user_pass" })
	@BeforeTest
	public void beforeTest(String browser, String super_user_name,
			String super_user_pass) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					DriverUtil.getChromeDriver());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
			driver = new InternetExplorerDriver();
		}

		usernameLogin = super_user_name;
		usernamePass = super_user_pass;

	}

	@Test
	public void dailytest() {
		LoginPage.LoadPage(driver);
		Authenticate.Login(driver, usernameLogin, usernamePass);
		SuperUser.loadMember(driver, 50, group, refno);

		// link need show up in submenu
		MyDetailPage.loadPage(driver);
		Assert.assertTrue(MyDetailCheck.checkThisIsMeLink(driver, 10));
		Assert.assertTrue(MyDetailCheck.checkPaySlips(driver, 10));
		Assert.assertTrue(MyDetailCheck.checkSchemePays(driver, 10));
		// link need do not show up in submenu
		Assert.assertFalse(MyDetailCheck.checkMyLifeTime(driver, 10));
		Assert.assertFalse(MyDetailCheck.checkMyAccurateLink(driver, 10));
		Assert.assertFalse(MyDetailCheck.checkMyBenefitsLink(driver, 10));
		Assert.assertFalse(MyDetailCheck.checkMyRetirementLink(driver, 10));
		Assert.assertFalse(MyDetailCheck.checkRedundacyLink(driver, 10));
		Assert.assertFalse(MyDetailCheck.checkMyAnnualAllowance(driver, 10));
		Assert.assertFalse(MyDetailCheck.checkMyCarryForward(driver, 10));

		// check this is me page
		ThisIsMePage.loadPage(driver);
		ThisIsMePage.loadPage(driver);
		CheckThisIsMePage.checkPersonalDetailTableExisted(driver, 20);
		CheckThisIsMePage.checkMembershipExisted(driver, refno);

		// check Payslips page
		PaySlipsPage.loadPage(driver);
		Assert.assertTrue(CheckPaySlipsPage.checkTablePaySlipsExisted(driver,
				10));
		Assert.assertTrue(CheckPaySlipsPage.checkTablePersonalDetailExisted(
				driver, 10));
		Assert.assertTrue(CheckPaySlipsPage.checkCurrentTaxYear(driver));
		Assert.assertTrue(CheckPaySlipsPage.checkRefno(driver, refno));
		Assert.assertTrue(CheckPaySlipsPage.checkNiNo(driver));
		Assert.assertTrue(CheckPaySlipsPage.checkBttPreviousExisted(driver, 10));

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
