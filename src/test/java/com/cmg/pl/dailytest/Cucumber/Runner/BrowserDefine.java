package com.cmg.pl.dailytest.Cucumber.Runner;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.pageObject.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BrowserDefine {
	
	@Before("@ie")
	public void beforeie() {
		System.out.println("before ie tag");
		DriverUtil.browserRunning = "ie";
	}

	@After("@ie")
	public void afterie() {
		System.out.println("after ie tag");
	}
	
	
	@Before("@firefox")
	public void beforeScenario() {
		System.out.println("before firefox tag");
		DriverUtil.browserRunning = "firefox";
	}

	@After("@firefox")
	public void afterScenario() {
		System.out.println("after firefox tag");
	}
	
	@Before("@chrome")
	public void beforeChrome() {
		System.out.println("before chrome tag");
		DriverUtil.browserRunning = "chrome";
	}

	@After("@firefox")
	public void afterChrome() {
		System.out.println("after chrome tag");
	}
	
	@Given("^I open browser \"(.*?)\"$")
	public void i_open_browser(String arg1) {
		String browser = arg1;
		DriverUtil.driverCurrent = DriverUtil.getInstance(browser);
	}
	
	@Given("^I open browser$")
	public void open() {
		DriverUtil.driverCurrent = DriverUtil.getInstance(DriverUtil.browserRunning);
	}
	
	@Then("^I quit the browser$")
	public void i_quit_the_browser() {
		DriverUtil.driverCurrent.quit();
	}
	
	@And("^I navigate to Login Page$")
	public void i_navigate_to_Login_Page() {
		LoginPage.LoadPage(DriverUtil.driverCurrent);
	}
}
