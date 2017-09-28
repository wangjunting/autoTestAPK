package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

import com.automated_testing.Phone.each.CMhenan;

import com.automated_testing.Phone.each.CThenan;

public class HeNan extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public HeNan() {
		CMhenan cm = new CMhenan("PhoneNumber");
		CThenan ct = new CThenan("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}

