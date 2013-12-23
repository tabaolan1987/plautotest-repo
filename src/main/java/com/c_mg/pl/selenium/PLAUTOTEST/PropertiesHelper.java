/**
 * Copyright (c) CMG Ltd All rights reserved.
 *
 * This software is the confidential and proprietary information of CMG
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with CMG.
 */

package com.c_mg.pl.selenium.PLAUTOTEST;

import java.io.IOException;
import java.util.Properties;

/** 
 * DOCME
 * 
 * @Creator Hai Lu
 * @author $Author$
 * @version $Revision$
 * @Last changed: $LastChangedDate$
 */

public class PropertiesHelper {
	public static final String DEFAULT_PROPERTIES = "system.properties";
	
	private static Properties prod;
	
	public static Properties getProperties() {
		if (prod == null) {
			prod = new Properties();
			try {
				prod.load(PropertiesHelper.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES));
			} catch (IOException e) {				
				//
			}
		}
		return prod;
	}
	
	public static String getKey(String key) {
		Object obj = getProperties().get(key);
		String value = "";
		if (obj != null) 
			value = obj.toString();
		return value;
	}
}
