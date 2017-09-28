package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

import com.automated_testing.Phone.each.CMneimenggu;

import com.automated_testing.Phone.each.CTneimenggu;

public class NeiMengGu extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public NeiMengGu() {
		CMneimenggu cm = new CMneimenggu("PhoneNumber");
		CTneimenggu ct = new CTneimenggu("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}
