package com.c_mg.pl.selenium.PLAUTOTEST;

import java.io.File;
import java.net.InetAddress;
import java.net.URL;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.Execution;
import br.eti.kinoshita.testlinkjavaapi.model.Platform;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;

public class TMTAction {

	private TestLinkUtil util = new TestLinkUtil();

	public void createNewBuild() throws TestLinkAPIException {
		try {
			InetAddress thisIp = InetAddress.getLocalHost();
		     String ip = thisIp.getHostAddress();
		     Constant.SERVER_URL = "http://"+ip+"/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
		     System.out.println(Constant.SERVER_URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(
				Constant.API_KEY_TESTLINK, Constant.SERVER_URL);
		String buildName = "Daily Test : " + new Date();
		String buildNotes = "This is a build created auto from BAMBOO and it doing all test in daily pensionline";
		testlinkAPIClient.createBuild(Constant.PROJECT_NAME,
				Constant.PLAN_NAME, buildName, buildNotes);
		Constant.BUILD_NAME = buildName;

	}

	public boolean updateResultToTestLink(ITestResult result,
			ExecutionStatus ex, String browser, String notes) {
		try {
			TestLinkAPI api = new TestLinkAPI(new URL(Constant.SERVER_URL),
					Constant.API_KEY_TESTLINK);
			TestPlan testPlan = util.getTestPlanIDByName(Constant.PROJECT_NAME,
					Constant.PLAN_NAME);
			Platform platform = util.getPlatform(browser, testPlan.getId());
			Build build = util.getBuildByName(Constant.BUILD_NAME,
					testPlan.getId());
			Integer testCaseId = util.getIdTestCase(result.getName());
			Integer testCaseExternalId = util.getExIdTestCase(result.getName());

			if (testPlan != null && platform != null && build != null
					&& testCaseId != null && testCaseExternalId != null) {
				api.reportTCResult(testCaseId, testCaseExternalId,
						testPlan.getId(), ex, build.getId(), build.getName(),
						notes, false, "", platform.getId(), platform.getName(),
						null, false);
				System.out.println("update result to test link success");
				System.out.println("----------------------------------");
				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateResultToTestLinkWithAttactment(ITestResult result,
			ExecutionStatus ex, String browser, String notes, String filePath) {
		try {
			TestLinkAPI api = new TestLinkAPI(new URL(Constant.SERVER_URL),
					Constant.API_KEY_TESTLINK);
			TestPlan testPlan = util.getTestPlanIDByName(Constant.PROJECT_NAME,
					Constant.PLAN_NAME);
			Platform platform = util.getPlatform(browser, testPlan.getId());
			Build build = util.getBuildByName(Constant.BUILD_NAME,
					testPlan.getId());
			Integer testCaseId = util.getIdTestCase(result.getName());
			Integer testCaseExternalId = util.getExIdTestCase(result.getName());

			if (testPlan != null && platform != null && build != null
					&& testCaseId != null && testCaseExternalId != null) {
				api.reportTCResult(testCaseId, testCaseExternalId,
						testPlan.getId(), ex, build.getId(), build.getName(),
						notes, false, "", platform.getId(), platform.getName(),
						null, false);
				Execution e = api.getLastExecutionResult(testPlan.getId(),
						testCaseId, testCaseExternalId);
				File file = new File(filePath);
				String fileContent = null;
				byte[] byteArray = FileUtils.readFileToByteArray(file);
				fileContent = new String(Base64.encodeBase64(byteArray));
				api.uploadExecutionAttachment(e.getId(), "Screenshot",
						notes, file.getName(), "image/png", fileContent);
				System.out.println("update result and attactment to test link success");
				System.out.println("----------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
