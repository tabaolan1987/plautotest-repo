package com.cmg.pl.listenner;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;


public class ItestListen implements ITestListener {
	
	//private static ScreenRecord record;
	
	public void onTestSuccess(ITestResult result) {
		/*try {
			record.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onTestFailure(ITestResult result) {
		TakeScreenShot.takeSnapShot(result.getName());
		/*try {
			record.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onTestSkipped(ITestResult result) {
		TakeScreenShot.takeSnapShot(result.getName());
		/*try {
			record.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onFinish(ITestContext context) {

	}

	public void onTestStart(ITestResult result) {
		String name = DriverUtil.browserRunning+"-"+ result.getName();
		/*try {
			record = new ScreenRecord();
			record.startRecording(name);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}



}
