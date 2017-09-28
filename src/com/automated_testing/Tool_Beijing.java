package com.automated_testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool_Beijing extends Tool {
	@Override
	public String getPhoneAndNum(String num, String content) {
		String code = "";
		String regex = ":[\\d]{"+num+"}"; 
		Pattern pat = Pattern.compile(regex);
		Matcher match = pat.matcher(content);
		if(match.find()){
			code = match.group();
			code = code.substring(1);
		}
		return code;
	}
}
