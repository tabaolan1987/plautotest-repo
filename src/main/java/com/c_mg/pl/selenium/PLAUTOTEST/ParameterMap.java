package com.c_mg.pl.selenium.PLAUTOTEST;

import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class ParameterMap {
	
	private static  HashMap<String, String> params;

	public static void setupParam(String pre){
		System.out.println("data from test link : " + pre);
		params = new HashMap<String, String>();
		try {
			Elements els = Jsoup.parse(pre).getElementsByTag("p");
			for(Element el : els){
				String param = el.text();
				String key = param.split("=")[0];
				String value = param.split("=")[1];
				System.out.println("key : " + key  + " - value = " + value );
				params.put(key, value);
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		String value = "";
		try {
			 value = params.get(key).toString();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println("get value for key : " + key + " = " + value);
		return value;
	}
	
}
