package edu.gamedemo;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;

public class GameUtil {
	private static final String TAG = "GameUtil";

	// 生成唯一表示硬件序列号 http://hi.baidu.com/weizi/item/f1d6671030e7e68d88a95638
	public static String getSerialNumber(Context ctx){
		 // androidId 2.2的版本并不是100%可靠
		 String androidId = Secure.getString(ctx.getContentResolver(), Secure.ANDROID_ID);
		 if(androidId == null || "".equals(androidId)){
			 // deviceId也不是100%可靠
			 TelephonyManager tm = (TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE);  
			 String deviceId = tm.getDeviceId();
			 // UUID,但系统清除数据就没有用了
			 if(deviceId == null || "".equals(deviceId)){
				 return MD5.crypt(Installation.id(ctx));
			 }
			 return MD5.crypt(deviceId);			 
		 }
		 return MD5.crypt(androidId);
	}

	public static String getDeviceInfo(Context ctx) {

		TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
		StringBuilder sb = new StringBuilder();
		sb.append("\nDeviceId(IMEI) = " + tm.getDeviceId());
		sb.append("\nDeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion());
		sb.append("\nLine1Number = " + tm.getLine1Number());
		sb.append("\nNetworkCountryIso = " + tm.getNetworkCountryIso());
		sb.append("\nNetworkOperator = " + tm.getNetworkOperator());
		sb.append("\nNetworkOperatorName = " + tm.getNetworkOperatorName());
		sb.append("\nNetworkType = " + tm.getNetworkType());
		sb.append("\nPhoneType = " + tm.getPhoneType());
		sb.append("\nSimCountryIso = " + tm.getSimCountryIso());
		sb.append("\nSimOperator = " + tm.getSimOperator());
		sb.append("\nSimOperatorName = " + tm.getSimOperatorName());
		sb.append("\nSimSerialNumber = " + tm.getSimSerialNumber());
		sb.append("\nSimState = " + tm.getSimState());
		sb.append("\nSubscriberId(IMSI) = " + tm.getSubscriberId());
		sb.append("\nVoiceMailNumber = " + tm.getVoiceMailNumber());
		Log.e("info", sb.toString());
		return sb.toString();
	}

}
