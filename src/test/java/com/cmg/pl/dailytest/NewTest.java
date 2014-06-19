package com.cmg.pl.dailytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;

public class NewTest {
  @Test
  public void f() {
	  System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
	  WebDriver driver = new InternetExplorerDriver();
	  System.out.println("load");
	  driver.get("www.google.com");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
