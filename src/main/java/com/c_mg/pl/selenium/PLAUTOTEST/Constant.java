package com.c_mg.pl.selenium.PLAUTOTEST;

import java.util.HashMap;
import java.util.Map;

import testlink.api.java.client.TestLinkAPIClient;

/**
 * @author lantb
 * 
 */
public class Constant {

	/**
	 * URL for PROD
	 */
	public static String URL = "https://pensionline.bp.com/";

	public static String main_url = "https://pensionline.bp.com/content/pl";

	public static int SMALL_WAITING_TIME = 10;

	public static int NORMAL_WAITING_TIME = 40;

	public static int LONG_WAITING_TIME = 80;

	public static int PAGE_LOAD_TIMEOUT = 500;

	/**
	 * URL for INT
	 */
	/* public static String URL = "https://plw1-int.bppensions.com/"; */

	/**
	 * URL for DEV
	 */
	/* public static String URL = ""; */

	public static String API_KEY_TESTLINK = "a3d6ac381f1769d63ff13044f441777a";

	// Substitute your Server URL Here
	public static String SERVER_URL = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

	// Substitute your project name Here
	public static String PROJECT_NAME = "PENSIONLINE";
	
	// Substitute your test plan Here
	public static String PLAN_NAME = "Automation Daily Test";
	
	// Substitute your build name
	public static String BUILD_NAME = "build one";

	
	public static HashMap<String, String> mapContainer;
	
	
	public static boolean existedInMap(String testcasename){
		boolean existed = false;
		try {
			for (Map.Entry<String, String> entry : mapContainer.entrySet()) {
				String key = entry.getKey();
				if(key.equalsIgnoreCase(testcasename)){
					existed = true;
					break;
				}
			}
		} catch (Exception e) {
		}
		return existed;
	}
	
	public static void putValue(String testcaseName, String value){
		try {
			for (Map.Entry<String, String> entry : mapContainer.entrySet()) {
				String key = entry.getKey();
				if(key.equalsIgnoreCase(testcaseName)){
					String entryValue = entry.getValue();
					if(entryValue.contains(TestLinkAPIClient.TEST_FAILED)){
						String newVl = entryValue + ";" + value;
						mapContainer.put(testcaseName, newVl);
					}else{
						mapContainer.put(testcaseName, value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateStatusToTestLink(){
		TestLinkUtil testlink = new TestLinkUtil();
		try {
			for (Map.Entry<String, String> entry : mapContainer.entrySet()) {
				String testcaseName = entry.getKey();
				String result = entry.getValue();
				if(result.equalsIgnoreCase(TestLinkAPIClient.TEST_PASSED)){
					testlink.updateTestLinkResult(testcaseName, "", TestLinkAPIClient.TEST_PASSED);
				}else{
					testlink.updateTestLinkResult(testcaseName, result, TestLinkAPIClient.TEST_FAILED);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
