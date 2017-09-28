package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

public class Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();
	 
	 public PhoneNumber getElementBySourceAdress(String sourceAdress) {
			return elements.get(sourceAdress);
		}
}
