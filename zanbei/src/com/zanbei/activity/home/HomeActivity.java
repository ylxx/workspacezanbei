package com.zanbei.activity.home;

import com.zanbei.R;
import com.zanbei.activity.BaseFragmentActivity;
import com.zanbei.activity.login.LoginActivity;
import com.zanbei.utils.ClickUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends BaseFragmentActivity {

	private Button btLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentViewWithActionBar(R.layout.activity_home, "赞呗");
		//设置通知栏颜色
		initSystemBarTint(Color.parseColor("#aaaaaaaa"));
		
		inttview();
		
	}

	
	private void inttview() {
		btLogin = (Button) findViewById(R.id.bt_tologin);
		
		
		ClickUtil.setClickListener(listener, btLogin);
		
	}
	
	/**
	 * 监听事件
	 * 
	 */
	private OnClickListener listener=new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.bt_tologin:
				startActivity(new Intent(HomeActivity.this,LoginActivity.class));
				break;

			default:
				break;
			}
			
		}
		
	};

}
