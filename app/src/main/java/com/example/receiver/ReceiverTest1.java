package com.example.receiver;

import com.example.day2.DesActivity;
import com.example.day2.MainActivity;
import com.example.day2.MainActivity2;
import com.example.day2.NotificationDemo;
import com.example.day2.R;
import com.example.service.ServiceTest1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverTest1 extends BroadcastReceiver {

	private static final String NOTIFICATION_SERVICE = null;

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stuboa
		// �㲥�Ľ���
		// Toast.makeText(arg0, "1.get" + arg1.getStringExtra("key1")
		// ,Toast.LENGTH_SHORT).show();

		// notification �ɷ���
		//
		// arg0.startService(new Intent(arg0, ServiceTest1.class));
		// Toast.makeText(arg0, "1.get" + arg1.getBooleanExtra("flag",
		// false),Toast.LENGTH_SHORT).show();
		//
		// NotificationManager notificationManager = (NotificationManager)
		// arg0.getSystemService("notification");
		// if (arg1.getBooleanExtra("flag", false) == true) {
		// Notification notification = new Notification();
		// notification.icon = R.drawable.ic_launcher;
		// notification.tickerText="tickertext";
		// notification.defaults=Notification.DEFAULT_SOUND;
		// Intent intent = new Intent(arg0, MainActivity2.class);
		// PendingIntent pendingIntent = PendingIntent.getActivity(arg0,
		// 0,intent, 0);
		// notification.setLatestEventInfo(arg0, "contentText",
		// "contentText",pendingIntent );
		// notificationManager.notify(0, notification);
		// }
		// else {
		// notificationManager.cancel(0);
		// }

		// �·���
		arg0.startService(new Intent(arg0, ServiceTest1.class));
		Toast.makeText(arg0, "1.get" + arg1.getBooleanExtra("flag", false),
				Toast.LENGTH_SHORT).show();
		NotificationManager notificationManager = (NotificationManager) arg0
				.getSystemService("notification");

		if (arg1.getBooleanExtra("flag", false) == true) {

			Notification notification = new Notification();
			Intent intent = new Intent(arg0, MainActivity2.class);
			PendingIntent pendingIntent = PendingIntent.getActivity(arg0, 0,
					intent, 0);

			notification = new Notification.Builder(arg0).setAutoCancel(true)
					.setContentTitle("title")// ���ñ���
					.setContentText("describe")// ����֪ͨ����
					.setContentIntent(pendingIntent)// ��������ͼ
					.setSmallIcon(R.drawable.ic_launcher)// ����ͼ��
					.setWhen(System.currentTimeMillis()).build();// ����ʱ��
			notification.defaults = Notification.DEFAULT_SOUND;// ��������
			notification.defaults = Notification.DEFAULT_LIGHTS;// ����ָʾ��
			notification.defaults = Notification.DEFAULT_VIBRATE;// ������
			// notification.defaults = Notification.DEFAULT_ALL;//�������� ָʾ�� �� ȫ��

			notificationManager.notify(0, notification);

		} else {
			notificationManager.cancel(0);

		}

	}

}
