package com.example.day2;

import java.sql.SQLData;

import com.example.datebase.MyOpenHelper;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SaveActivity extends Activity {
	private SharedPreferences sp;
	private Editor editor;
	private EditText editText;
	public MyOpenHelper myOpenHelper;
	public SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save);

		editText = (EditText) SaveActivity.this.findViewById(R.id.editText1);

		sp = SaveActivity.this.getSharedPreferences("testsp", 777);
		editor = sp.edit();

		myOpenHelper = new MyOpenHelper(SaveActivity.this);
		db = myOpenHelper.getReadableDatabase();
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button25:
			String content = editText.getText().toString();
			editText.setText("");
			// editText.setText(sp.getString("key", ""));
			editor.putString("key", content);
			editor.commit();

			break;
		case R.id.button26:
			String value = sp.getString("key", "default");
			editor.clear().commit();
			Toast.makeText(SaveActivity.this, value, Toast.LENGTH_SHORT).show();
			break;

		// *****以下为增删改查****

		case R.id.button27:
			String sql_insertString = "insert into info (name , pwd) values ('tom','123');";// 插入操作的SQL语句
			db.execSQL(sql_insertString);// 执行SQL语句
			break;
		case R.id.button28:
			ContentValues cv = new ContentValues();// 实例化一个ContentValues用来装载待插入的数据
			cv.put("name", "wang");// 添加用户名
			cv.put("pwd", "111");// 添加密码
			System.out.println(db.insert("info", null, cv));// 执行插入操作
			break;
		case R.id.button29:
			// String sql_deleteString =
			// "delete from info wwhere name = 'tom';";
			// db.execSQL(sql_deleteString);
			String sql_deleteString = "delete from info where name = ?;";
			String[] array = new String[] { "tom" };
			db.execSQL(sql_deleteString, array);
			break;
		case R.id.button30:
			String whereClause = "name = ?";// 删除的条件
			String[] whereArgs = new String[] { "wang" };// 删除的条件参数
			db.delete("info", whereClause, whereArgs);// 执行删除
			break;
		case R.id.button31:
			String sql_updateString = "update info set pwd = '000' where name = 'tom';";
			db.execSQL(sql_updateString);
			break;

		case R.id.button32:
			ContentValues cv2 = new ContentValues();// 实例化ContentValues
			cv2.put("pwd", "000");// 添加要更改的字段及内容
			String whereClause2 = "name = ?";// 修改条件
			String[] whereArgs2 = new String[] { "wang" };// 修改条件的参数
			db.update("info", cv2, whereClause2, whereArgs2);// 执行修改

			break;
		case R.id.button33:
			Cursor cursor = db.rawQuery("select * from info where name = ?",
					new String[] { "tom" });
			if (cursor.moveToFirst()) {
				for (int i = 0; i < cursor.getCount(); i++) {
					cursor.moveToPosition(i);// 移动到指定记录
					String name = cursor.getString(cursor
							.getColumnIndex("name"));
					String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
					System.out.println(name);
					System.out.println(pwd);
				}
			}
			break;
		case R.id.button34:
			Cursor cursor2 = db.query("info", null, null, null, null, null,
					null);// 查询并获得游标
			if (cursor2.moveToFirst()) {
				// 判断游标是否为空
				for (int i = 0; i < cursor2.getCount(); i++) {
					cursor2.moveToPosition(i);// 移动到指定记录
					String name = cursor2.getString(cursor2
							.getColumnIndex("name"));
					String pwd = cursor2.getString(cursor2
							.getColumnIndex("pwd"));
					System.out.println(name);
					System.out.println(pwd);
				}
			}

			break;
//查询手机通讯录
		case R.id.button35:
			ContentResolver cr = SaveActivity.this.getContentResolver();
			// uri
			// projection字段名
			// selection约束条件
			Cursor cursor3 = cr.query(
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					null, null, null);
			if (cursor3.moveToFirst()) {
				for (int i = 0; i < cursor3.getCount(); i++) {
					cursor3.moveToPosition(i);
					String numberString = cursor3
							.getString(cursor3
									.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					String nameString = cursor3
							.getString(cursor3
									.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
					System.out.println(nameString + "\t" + numberString);
				}

			}
			break;
//查询系统数据库
		case R.id.button36:
			Uri uri = Uri
					.parse("content://com.example.provider.myProvider/info");
			ContentResolver cr2 = SaveActivity.this.getContentResolver();
			Cursor cursor4 = cr2.query(uri, null, null, null, null);
			if (cursor4.moveToFirst()) {
				for (int i = 0; i < cursor4.getCount(); i++) {
					cursor4.moveToPosition(i);
					String nameString = cursor4.getString(cursor4
							.getColumnIndex("name"));
					String pwdString = cursor4.getString(cursor4
							.getColumnIndex("pwd"));
					System.out.println(nameString + "    " + pwdString);
				}
			}
			break;

		case R.id.button37:
			Uri uri2 = Uri
					.parse("content://com.example.provider.myProvider/info/tom");
			ContentResolver cr3 = SaveActivity.this.getContentResolver();
			cr3.delete(uri2, null, null);

			break;

		case R.id.button38:
			Uri uri3 = Uri
					.parse("content://com.example.provider.myProvider/info/info");
			ContentResolver cr4 = SaveActivity.this.getContentResolver();
			cr4.insert(uri3, null);

			break;

		case R.id.button39:
			Uri uri4 = Uri
					.parse("content://com.example.provider.myProvider/info/wang");
			ContentResolver cr5 = SaveActivity.this.getContentResolver();
			cr5.update(uri4, null, null, null);

			break;
			

		case R.id.button40:
			Uri uri5 = Uri
					.parse("content://com.example.provider.myProvider/info/wang");
			ContentResolver cr6 = SaveActivity.this.getContentResolver();
			cr6.query(uri5, null, null, null, null);

			break;
			
		case R.id.button41:
			Intent intent = new Intent(SaveActivity.this,FileActivity.class);
			SaveActivity.this.startActivity(intent);
			
			break;

		default:
			break;
		}
	}

}
