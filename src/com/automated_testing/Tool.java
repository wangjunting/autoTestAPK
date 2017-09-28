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
			// 获得一个相当于浏览器对象HttpClient，使用这个接口的实现类来创建对象，DefaultHttpClient
			HttpClient hc = new DefaultHttpClient();
			// DoPost方式请求的时候设置请求，关键是路径
			HttpPost request = new HttpPost(path);
			// 2. 为请求设置请求参数，也即是将要上传到web服务器上的参数
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			// 请求实体HttpEntity也是一个接口，我们用它的实现类UrlEncodedFormEntity来创建对象，注意后面一个String类型的参数是用来指定编码的
			HttpEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");

			request.setEntity(entity);
			// 3. 执行请求
			HttpResponse response = hc.execute(request);
			// 4. 通过返回码来判断请求成功与否
			HttpEntity entity_response = response.getEntity();
			body = EntityUtils.toString(entity_response);
		} catch (Exception e) {
			System.out.println("shibai");
			System.out.println(e);
			e.printStackTrace();
		}

		return body;

	}
	
	//将配置文件信息转为json数组
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
	//匹配短信内容和配置的文件内容
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
				System.out.println("获取json对象失败!!");
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
	
	//读取配置文件
	private static String readText (String path){
		InputStream input = null;
		try {
			input = MyApplication.getContext().getResources().getAssets()
					.open(path);
		} catch (IOException e1) {
			System.out.println("文件config.js打开失败");
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
