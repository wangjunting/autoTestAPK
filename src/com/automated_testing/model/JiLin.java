package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMjilin;
import com.automated_testing.Phone.each.CTjilin;


public class JiLin extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public JiLin() {
		CMjilin cm = new CMjilin("PhoneNumber");
		CTjilin ct = new CTjilin("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
		
	}
}