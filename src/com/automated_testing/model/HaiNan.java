package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMhainan;
import com.automated_testing.Phone.each.CThainan;

public class HaiNan extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public HaiNan() {
		CMhainan cm = new CMhainan("PhoneNumber");
		CThainan ct = new CThainan("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}