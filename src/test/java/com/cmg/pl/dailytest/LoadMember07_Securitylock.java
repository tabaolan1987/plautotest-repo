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

	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) {
		driver = DriverUtil.getInstance(browser);
		TakeScreenShot.init(driver);
	}

	@Test(timeOut = 1200000)
	public void LoadMember07Securitylock() throws InterruptedException {
		LoginPage.LoadPage(driver);
		Authenticate.Login(driver, ParameterMap.getValue("superusername"),
				ParameterMap.getValue("superuserpass"));
		SuperUser.loadMember(driver, Constant.NORMAL_WAITING_TIME,
				ParameterMap.getValue("group"), ParameterMap.getValue("refno"));
		Reporter.log("Superuser load member : "
				+ ParameterMap.getValue("refno"));
		// check for links available under 'My details'
		MyDetailPage.loadPage(driver);
		Reporter.log("Then access to my detail page");
		MyDetailCheck mdCheck = new MyDetailCheck();
		mdCheck.checkLinkInVisible(driver,
				ParameterMap.getValue("invisibleLinkUnderMyDetails"));
		mdCheck.checkLinkVisible(driver,
				ParameterMap.getValue("visibleLinkUnderMyDetails"));
		// check 'This is me' page
		ThisIsMePage.loadPage(driver);
		Reporter.log("Then access to This is Me page");
		CheckThisIsMePage.checkPersonalDetailTableExisted(driver,
				Constant.SMALL_WAITING_TIME);
		Reporter.log("Then check Table Personal Detail existed");
		Assert.assertTrue(
				CheckThisIsMePage.checkMembershipExisted(driver,
						ParameterMap.getValue("refno")), "Refno : "
						+ ParameterMap.getValue("refno") + " did not exist");
		Reporter.log("Then check refno : " + ParameterMap.getValue("refno")
				+ " will existed in table");
		if(mdCheck.isLinkVisible(driver, ParameterMap.getValue("visibleLinkUnderMyDetails"), "My Benefits")){
			// check 'My Benefits' page and its sub-menus
			MyBenefitPage.loadPage(driver);
			Reporter.log("Then access to My Benefit page");
			CheckMyBenefitPage chMBP = new CheckMyBenefitPage();
			chMBP.checkLinkVisible(driver,
					ParameterMap.getValue("visibleLinkUnderMyBenefits"));
			if(chMBP.checkLinkVisible(driver, ParameterMap.getValue("visibleLinkUnderMyBenefits"),CheckMyBenefitPage.LINK_TEXT_SCHEME_BENEFITS )){
				SchemeBenefitsPage.loadPage(driver);
				Reporter.log("Then access to Scheme Benefits page");
				Assert.assertTrue(CheckSchemeBenefitsPage
						.checkTablePersonalDetailsExisted(driver,
								Constant.SMALL_WAITING_TIME));
				Reporter.log("Then Check the table personal details will show");
				Assert.assertTrue(CheckSchemeBenefitsPage.checkMemberRefNumberExisted(
						driver, ParameterMap.getValue("refno")), "Refno : "
						+ ParameterMap.getValue("refno") + " did not exist");
				Assert.assertTrue(
						CheckSchemeBenefitsPage.checkNinoNumberExisted(driver),
						"Nino number did not exist");
				Reporter.log("Then check refno : " + ParameterMap.getValue("refno")
						+ " and nino number will existed in this table");
			}
			if(chMBP.checkLinkVisible(driver, ParameterMap.getValue("visibleLinkUnderMyBenefits"),CheckMyBenefitPage.LINK_TEXT_STATE_BENEFITS )){
				StateBenefitsPage.loadPage(driver);
				Reporter.log("Then access to State Benefit page");
				Assert.assertTrue(CheckStateBenefitsPage
						.checkTablePersonalDetailExisted(driver,
								Constant.SMALL_WAITING_TIME),"Table personal detail did not exist");
				Reporter.log("Then Check the table personal details will show");
				Assert.assertTrue(CheckStateBenefitsPage.checkDateOfBirth(driver),"Can not get Date Of Birth");
				Assert.assertTrue(CheckStateBenefitsPage.checkNinoNumber(driver),"Can not get Nino number");
				Reporter.log("Then check the date of birth and the nino number should existed in table");
			}
		}
		

		// Check 'My Annual Allowance' Page and its sub-menus
		MyAnnualAllowancePage.loadPage(driver);
		Reporter.log("Then access to My Annual Allowance page");
		CheckMyAnnualAllowancePage chkMAAP = new CheckMyAnnualAllowancePage();
		chkMAAP.checkLinkVisible(driver,
				ParameterMap.getValue("visibleLinkUnderMyAnnualAllowance"));
		Reporter.log("Then check AA Pension Savings, AA Statement link should show under My Annual Allowance");
		chkMAAP.checkLinkInvisible(driver,
				ParameterMap.getValue("invisibleLinkUnderMyAnnualAllowance"));
		Reporter.log("Then check AA Projection should not show under My Annual Allowance");

		// Check 'My Carry Forward' page
		MyCarryForwardPage.loadPage(driver);
		Reporter.log("Then check My Carry Forward page should show");
		// logout
		Authenticate.LogOut(driver, Constant.SMALL_WAITING_TIME);
		Reporter.log("Finnaly logout");
		System.out
				.println("------------------------------------------------------------------------------");
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
