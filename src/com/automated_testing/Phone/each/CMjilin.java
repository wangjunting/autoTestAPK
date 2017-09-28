package com.automated_testing.Phone.each;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.automated_testing.Phone.AbstractPhoneNumber;

public class CMjilin extends AbstractPhoneNumber{
	
	private String code;

	public CMjilin(String phoneNumber) {
		super(phoneNumber);
	}
	
	@Override
	public String getCode(String content) {
		String regex = ":[\\d]{4,6}"; 
		Pattern pat = Pattern.compile(regex);
		Matcher match = pat.matcher(content);
		if(match.find()){
			code = match.group();
			code = code.substring(1);
		}
		return code;
	}
	
	

}