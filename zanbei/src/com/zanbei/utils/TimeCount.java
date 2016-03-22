package com.zanbei.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;
/**
 * 
 *	发送验证码时间管理
 *
 */
public class TimeCount  extends CountDownTimer{
	private TextView mTimeShower = null;
	private boolean clickable;
	public TimeCount(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onFinish() {
		// 计时完毕时触发
		clickable = true;
		mTimeShower.setClickable(clickable);
		mTimeShower.setBackgroundColor(Color.parseColor("#6DD4FD"));
		mTimeShower.setText("重新发送");
	}

	@Override
	public void onTick(long arg0) {
		// 计时过程显示
		clickable = false;
		mTimeShower.setClickable(clickable);
		mTimeShower.setBackgroundColor(Color.parseColor("#C6C6C6"));
		mTimeShower.setText("重新发送"+"("+arg0/ 1000+"s)");
	}

	public void setTextView(TextView t) {
		mTimeShower = t;
	}

}
