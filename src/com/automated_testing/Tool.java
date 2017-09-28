package com.automated_testing;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

import android.util.Log;

public class Tool {
	
	public static JSONArray array = null;
	private final static String configPath = "data/config.js";
	
	public static  String do_post(final String path) {
		String body = "";

		try {
			// 1.
			// ���һ���൱�����������HttpClient��ʹ������ӿڵ�ʵ��������������DefaultHttpClient
			HttpClient hc = new DefaultHttpClient();
			// DoPost��ʽ�����ʱ���������󣬹ؼ���·��
			HttpPost request = new HttpPost(path);
			// 2. Ϊ�����������������Ҳ���ǽ�Ҫ�ϴ���web�������ϵĲ���
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			// ����ʵ��HttpEntityҲ��һ���ӿڣ�����������ʵ����UrlEncodedFormEntity����������ע�����һ��String���͵Ĳ���������ָ�������
			HttpEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");

			request.setEntity(entity);
			// 3. ִ������
			HttpResponse response = hc.execute(request);
			// 4. ͨ�����������ж�����ɹ����
			HttpEntity entity_response = response.getEntity();
			body = EntityUtils.toString(entity_response);
		} catch (Exception e) {
			System.out.println("shibai");
			System.out.println(e);
			e.printStackTrace();
		}

		return body;

	}
	
	//�������ļ���ϢתΪjson����
	public static void getArray() {
		String json = readText(configPath);
		if (json != null && json.length() > 1) {
			json = json.replace("\t", "").replace("\n", "").replace("\r", "");
			try {
				array = new JSONArray(json);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	//ƥ��������ݺ����õ��ļ�����
	public  String []  match(String content,String senderNumber) {
		if (array == null) {
			getArray();
		}
		int size = array.length();
		for (int i = 0; i < size; i++) {
			try {
				JSONObject jso = array.getJSONObject(i);
				String source = jso.getString("senderNumber");
				String phone = "";
				if(source.equals(senderNumber)||senderNumber.indexOf(source)!=-1){
					phone = jso.getString("phone");
					String match = jso.getString("match");
					if (content.indexOf(match) > -1) {
						String num = jso.getString("num");
						String code = getPhoneAndNum(num, content);
						String phoneAndCode []  = {phone,code} ;
						return phoneAndCode;
					}
				}
			} catch (JSONException e) {
				System.out.println("��ȡjson����ʧ��!!");
				e.printStackTrace();
			}

		}
		return null;
	}
	
	public  String  getPhoneAndNum(String num,String content){
		String code = "";
		String regex = "[\\da-zA-Z]{"+num+"}"; 
		Pattern pat = Pattern.compile(regex);
		Matcher match = pat.matcher(content);
		if(match.find()){
			code = match.group();
		}
		return code;
	}
	
	//��ȡ�����ļ�
	private static String readText (String path){
		InputStream input = null;
		try {
			input = MyApplication.getContext().getResources().getAssets()
					.open(path);
		} catch (IOException e1) {
			System.out.println("�ļ�config.js��ʧ��");
			e1.printStackTrace();
		}
		InputStreamReader reader = new InputStreamReader(input);
		char[] buffer = new char[1024];
		StringBuilder strb = new StringBuilder();
		int len = 1;
		try {
			while (reader.read(buffer, 0, buffer.length - 1) != -1) {
				strb.append(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String json = strb.toString();
		return json;
	}
}
