/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015年11月20日16:39:01 
 * 
 *******************************************************************************/ 
package com.zanbei.utils;

import android.util.Log;

 
 
/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015年11月20日16:38:54
 * 作者:	DC
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class Logge {
	private static final String TAG = "GUOLIANZICHAN";
	private static boolean flag = true;
   //打印日志 
	public static void LogE(String msg) {
		if (flag) {
			Log.e(TAG, msg);
		}
	}
	//描述状态
	public static void LogD(String msg){
		if(flag){
			Log.e(TAG, msg);
		}
	}
	public static void LogI(String msg) {
		if (flag) {
			Log.i(TAG, msg);
		}
	}
}
