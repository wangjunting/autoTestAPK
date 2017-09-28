package com.automated_testing.Phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import android.os.Parcel;
import android.os.Parcelable;

public  class AbstractPhoneNumber implements PhoneNumber,Parcelable{

	private String phoneNumber;
	private String code;
	
	public AbstractPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCode(String content) {
		String regex = "[\\d]{6}"; 
		Pattern pat = Pattern.compile(regex);
		Matcher match = pat.matcher(content);
		if(match.find()){
			code = match.group();
		}
		return code;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code) {
		code = code;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}

}
