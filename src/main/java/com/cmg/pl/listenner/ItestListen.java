package com.cmg.pl.listenner;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testlink.api.java.client.TestLinkAPIClient;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;


public class ItestListen implements ITestListener {
	
	boolean recordRunning = false;
	
	public void onTestSuccess(ITestResult result) {
		//Constant.putValue(result.getName(), TestLinkAPIClient.TEST_PASSED);
		/*try {
			if(recordRunning){
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onTestFailure(ITestResult result) {
		//Constant.putValue(result.getName(), result.getThrowable().getMessage());
		try {
			TakeScreenShot.takeSnapShot(result.getName());
		} catch (Exception e) {
		}
	
		/*try {
			if(recordRunning){
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onTestSkipped(ITestResult result) {
		try {
			TakeScreenShot.takeSnapShot(result.getName());
		} catch (Exception e) {
		}
	
		/*try {
			if(recordRunning){
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onFinish(ITestContext context) {

	}

	public void onTestStart(ITestResult result) {
		//String testcase = result.getName();
		//if(!Constant.existedInMap(testcase)){
			//Constant.mapContainer.put(testcase, "");
		//}
	/*	if(DriverUtil.browserRunning.equalsIgnoreCase("test")){
			String name = DriverUtil.browserRunning+"-"+ result.getName();
			try {
				record = new ScreenRecord();
				record.startRecording(name);
				recordRunning = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("---------------------------"+context.getName()+"-------------------------------------");
	}



}
