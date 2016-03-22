package com.zanbei.activity.home;

import com.zanbei.R;
import com.zanbei.activity.BaseFragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

public class HomeActivity extends BaseFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		//设置通知栏颜色
		initSystemBarTint(Color.parseColor("#cc0000"));
	}

}
