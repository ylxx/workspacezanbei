package com.zanbei.activity.login;

import java.io.IOException;
import java.util.HashMap;

import com.zanbei.R;
import com.zanbei.activity.BaseFragmentActivity;
import com.zanbei.config.Constants;
import com.zanbei.controller.BaseHandler;
import com.zanbei.controller.RequestCommant;
import com.zanbei.utils.CheckUtil;
import com.zanbei.utils.ClickUtil;
import com.zanbei.utils.SPUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseFragmentActivity {

	private EditText etName,etPw;
	private Button btLogin;
	private String userName,userPw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentViewWithActionBar(R.layout.activity_login,"登陆");

		initview();

	}

	private void initview() {
		etName = (EditText) findViewById(R.id.et_login_name);
		etPw = (EditText) findViewById(R.id.et_login_passw);
		btLogin = (Button) findViewById(R.id.bt_login);

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
			case R.id.bt_login:
				//登陆请求
				confirmLogin();

				break;

			default:
				break;
			}

		}

	};

	//登陆
	private void confirmLogin() {
		userName = etName.getText().toString().trim();
		userPw = etPw.getText().toString().trim();
		//检验
		if (etName.length() == 0) {
			showError("请输入手机号");
			return;
		}
		if (!CheckUtil.isPhoneNum(userName)) {
			showError("请输入正确的手机号码");
			return;
		}
		if (etPw.length() == 0) {
			showError("请输入密码");
			return;
		}
		
		HashMap<String, String> hashmap = new HashMap<String, String>();
		
		hashmap.put("name", etName.getText().toString());
		hashmap.put("password", etPw.getText().toString());
		
		new RequestCommant().requestlogin(new requetHandle(this), this, hashmap); 

	}
	
	
	private class requetHandle extends BaseHandler {
		public requetHandle(Activity activity) {
			super(activity);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			//			LoginActivity activity = (LoginActivity) mActivity.get();
			if (msg.what == Constants.LOGIN) {
				System.out.println(command.success);

				if (command.success) {
					Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

				} else {
					showError((String) command.message);
				}
			}
		}

	}
	
	

}
