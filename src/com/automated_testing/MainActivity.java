package com.automated_testing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity{

	SMSContent smsContent = new SMSContent(new Handler());  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("on Create!!!");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onStart() {
		System.out.println("on Start!!!");
		super.onStart();
	}
}
