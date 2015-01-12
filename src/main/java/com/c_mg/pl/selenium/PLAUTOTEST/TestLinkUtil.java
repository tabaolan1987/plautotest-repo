package com.c_mg.pl.selenium.PLAUTOTEST;

import java.net.URL;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.Platform;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;


public class TestLinkUtil {
	
	
	public Integer getIdTestCase(String testcaseName) {
		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(
				Constant.API_KEY_TESTLINK, Constant.SERVER_URL);
		try {
			TestLinkAPIResults result = testlinkAPIClient
					.getTestCaseIDByName(testcaseName);
			String ex = (String) result.getValueByName(0, "id");
			int id = Integer.parseInt(ex);
			return id;
		} catch (TestLinkAPIException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getExIdTestCase(String testcaseName){
		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(
				Constant.API_KEY_TESTLINK, Constant.SERVER_URL);
		try {
			TestLinkAPIResults result = testlinkAPIClient
					.getTestCaseIDByName(testcaseName);
			String ex = (String) result.getValueByName(0, "tc_external_id");
			int exID = Integer.parseInt(ex);
			return exID;
		} catch (TestLinkAPIException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public String getTestSuiteByTcName(String testcaseName){
		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(
				Constant.API_KEY_TESTLINK, Constant.SERVER_URL);
		try {
			TestLinkAPIResults result = testlinkAPIClient
					.getTestCaseIDByName(testcaseName);
			String testsuite = (String) result.getValueByName(0, "tsuite_name");
			return testsuite;
		} catch (TestLinkAPIException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public TestPlan getTestPlanIDByName(String projectName, String testPlanName){
		try {
			TestLinkAPI api = new TestLinkAPI(new URL(Constant.SERVER_URL),
					Constant.API_KEY_TESTLINK);
			TestPlan tl = api.getTestPlanByName(testPlanName, projectName);
			return tl;
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Platform getPlatform(String browser, int testPlanID){
		try {
			TestLinkAPI api = new TestLinkAPI(new URL(Constant.SERVER_URL),
					Constant.API_KEY_TESTLINK);
			Platform[] listPlat = api.getTestPlanPlatforms(testPlanID);
			for(Platform p : listPlat){
				String name = p.getName();
				if(name.equalsIgnoreCase(browser)){
					return p;
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Build getBuildByName(String buildName, int testPlanId){
		try {
			TestLinkAPI api = new TestLinkAPI(new URL(Constant.SERVER_URL),
					Constant.API_KEY_TESTLINK);
			Build[] listBuild = api.getBuildsForTestPlan(testPlanId);
			for(Build b : listBuild){
				String name = b.getName();
				if(name.equalsIgnoreCase(buildName)){
					return b;
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	

}
