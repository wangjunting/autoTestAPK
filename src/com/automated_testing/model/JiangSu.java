package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

import com.automated_testing.Phone.each.CMjiangsu;

import com.automated_testing.Phone.each.CTjiangsu;

public class JiangSu extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public JiangSu() {
		CMjiangsu cm = new CMjiangsu("PhoneNumber");
		
		elements.put("10086", cm);
		
	}
}
