package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

import com.automated_testing.Phone.each.CMningxia;

import com.automated_testing.Phone.each.CTningxia;

public class NingXia extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public NingXia() {
		CMningxia cm = new CMningxia("PhoneNumber");
		CTningxia ct = new CTningxia("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);	
	}
}
