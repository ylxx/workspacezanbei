package com.zanbei.dialog;

import com.zanbei.R;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;


public class PayBackDialog extends AlertDialog {
	private View view;
	private TextView content;
	public Button right, left;

	public PayBackDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		LayoutInflater inflater = LayoutInflater.from(context);
		view = inflater.inflate(R.layout.dialog_add_data, null);
		content = (TextView) view.findViewById(R.id.dialog_content);
		right = (Button) view.findViewById(R.id.dialog_sure);
		left = (Button) view.findViewById(R.id.dialog_cancel);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		this.addContentView(view, params);
	}

	public TextView setContent(String str, String leftbt, String rightbt) {
		if (TextUtils.isEmpty(rightbt)) {
			// findViewById(R.id.iv_xiaohengxian).setVisibility(View.GONE);
			right.setVisibility(View.GONE);
		} else {
			right.setText(rightbt);
		}
		if (TextUtils.isEmpty(leftbt)) {
			// findViewById(R.id.iv_hengxian).setVisibility(View.GONE);
			left.setVisibility(View.GONE);
		} else {
			left.setText(leftbt);
		}
		content.setText(str);
		return content;
	}

}
