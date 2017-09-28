package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CManhui;
import com.automated_testing.Phone.each.CMshanxi;
import com.automated_testing.Phone.each.CTanhui;
import com.automated_testing.Phone.each.CTshanxi;

public class ShanXi extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public ShanXi() {
		CMshanxi cm = new CMshanxi("PhoneNumber");
		CTshanxi ct = new CTshanxi("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}
