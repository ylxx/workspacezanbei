package com.zanbei.dialog;

import com.zanbei.R;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;


public class AddDataDialog extends AlertDialog implements
		android.view.View.OnClickListener {
	private View view;
	private TextView content;
	public Button sure, cancel;
	private LayoutInflater inflater;

	public AddDataDialog(Context context) {
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
		p.width = (int) (d.getWidth() * 0.72); // 宽度设置为屏幕的0.6
		p.x = 0;
		p.y = 0;
//		p.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG;
		dialogWindow.setAttributes(p);
		view = inflater.inflate(R.layout.dialog_add_data, null);
		// LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
		// LayoutParams.WRAP_CONTENT);
		
		
		setContentView(view);
		content = (TextView) view.findViewById(R.id.dialog_content);
		sure = (Button) view.findViewById(R.id.dialog_sure);
		cancel = (Button) view.findViewById(R.id.dialog_cancel);
		cancel.setOnClickListener(this);
		
	}

//	public TextView setContent(String msg, boolean isTrue, boolean isOne) {
//		if (isTrue) {
//			content.setTextColor(Color.BLACK);
//		} else {
//			content.setTextColor(Color.RED);
//		}
//		if (isOne) {
//			cancel.setVisibility(View.GONE);
//		}
//		content.setText(msg);
//		return sure;
//	}
	
	
	public TextView setContent(String str){
		content.setText(str);;
		return content;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.dialog_cancel) {
			this.dismiss();
		}
	}

}
