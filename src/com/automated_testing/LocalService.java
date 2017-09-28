package com.automated_testing;

import org.json.JSONException;
import org.json.JSONObject;

import com.automated_testing.Phone.AbstractPhoneNumber;
import com.automated_testing.Phone.PhoneNumber;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LocalService extends Service{

	@Override
	public void onCreate() {
		Tool.getArray();
	};
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		
//		System.out.println("server start!!! By Receiver!!!");
		long time = System.currentTimeMillis();
		String phone = intent.getStringExtra("phoneNumber");
		String code = intent.getStringExtra("code");
		String body = "";
		do {
			body = Tool.do_post("http://xx.xx.xx.xx:8080/autoTF/serverapi/smsreciver?phone="
					+ phone + "&code=" + code);
			System.out.println("================"+body+"=======");
		} while (!"OK".equals(body)&&(System.currentTimeMillis() - time)<60000);
		super.onStart(intent, startId);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
