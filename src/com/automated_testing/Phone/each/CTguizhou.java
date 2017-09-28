package com.automated_testing.Phone.each;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.automated_testing.Phone.AbstractPhoneNumber;

public class CTguizhou extends AbstractPhoneNumber{

	private String code ;
	
	public CTguizhou(String phoneNumber) {
		super(phoneNumber);
	}
	
	@Override
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