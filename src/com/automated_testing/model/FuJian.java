package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

import com.automated_testing.Phone.each.CMfujian;

import com.automated_testing.Phone.each.CTfujian;

public class FuJian extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public FuJian() {
		
		CTfujian ct = new CTfujian("PhoneNumber");
		
		elements.put("10001", ct);
	}
}
