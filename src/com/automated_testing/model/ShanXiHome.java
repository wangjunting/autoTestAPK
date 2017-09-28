package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;

import com.automated_testing.Phone.each.CMshanxihome;

import com.automated_testing.Phone.each.CTshanxihome;

public class ShanXiHome extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public ShanXiHome() {
		CMshanxihome cm = new CMshanxihome("PhoneNumber");
		CTshanxihome ct = new CTshanxihome("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}