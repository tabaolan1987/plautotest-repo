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
import com.c_mg.pl.selenium.PLAUTOTEST.ParameterMap;
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
	
	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) {
		driver = DriverUtil.getInstance(browser);
		TakeScreenShot.init(driver);

	}

	@Test(timeOut = 1200000)
	public void LoadMember02Deferred() {
		LoginPage.LoadPage(driver);
		Authenticate.Login(driver, ParameterMap.getValue("superusername"), ParameterMap.getValue("superuserpass"));
		SuperUser.loadMember(driver, Constant.NORMAL_WAITING_TIME, ParameterMap.getValue("group"), ParameterMap.getValue("refno"));
		Reporter.log("Superuser load member : " + ParameterMap.getValue("refno"));
		// check for links available under 'My details'
		MyDetailPage.loadPage(driver);
		Reporter.log("Then Access My Detail");
		MyDetailCheck mdCheck = new MyDetailCheck();
		mdCheck.checkLinkInVisible(driver, ParameterMap.getValue("invisibleLinkUnderMyDetails"));
		mdCheck.checkLinkVisible(driver, ParameterMap.getValue("visibleLinkUnderMyDetails"));
		// check 'This is me' page
		ThisIsMePage.loadPage(driver);
		Reporter.log("Then access to This is Me");
		CheckThisIsMePage.checkPersonalDetailTableExisted(driver, Constant.SMALL_WAITING_TIME);
		Reporter.log("Then check the personal detail table will show");
		Assert.assertTrue(CheckThisIsMePage.checkMembershipExisted(driver,ParameterMap.getValue("refno")),"Refno : " + ParameterMap.getValue("refno") + " did not exist in table personal details");
		Reporter.log("Then check the refno : " + ParameterMap.getValue("refno") + " will existed in this table");
		// logout
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
