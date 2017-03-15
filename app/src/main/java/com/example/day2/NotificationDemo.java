package com.example.day2;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NotificationDemo extends Activity {

	public Button button1;
	public TextView textView;
	public NotificationManager notificationManager;
	public Notification notification;
	public Intent intent;
	public PendingIntent pendingIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_demo);
		
		notificationManager = (NotificationManager) NotificationDemo.this.getSystemService(NOTIFICATION_SERVICE);
		button1 = (Button)NotificationDemo.this.findViewById(R.id.button28);
		intent = new Intent(NotificationDemo.this,DesActivity.class);
		pendingIntent = PendingIntent.getActivity(NotificationDemo.this, 0, intent, 0);
        notification = new Notification();
        
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				notification.icon = R.drawable.ic_launcher;
				notification.tickerText="Button1 通知内容.....";
				notification.defaults=Notification.DEFAULT_SOUND;
				notification.setLatestEventInfo(NotificationDemo.this, "Button1", "Button1通知",pendingIntent );
				notificationManager.notify(0,notification);
				
			}
		});
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notification_demo, menu);
		return true;
	}

}
