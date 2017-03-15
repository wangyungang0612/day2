package com.example.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class ReceiverTest3 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		PackageManager manager = context.getPackageManager();
		if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)) {
			String packageName = intent.getData().getSchemeSpecificPart();
			Toast.makeText(context, "��װ�ɹ�" + packageName, Toast.LENGTH_LONG)
					.show();
		}
		if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)) {
			String packageName = intent.getData().getSchemeSpecificPart();
			Toast.makeText(context, "ж�سɹ�" + packageName, Toast.LENGTH_LONG)
					.show();
		}
		if (intent.getAction().equals(Intent.ACTION_PACKAGE_REPLACED)) {
			String packageName = intent.getData().getSchemeSpecificPart();
			Toast.makeText(context, "�滻�ɹ�" + packageName, Toast.LENGTH_LONG)
					.show();
		}

	}

}
