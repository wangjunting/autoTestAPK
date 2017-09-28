package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CMsichuan;
import com.automated_testing.Phone.each.CTsichuan;

public class SiChuan extends Phone {
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public SiChuan() {
		CMsichuan cm = new CMsichuan("PhoneNumber");
		CTsichuan ct = new CTsichuan("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
	}
}
