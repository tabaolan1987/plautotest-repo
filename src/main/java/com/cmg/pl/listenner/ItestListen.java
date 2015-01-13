package com.cmg.pl.listenner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



import br.eti.kinoshita.testlinkjavaapi.model.ExecutionStatus;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.c_mg.pl.selenium.PLAUTOTEST.ParameterMap;
import com.c_mg.pl.selenium.PLAUTOTEST.ScreenRecord;
import com.c_mg.pl.selenium.PLAUTOTEST.TMTAction;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;

public class ItestListen implements ITestListener {

	boolean recordRunning = false;

	ScreenRecord record;

	public void onTestSuccess(ITestResult result) {
		/*try {
			if (recordRunning) {
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String browser = DriverUtil.browserRunning;
		ExecutionStatus ex = ExecutionStatus.getExecutionStatus('P');
		System.out.println("update result to test link : " + " platform : "
				+ browser + "- testcase :  " + result.getName() + " PASSED");
		TMTAction action = new TMTAction();
		action.updateResultToTestLink(result, ex, browser, "");
	}

	public void onTestFailure(ITestResult result) {
		String filePath = "";
		try {
			filePath = TakeScreenShot.takeSnapShot(result.getName());
		} catch (Exception e) {
		}

		String browser = DriverUtil.browserRunning;
		ExecutionStatus ex = ExecutionStatus.getExecutionStatus('F');
		System.out.println("update result to test link : " + " platform : "
				+ browser + "- testcase :  " + result.getName() + " FAIL");
		TMTAction action = new TMTAction();
	/*	action.updateResultToTestLinkWithAttactment(result, ex, browser, result
				.getThrowable().getMessage(), filePath);*/

		try {
			if (recordRunning) {
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String filePath = "";
		try {
			filePath = TakeScreenShot.takeSnapShot(result.getName());
		} catch (Exception e) {
		}
		String browser = DriverUtil.browserRunning;
		ExecutionStatus ex = ExecutionStatus.getExecutionStatus('B');
		System.out.println("update result to test link : " + " platform : "
				+ browser + "- testcase :  " + result.getName() + " Not Run");
		TMTAction action = new TMTAction();
		action.updateResultToTestLinkWithAttactment(result, ex, browser, result
				.getThrowable().getMessage(), filePath);
/*
		try {
			if (recordRunning) {
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onFinish(ITestContext context) {

	}

	public void onTestStart(ITestResult result) {
		/*String name = DriverUtil.browserRunning + "-" + result.getName();
		try {
			record = new ScreenRecord();
			record.startRecording(name);
			recordRunning = true;
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		TMTAction ac = new TMTAction();
		String pre = ac.getPreconditionsOfTestCase(result.getName().trim(),Constant.SUITE_NAME);
		System.out.println("coming set value for parametere");
		ParameterMap.setupParam(pre);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("---------------------------" + context.getName()
				+ "-------------------------------------");
	}

}
