package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends Activity implements
		View.OnClickListener {
	private static final String TAG = "liutz";
	private ViewFlipper vp = null;
	private Button pre = null;
	private Button auto = null;
	private Button nxt = null;

	/** Called when the activity is first created. */
	private TextView tv1, tv2, tv3, tv4, tv5;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		vp = (ViewFlipper) findViewById(R.id.flipper);

		pre = (Button) findViewById(R.id.pre);
		pre.setOnClickListener(btnClickListener);

		auto = (Button) findViewById(R.id.auto);
		auto.setOnClickListener(btnClickListener);

		nxt = (Button) findViewById(R.id.nxt);
		nxt.setOnClickListener(btnClickListener);

		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv4 = (TextView) findViewById(R.id.tv4);
		tv5 = (TextView) findViewById(R.id.tv5);
		
		tv1.setOnClickListener(this);
		tv2.setOnClickListener(this);
		tv3.setOnClickListener(this);
		tv4.setOnClickListener(this);
		tv5.setOnClickListener(this);
	}

	private OnClickListener btnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (pre.getId() == v.getId()) {
				vp.showPrevious();
			} else if (auto.getId() == v.getId()) {
				vp.startFlipping();
			} else if (nxt.getId() == v.getId()) {
				vp.showNext();
			}

		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv1:
			Log.d(TAG,"TV1");
			break;
		case R.id.tv2:
			Log.d(TAG,"TV2");
			break;
		case R.id.tv3:
			Log.d(TAG,"TV3");
			break;
		case R.id.tv4:
			Log.d(TAG,"TV4");
			break;
		case R.id.tv5:
			Log.d(TAG,"TV5");
			break;

		default:
			break;
		}

	}
}