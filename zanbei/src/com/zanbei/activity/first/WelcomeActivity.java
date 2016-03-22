package com.zanbei.activity.first;

import com.zanbei.R;
import com.zanbei.R.id;
import com.zanbei.R.layout;
import com.zanbei.R.menu;
import com.zanbei.activity.home.HomeActivity;
import com.zanbei.activity.logo.LogoActivity;
import com.zanbei.utils.SPUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class WelcomeActivity extends Activity {

	private ImageView ivWelcome;
	private Animation anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		ivWelcome = (ImageView) findViewById(R.id.welcome_bg);
		anim = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.fade);
		ivWelcome.setAnimation(anim);
		anim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub

				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {

						boolean isUsed=(Boolean) SPUtils.get(WelcomeActivity.this, "isUsed", false);
						if (isUsed) {
							System.out.println("11111111111111111");
							Toast.makeText(WelcomeActivity.this, "11111111111111111", 1).show();
							startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
							finish();
						} else {
							SPUtils.put(WelcomeActivity.this, "isUsed", true);
							startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
							System.out.println("2222222222222222");
							Toast.makeText(WelcomeActivity.this, "2222222222222222", 1).show();
							startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
							finish();
						}
					}
				}, 0);
			}
		});
	}

}
