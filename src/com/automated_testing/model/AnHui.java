package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CManhui;
import com.automated_testing.Phone.each.CMguangdong;
import com.automated_testing.Phone.each.CTanhui;

public class AnHui extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public AnHui() {
		CManhui cm = new CManhui("18455124496");
		CTanhui ct = new CTanhui("18130381790");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}
