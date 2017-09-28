package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CManhui;
import com.automated_testing.Phone.each.CMhebei;
import com.automated_testing.Phone.each.CTanhui;
import com.automated_testing.Phone.each.CThebei;

public class HeBei extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public HeBei() {
		CMhebei cm = new CMhebei("PhoneNumber");
		CThebei ct = new CThebei("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}
