package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMguizhou;
import com.automated_testing.Phone.each.CTguizhou;

public class GuiZhou extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public GuiZhou() {
		CMguizhou cm = new CMguizhou("PhoneNumber");
		CTguizhou ct = new CTguizhou("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}