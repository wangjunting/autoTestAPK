package com.automated_testing;

import android.database.ContentObserver;
import android.os.Handler;

public class SMSContent extends ContentObserver{

	public SMSContent(Handler handler) {
		super(handler);
	}
	@Override
	public void onChange(boolean selfChange){
		System.out.println("changed.....");
	}
	
}
