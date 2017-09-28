package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMguangdong;
import com.automated_testing.Phone.each.CTguangdong;

public class GuangDong extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public GuangDong() {
		CMguangdong cm = new CMguangdong("PhoneNumber");
		CTguangdong ct = new CTguangdong("PhoneNumber");
		elements.put("10086123", cm);
		elements.put("10001", ct);
	}
}
