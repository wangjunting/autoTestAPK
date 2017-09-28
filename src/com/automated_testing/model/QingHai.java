package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

import com.automated_testing.Phone.each.CMqinghai;



public class QingHai extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public QingHai() {
		CMqinghai cm = new CMqinghai("PhoneNumber");
		
		elements.put("10086", cm);
		
		
	}
}
