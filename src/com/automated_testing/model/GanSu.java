package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

import com.automated_testing.Phone.each.CTgansu;

public class GanSu extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public GanSu() {
		
		CTgansu ct = new CTgansu("PhoneNumber");
	
		elements.put("10001", ct);
		
	}
}