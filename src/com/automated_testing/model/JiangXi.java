package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMjiangxi;


public class JiangXi extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public JiangXi() {
		CMjiangxi cm = new CMjiangxi("PhoneNumber");
		
		elements.put("10086", cm);
		
		
	}
}