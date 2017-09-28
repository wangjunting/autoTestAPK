package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMguangxi;
import com.automated_testing.Phone.each.CTguangxi;


public class GuangXi extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public GuangXi() {
		CMguangxi cm = new CMguangxi("PhoneNumber");
		CTguangxi ct = new CTguangxi("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}