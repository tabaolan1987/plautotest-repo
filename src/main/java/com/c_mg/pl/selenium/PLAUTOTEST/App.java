package com.c_mg.pl.selenium.PLAUTOTEST;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;



/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] acg) throws UnsupportedEncodingException{
		String simple  = "%2Fdropboxes%3Fpath%3Dcmg%252F%255B%255D%257B%257D%25C2%25A3%2524%2500%25C2%25AC%2Bmy%2Btest.txt";
		simple = URLDecoder.decode(simple);
		simple = simple.replace("+", "%20");
		System.out.println(simple);
		
	}
}
