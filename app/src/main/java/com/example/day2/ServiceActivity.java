package com.example.day2;

import java.security.PublicKey;

import com.example.service.ServiceTest1;
import com.example.service.ServiceTest2;

import android.R.integer;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class ServiceActivity extends Activity {
	int i = 0;
	Myconnection connection = new Myconnection();
	public ServiceTest2.MyBinder binder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		// 获取系统服务实例，
		// 长和宽
		WindowManager windowManager = (WindowManager) ServiceActivity.this
				.getSystemService(Context.WINDOW_SERVICE);
		Toast.makeText(
				ServiceActivity.this,
				windowManager.getDefaultDisplay().getHeight() + "    "
						+ windowManager.getDefaultDisplay().getWidth(),
				Toast.LENGTH_SHORT).show();

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		Toast.makeText(ServiceActivity.this,
				dm.widthPixels + "    " + dm.heightPixels, Toast.LENGTH_SHORT)
				.show();

		TelephonyManager tm = (TelephonyManager) ServiceActivity.this
				.getSystemService(Context.TELEPHONY_SERVICE);
		MyPhoneCallListener listener = new MyPhoneCallListener();
		tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button19:
			Intent intent1 = new Intent(ServiceActivity.this,
					ServiceTest1.class);
			ServiceActivity.this.startService(intent1);
			break;

		case R.id.button20:
			Intent intent2 = new Intent(ServiceActivity.this,
					ServiceTest1.class);
			ServiceActivity.this.stopService(intent2);
			break;

		case R.id.button21:
			Intent intent3 = new Intent(ServiceActivity.this,
					ServiceTest2.class);

			ServiceActivity.this.bindService(intent3, connection,
					Context.BIND_AUTO_CREATE);
			break;

		case R.id.button22:

			ServiceActivity.this.unbindService(connection);
			break;
		}

	}

	class Myconnection implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			// TODO Auto-generated method stub
			System.out.println("onServiceConnected");
			binder = (ServiceTest2.MyBinder) arg1;
			binder.sys();
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			System.out.println("onServiceDisconnected");

		}

	}

	public class MyPhoneCallListener extends PhoneStateListener {
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			AudioManager audioManger = (AudioManager) ServiceActivity.this
					.getSystemService(Context.AUDIO_SERVICE);
			switch (state) {
			case TelephonyManager.CALL_STATE_RINGING:
				Toast.makeText(ServiceActivity.this, incomingNumber,
						Toast.LENGTH_SHORT).show();
				if ("110".equals(incomingNumber)) {

					audioManger.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				}

				break;

			case TelephonyManager.CALL_STATE_OFFHOOK:
				i = i + 1;
				Toast.makeText(ServiceActivity.this, "通话中", Toast.LENGTH_SHORT)
						.show();

				break;

			case TelephonyManager.CALL_STATE_IDLE:
				if (i == 1) {
					Toast.makeText(ServiceActivity.this, "挂断",
							Toast.LENGTH_SHORT).show();
					audioManger.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				}
				if (i == 0) {
					Toast.makeText(ServiceActivity.this, "拒接接听",
							Toast.LENGTH_SHORT).show();
				}
				break;

			default:
				break;

			}

		}
	}
}
