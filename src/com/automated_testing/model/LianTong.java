package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.AbstractPhoneNumber;
import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.each.CTliantong;

public class LianTong extends Phone{
	Map<String, PhoneNumber> elements = new HashMap<String, PhoneNumber>();

	public PhoneNumber getElementBySourceAdress(String sourceAdress) {
		return elements.get(sourceAdress);
	}

	public LianTong() {
		AbstractPhoneNumber ct = new AbstractPhoneNumber("PhoneNumber");
		elements.put("+8618302444316", ct);
		
	}
}
