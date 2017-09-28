package com.automated_testing;

import android.app.Application;

public class MyApplication extends Application{

	private static MyApplication instance;
	
	
	public static MyApplication getContext(){
		return instance;
	}


	@Override
	public void onCreate() {
		super.onCreate();
		instance=this;
	}
}