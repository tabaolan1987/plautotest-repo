package com.c_mg.pl.selenium.PLAUTOTEST;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;


/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws MalformedURLException {
		try {
			updateTestLinkResult("test case 1", "no exception", TestLinkAPIClient.TEST_PASSED);
		} catch (TestLinkAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateTestLinkResult(String testCase, String exception,
			String result) throws TestLinkAPIException  {
		TestLinkAPIClient  testlinkAPIClient = new TestLinkAPIClient(Constant.API_KEY_TESTLINK,
				Constant.SERVER_URL);
		testlinkAPIClient.reportTestCaseResult(Constant.PROJECT_NAME, Constant.PLAN_NAME,
				testCase, Constant.BUILD_NAME, exception, result);
	}
	
	
}
