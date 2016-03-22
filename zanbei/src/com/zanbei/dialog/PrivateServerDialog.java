package com.zanbei.dialog;

import com.zanbei.R;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


public class PrivateServerDialog extends AlertDialog implements
		android.view.View.OnClickListener {
	private View view;
	public TextView title;
	public WebView content;
	public Button cancel;
	private LayoutInflater inflater;

	public PrivateServerDialog(Context context) {
		super(context);
		inflater = LayoutInflater.from(context);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Window dialogWindow = getWindow();
		WindowManager m = dialogWindow.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = getWindow().getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
		p.width = (int) (d.getWidth() * 0.72); // 宽度设置为屏幕的0.6
		p.x = 0;
		p.y = 0;
		// p.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG;
		dialogWindow.setAttributes(p);

		// LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
		// LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		// params.setMargins(770, 770, 770, 770);
		// this.addContentView(view, params);
		view = inflater.inflate(R.layout.dialog_private_server, null);
		setContentView(view);

//		content = (WebView) view.findViewById(R.id.server_content);
		title = (TextView) view.findViewById(R.id.server_title);
		cancel = (Button) view.findViewById(R.id.dialog_cancel);
		cancel.setOnClickListener(this);
	}

	// public TextView setContent(String msg, boolean isTrue, boolean isOne) {
	// if (isTrue) {
	// content.setTextColor(Color.BLACK);
	// } else {
	// content.setTextColor(Color.RED);
	// }
	// if (isOne) {
	// cancel.setVisibility(View.GONE);
	// }
	// content.setText(msg);
	// return sure;
	// }

	// public TextView setContent(String str) {
	// content.setText(str);
	// return content;
	// }

	public TextView setTitle(String str) {
		title.setText(str);
		return title;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.dialog_cancel) {
			this.dismiss();
		}
	}

}
