package com.automated_testing.Phone.each;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.automated_testing.Phone.AbstractPhoneNumber;

public class CTsichuan extends AbstractPhoneNumber{
	
	private String code; 
	public CTsichuan(String phoneNumber) {
		super(phoneNumber);
	}
	public String getCode(String content) {
		String regex = "��[\\d]{6}"; 
		Pattern pat = Pattern.compile(regex);
		Matcher match = pat.matcher(content);
		if(match.find()){
			code = match.group();
			code = code.substring(1);
		}
		return code;
	}

}
