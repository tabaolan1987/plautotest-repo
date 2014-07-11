package com.cmg.pl.dailytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.CheckAccessReportsPage;
import com.cmg.pl.action.ProduceReportWithInputParam;
import com.cmg.pl.action.RunCheckingConnectionReportGroup;
import com.cmg.pl.pageObject.LoginPage;
import com.cmg.pl.pageObject.ReportingToolPage;

public class ProduceReport {
	
	private static String report_runner_username;
	private static String report_runner_password;
	private static WebDriver driver;
	
  
  @Parameters({ "browser", "report_runner_name", "report_runner_pass"})
	@BeforeMethod
	public void beforeMethod(String browser, String report_runner_name, String report_runner_pass) 
	{
		if (browser.equalsIgnoreCase("firefox")) {
			try {
				System.out.println("Start firefox : Report Runner Login");
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
			System.out.println("Start chrome : Report Runner Login");
			System.setProperty("webdriver.chrome.driver",
					DriverUtil.getChromeDriver());
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("Start ie : Report Runner Login");
			System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(
			    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			    true);
			driver = new InternetExplorerDriver(caps);
			driver.manage().deleteAllCookies();
			driver.get(Constant.main_url);
		}
		TakeScreenShot.init(driver);
		report_runner_username = report_runner_name;
		report_runner_password = report_runner_pass;
		
		
	}
  
  @Test
  public void dailytest() throws InterruptedException {
	  LoginPage.LoadPage(driver);
	  Authenticate.Login(driver, report_runner_username, report_runner_password);
	  ReportingToolPage.loadPage(driver);
	  RunCheckingConnectionReportGroup.runReportGroupCheckingConnection(driver);
	  Assert.assertTrue(CheckAccessReportsPage.CheckReportSections(driver));
	  CheckAccessReportsPage.CheckSelectAllReports(driver);
	 // Thread.sleep(10000);
	  TakeScreenShot.takeScreenshoot();
	  CheckAccessReportsPage.RunSelectedReports(driver);
	  Thread.sleep(2000);
	  ProduceReportWithInputParam.ProduceReportWithDefaultParam(driver);
	  
	  //logout
	  Authenticate.LogOut(driver, 10);
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
