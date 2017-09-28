package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CManhui;
import com.automated_testing.Phone.each.CMzhejiang;
import com.automated_testing.Phone.each.CTanhui;
import com.automated_testing.Phone.each.CTzhejiang;

public class ZheJiang extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public ZheJiang() {
		CMzhejiang cm = new CMzhejiang("PhoneNumber");
		CTzhejiang ct = new CTzhejiang("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
	}
}
