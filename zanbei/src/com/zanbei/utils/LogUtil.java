package com.zanbei.utils;

import android.util.Log;

/**
 * 作者：dc
 * date:2016年3月4日15:49:21
 * 自定义日志打印工具
 */
public class LogUtil {
	
	public static final int VERBOSE = 1;
	
	public static final int DEBUG = 2;
	
	public static final int INFO = 3;
	
	public static final int WARN = 4;
	
	public static final int ERROR = 5;
	
	public static final int NOTHING = 6;
	
	public static final int LEVEL = VERBOSE;

	public static void v(String tag,String msg){
		if(LEVEL <= VERBOSE){
			Log.v(tag, msg);
		}
	}
	public static void d(String tag,String msg){
		if(LEVEL <= VERBOSE){
			Log.d(tag, msg);
		}
	}
	public static void i(String tag,String msg){
		if(LEVEL <= VERBOSE){
			Log.i(tag, msg);
		}
	}
	public static void w(String tag,String msg){
		if(LEVEL <= VERBOSE){
			Log.w(tag, msg);
		}
	}
	public static void e(String tag,String msg){
		if(LEVEL <= VERBOSE){
			Log.e(tag, msg);
		}
	}
}
