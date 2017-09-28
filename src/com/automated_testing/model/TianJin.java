package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMtianjin;
import com.automated_testing.Phone.each.CTtianjin;

public class TianJin extends Phone{
	
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public TianJin() {
		CMtianjin cm = new CMtianjin("PhoneNumber");
		CTtianjin ct = new CTtianjin("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}