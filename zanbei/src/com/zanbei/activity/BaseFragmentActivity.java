package com.zanbei.activity;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.zanbei.R;
import com.zanbei.application.LangDunApplication;
import com.zanbei.config.Constants;
import com.zanbei.utils.ShowErrorDialogUtil;
import com.zanbei.view.CustomBar;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2016年3月7日10:10:35
 * 作者:	dc
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */

public class BaseFragmentActivity extends FragmentActivity implements
OnClickListener{

	protected FragmentManager mFragmentManager;
	protected FragmentTransaction mFragmentTransaction;

	protected LangDunApplication mApplication;
	protected SharedPreferences userInfo;
	public CustomBar bar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//判断sdk版本.4.4分界，大于则设置状态栏背景一体化
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window win = getWindow();
			WindowManager.LayoutParams winParams = win.getAttributes();
			final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
			winParams.flags |= bits;
			win.setAttributes(winParams);
		}

		mFragmentManager = getSupportFragmentManager();
		mApplication = (LangDunApplication) getApplication();
		userInfo = getSharedPreferences(Constants.INIT_USER_INFO,
				Context.MODE_PRIVATE);

		if(null != savedInstanceState){
			mApplication = (LangDunApplication) getApplication();
			if (savedInstanceState.containsKey("UserLoginInfo")) {
				//				UserLoginVo loginInfo = (UserLoginVo) savedInstanceState
				//						.getSerializable("UserLoginInfo");
				//				mApplication.setUserLoginInfo(loginInfo);
			}
			if (savedInstanceState.containsKey("timeOutOrLoginCrowdOut")) {
				//				DeKuShuApplication.timeOutOrLoginCrowdOut = savedInstanceState
				//						.getBoolean("timeOutOrLoginCrowdOut");
			}
			if (savedInstanceState.containsKey("sessionId")) {
				//				mApplication.setSessionId(savedInstanceState
				//						.getString("sessionId"));
			}
			if (savedInstanceState.containsKey("myAccountBodyVO")) {
				//				mApplication.myAccountBodyVO = (MyAccountBodyVO) savedInstanceState
				//						.getSerializable("myAccountBodyVO");
			}
		}
	}
	//保存数据
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		//		if (null != mApplication.getUserLoginInfo()) {
		//			outState.putSerializable("UserLoginInfo",
		//					mApplication.getUserLoginInfo());
		//		}
		//		outState.putBoolean("timeOutOrLoginCrowdOut",
		//				DeKuShuApplication.timeOutOrLoginCrowdOut);
		//		if (null != mApplication.getSessionId()) {
		//			outState.putString("sessionId", mApplication.getSessionId());
		//		}
		//		if (null != mApplication.myAccountBodyVO) {
		//			outState.putSerializable("myAccountBodyVO",
		//					mApplication.myAccountBodyVO);
		//		}
	};

	protected void showError(int errResource) {
		ShowErrorDialogUtil.showErrorDialog(this, getString(errResource));
	}

	protected void showError(String errStr) {
		ShowErrorDialogUtil.showErrorDialog(this, errStr);
	}

	/**
	 * @Description: 自带titlebar
	 * @param
	 * @return
	 */
	protected void setContentViewWithActionBar(int layoutResID, String title) {
		LayoutInflater inflater = getLayoutInflater();
		ViewGroup contentV = (ViewGroup) inflater.inflate(
				R.layout.activity_base, null);
		inflater.inflate(layoutResID, contentV);
		setContentView(contentV);
		bar = (CustomBar) findViewById(R.id.titlebar);
		bar.ininbar(contentV);
		bar.setTitleBar(title);
		bar.getLeftBar().setOnClickListener(this);
		initSystemBarTint();
	}

	protected void initSystemBarTint() {

		SystemBarTintManager tintManager = new SystemBarTintManager(this);
		tintManager.setStatusBarTintEnabled(true);
		tintManager.setStatusBarTintResource(R.color.title_color);
	}

	protected void initSystemBarTint(int color) {
		SystemBarTintManager tintManager = new SystemBarTintManager(this);
		tintManager.setStatusBarTintEnabled(true);
		//		tintManager.setStatusBarTintResource(color);
		tintManager.setStatusBarTintColor(color);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.left_bar) {
			finish();
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		updateRightBar();
	}

	void updateRightBar() {
		//		ImageView view = (ImageView) getWindow().getDecorView().findViewById(
		//				R.id.pic_my_title);
		//		if (view != null) {
		//			if (LangDunApplication.sApplication.getUserlogininfo() != null
		//					&& DeKuShuApplication.sApplication.getUserlogininfo()
		//							.getUserlogininfo().getMessageCount() != null) {
		//				// 患者
		//				if (Integer.parseInt(DeKuShuApplication.sApplication
		//						.getUserlogininfo().getUserlogininfo()
		//						.getMessageCount()) > 0) {
		//					// 有新消息
		//					view.setImageResource(R.drawable._0000_6_1);
		//				} else {
		//					view.setImageResource(R.drawable._0000_6);
		//				}
		//
		//			}
		//			if (DeKuShuApplication.sApplication.getDoclogbody() != null
		//					&& DeKuShuApplication.sApplication.getDoclogbody()
		//							.getDoclogininfovo().getMessageCount() != null) {
		//				// 医生
		//				if (Integer.parseInt(DeKuShuApplication.sApplication
		//						.getDoclogbody().getDoclogininfovo().getMessageCount()) > 0) {
		//					view.setImageResource(R.drawable._0000_6_1);
		//				} else {
		//					view.setImageResource(R.drawable._0000_6);
		//				}
		//			}
		//		}
	}
	
	private boolean isShowing() {
		boolean result = false;
		ActivityManager am = (ActivityManager) this
				.getSystemService(Context.ACTIVITY_SERVICE);
		ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
		if (cn != null) {
			System.out.println("this.getLocalClassName()::"
					+ this.getLocalClassName());
			System.out.println("cn.getClassName()::" + cn.getClassName());
			if (this.getLocalClassName().equals(cn.getClassName())) {
				result = true;
			}
		}
		return result;
	}

}
