package com.automated_testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.automated_testing.Phone.AbstractPhoneNumber;
import com.automated_testing.Phone.PhoneNumber;
import com.automated_testing.Phone.Token;
import com.automated_testing.model.Phone;
import com.automated_testing.model.phoneFactory;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.telephony.SmsMessage;
import android.widget.Toast;

/***
 * 广播接收
 * 
 * @author Administrator
 * 
 */
@SuppressLint("SimpleDateFormat")
public class SMSReceiver extends BroadcastReceiver {

	// 将连个byte数组相加，返回得到的两个数组的和
	public static byte[] getMergeBytes(byte[] pByteA, byte[] pByteB) {
		int aCount = pByteA.length;
		int bCount = pByteB.length;
		byte[] b = new byte[aCount + bCount];
		for (int i = 0; i < aCount; i++) {
			b[i] = pByteA[i];
		}
		for (int i = 0; i < bCount; i++) {
			b[aCount + i] = pByteB[i];
		}
		return b;
	}

	// 解析GSM或者CDMA类型的短信
	private static SmsMessage createFromPdu(byte[] pdu, String className)
			throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		Class<?> clazz = Class.forName(className);
		Object object = clazz.getMethod("createFromPdu", byte[].class).invoke(
				clazz.newInstance(), pdu);
		if (null != object) {
			Constructor<?> constructor = SmsMessage.class
					.getDeclaredConstructor(Class
							.forName("com.android.internal.telephony.SmsMessageBase"));
			constructor.setAccessible(true);
			return (SmsMessage) constructor.newInstance(object);
		} else {
			return null;
		}
	}

	// 通过Java反射机制解析GSM类型的短信
	private static SmsMessage createFromPduGsm(byte[] pdu)
			throws SecurityException, IllegalArgumentException,
			ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		return createFromPdu(pdu,
				"com.android.internal.telephony.gsm.SmsMessage");
	}

	// 解析CDMA类型的短信
	private static SmsMessage createFromPduCdma(byte[] pdu)
			throws SecurityException, IllegalArgumentException,
			ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		return createFromPdu(pdu,
				"com.android.internal.telephony.cdma.SmsMessage");
	}

	// TelephonyManager mTelephonyMgr = MainActivity.mTelephonyMgr;
	/** 接收 */
	@SuppressWarnings("unused")
	public void onReceive(Context context, Intent intent) {
		
		// 判断是系统短信；
		System.out.println(intent.getAction());
		if (intent.getAction()
				.equals("android.provider.Telephony.SMS_RECEIVED")) {

			// 不再往下传播；
			// this.abortBroadcast();
			phoneFactory pFactory = new phoneFactory();
			Phone phone = pFactory.getPhoneByToken(Token.JILIN);
			AbstractPhoneNumber phoneNumber = null;
			StringBuffer sb = new StringBuffer();
			String sender = null;
			String content = "";

			// 通过pdus获得接收到的所有短信消息，获取短信内容；
			Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
			String senderNumber = "";
			byte[] allPdu = null;
			for (Object p : pdus) {
				byte[] pdu = (byte[]) p;
				try {
					SmsMessage message;
					// message = createFromPduGsm((byte[]) pdu);
					// if (null == message) {
					// message = createFromPduCdma((byte[]) pdu);
					// }
					if ("GSM".equals(intent.getStringExtra("from"))) { // 适配MOTO
																		// XT800双卡双待手机
						message = createFromPduGsm(pdu);
					} else if ("CDMA".equals(intent.getStringExtra("from"))) { // 适配MOTO
																				// XT800双卡双待手机
						message = createFromPduCdma(pdu);
					} else {
						message = SmsMessage.createFromPdu(pdu); // 系统默认的解析短信方式
					}
					if (message.getOriginatingAddress() == null) {
						message = createFromPduGsm((byte[]) pdu);
						if (message.getOriginatingAddress() == null)
							message = createFromPduCdma((byte[]) pdu);
					}
					senderNumber = message.getOriginatingAddress();
					phoneNumber = (AbstractPhoneNumber) phone.getElementBySourceAdress(senderNumber);
					if(phoneNumber==null){
						return;
					}
					content += message.getMessageBody();
					
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}
			 System.out.print(content);
			 String code  = phoneNumber.getCode(content);
			 if("".equals(code)||code==null){
				 return;
			 }
			Intent server = new Intent(MyApplication.getContext(),
					LocalService.class);
			server.putExtra("code", code);
			server.putExtra("phoneNumber", phoneNumber.getPhoneNumber());
			MyApplication.getContext().startService(server);
			Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();

		}
	}

}
