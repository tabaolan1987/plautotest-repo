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
import com.cmg.pl.action.PageLoading;
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

	@BeforeMethod
	public void beforeMethod(){
		driver = new FirefoxDriver();
	}

	@Test
	public void dailyTest() throws InterruptedException {
		LoginPage.LoadPage(driver);
		Authenticate.Login(driver, "admin", "P3nsions0");
		Thread.sleep(5000);
		// check this is me page
		driver.get("https://pensionline.bp.com/content/pl/mydetails/this_is_me.html");
		///Assert.assertFalse(PageLoading.checkDataError(driver));
		// logout system
		Authenticate.LogOut(driver, 10);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
