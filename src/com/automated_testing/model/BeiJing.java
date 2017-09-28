package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMbeijing;
import com.automated_testing.Phone.each.CTbeijing;

public class BeiJing extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public BeiJing() {
		CMbeijing cm = new CMbeijing("PhoneNumber");
		CTbeijing ct = new CTbeijing("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
	}
}
