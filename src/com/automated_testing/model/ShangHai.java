package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CManhui;
import com.automated_testing.Phone.each.CMshanghai;
import com.automated_testing.Phone.each.CTanhui;
import com.automated_testing.Phone.each.CTshanghai;

public class ShangHai extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public ShangHai() {
		CMshanghai cm = new CMshanghai("PhoneNumber");
		CTshanghai ct = new CTshanghai("PhoneNumber");
		elements.put("10658487", cm);
		elements.put("10001", ct);
		
	}
}
