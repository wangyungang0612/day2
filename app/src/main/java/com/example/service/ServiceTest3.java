package com.example.service;

import com.example.aidl.IPerson;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ServiceTest3 extends Service {
	private static final String TAG = "AIDLService";

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i(TAG, "onBind() called");
		return stub;
	}

	public boolean onUnbind(Intent intent) {
		Log.i(TAG, "onUnbind() called");

		return true;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy() called");

	}

	IPerson.Stub stub = new IPerson.Stub() {

		@Override
		public String greet(String someone) throws RemoteException {
			// TODO Auto-generated method stub
			Log.i(TAG, "greet() called");
			return "hello ," + someone;
		}

	};

	public class MyServiceImpl1 extends IPerson.Stub {
		@Override
		public String greet(String someone) throws RemoteException {
			return "hello, " + someone;
		}
	}

}
