package edu.gamedemo;



import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int DOWNLOAD_COMPLETED_ACTION = 1;
	private TextView tvTips;
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
				case DOWNLOAD_COMPLETED_ACTION:{
					tvTips.setText("加速器下载完成，正在安装中...");
				}
			}
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		tvTips = (TextView) findViewById(R.id.tips);
		String d = GameUtil.getSerialNumber(this);
		tvTips.setText(GameUtil.getSerialNumber(this));
		ClipboardManager cmb = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);  
		cmb.setText(d);	
		Toast.makeText(this, "复制成功", Toast.LENGTH_LONG).show();
		
	}
	
	public void onJsDownload(View view){
		tvTips.setText("请稍后，正在下载加速器...");
		Uri uri = Uri.parse("http://img.wan.sogou.com/cdn/app/1120252312/wap_wan_421.apk");  
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);  
        startActivity(intent); 
		/*Message msg = new Message();
		msg.what = DOWNLOAD_COMPLETED_ACTION;
		mHandler.sendMessageDelayed(msg, 4000);*/
	}
	
	public void onPtDownload(View view){
		tvTips.setText("请稍后，正在下载游戏...");
		/*Intent intent = new Intent();
		 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 intent.setComponent(new ComponentName("com.sogou.gamemall","com.sogou.gamemall.activitys.SplashActivity"));   
		 intent.setAction(Intent.ACTION_VIEW);   
		 startActivity(intent);*/
	}
	
	
}
