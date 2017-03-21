package com.zeptsoft.myshopping.log;

import android.util.Log;

public class LogUtils {
	

	private static final String tag = "myShopping";
	
	public static void d(String message){
		Log.d(tag, message);
	}
	
	public static void w(String message){
		Log.w(tag, message);
	}
	
	public static void e(String message, Throwable e){
		Log.e(message, message, e);
	}
	
	public static void wtf(String message, Throwable e){
		Log.wtf(tag, message, e);
	}

}
