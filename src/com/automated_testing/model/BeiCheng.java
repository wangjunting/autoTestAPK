package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.AbstractPhoneNumber;
import com.automated_testing.Phone.PhoneNumber;

public class BeiCheng extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public BeiCheng() {
		AbstractPhoneNumber cm = new AbstractPhoneNumber("PhoneNumber");
		AbstractPhoneNumber ct = new AbstractPhoneNumber("PhoneNumber");
		elements.put("10086", cm);
		elements.put("10001", ct);
		
	}
}
