package com.c_mg.pl.selenium.PLAUTOTEST;

import java.util.HashMap;

public class ParameterMap {
	
	private static  HashMap<String, String> params;

	
	public static void setupParam(String pre){
		params = new HashMap<String, String>();
		String[] parameters= pre.split(",");
		for(String param : parameters){
			String key = param.split("=")[0];
			String value = param.split("=")[1];
			System.out.println("key : " + key  + " - value = " + value );
			params.put(key, value);
		}
	}
	
	public static String getValue(String key){
		String value = "";
		try {
			 value = params.get(key).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("get value for key : " + key + " = " + value);
		return value;
	}
	
}
