package com.c_mg.pl.selenium.PLAUTOTEST;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkUtil {

	public void updateTestLinkResult(String testCase, String exception,
			String result) throws TestLinkAPIException, br.eti.kinoshita.testlinkjavaapi.TestLinkAPIException, MalformedURLException  {
		TestLinkAPIClient  testlinkAPIClient = new TestLinkAPIClient(Constant.API_KEY_TESTLINK,
				Constant.SERVER_URL);
		testlinkAPIClient.reportTestCaseResult(Constant.PROJECT_NAME, Constant.PLAN_NAME,
				testCase, Constant.BUILD_NAME, exception, result);
		
	}
	
	
	public void createNewBuild() throws TestLinkAPIException{
		TestLinkAPIClient  testlinkAPIClient = new TestLinkAPIClient(Constant.API_KEY_TESTLINK,
				Constant.SERVER_URL);
		String buildName = "Automation Daily Test : " + new Date();
		String buildNotes = "This is a build for automation test daily pensionline";
		testlinkAPIClient.createBuild(Constant.PROJECT_NAME, Constant.PLAN_NAME, buildName, buildNotes);
		Constant.BUILD_NAME = buildName;
		
		
	}
	
}
