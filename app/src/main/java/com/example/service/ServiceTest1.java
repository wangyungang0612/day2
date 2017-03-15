package com.example.service;

import android.R.integer;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServiceTest1 extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		System.out.println("onBind");
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		System.out.println("onCreate");

		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub

		System.out.println("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

		System.out.println("onDestroy");
		super.onDestroy();
	}

}
