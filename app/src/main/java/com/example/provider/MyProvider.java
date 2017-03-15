package com.example.provider;

import com.example.datebase.MyOpenHelper;

import android.R.integer;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyProvider extends ContentProvider {
	private SQLiteDatabase database;
	private static final UriMatcher MATCHER = new UriMatcher(
			UriMatcher.NO_MATCH);
	private static final int CODE_1 = 1;
	private static final int CODE_2 = 2;

	static {
		MATCHER.addURI("com.example.provider.myProvider", "info", CODE_1);
		MATCHER.addURI("com.example.provider.myProvider", "info/*", CODE_2);

	}

	// 创建
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		database = new MyOpenHelper(MyProvider.this.getContext())
				.getReadableDatabase();
		return false;
	}

	// 插入
	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		switch (MATCHER.match(arg0)) {
		case CODE_1:
			long rowid = database.insert("info", null, arg1);
			// 得到代表新增记录的Uri
			Uri insertUri = ContentUris.withAppendedId(arg0, rowid);
			this.getContext().getContentResolver().notifyChange(arg0, null);
			return insertUri;

		case CODE_2:
			String nameString = arg0.getPathSegments().get(1);
			String pwdString = arg0.getPathSegments().get(1);
			ContentValues values = new ContentValues();
			values.put("name", "yun");
			values.put("pwd", "222");
			database.insert("info", null, values);

		default:
			new IllegalArgumentException("Unkwon Uri:" + arg0.toString());

		}
		return null;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub

		System.out.println("MATCHER.match(uri) = " + MATCHER.match(uri));
		switch (MATCHER.match(uri)) {
		case CODE_1:
			Cursor cursor = database.query("info", projection, selection,
					selectionArgs, null, null, sortOrder);
			return cursor;
		case CODE_2:
			String nameString1 = uri.getPathSegments().get(1);
			String pwdString1 = uri.getPathSegments().get(1);
			Cursor cursor1 = database.query("info", projection, "name = ?",
					new String[] {nameString1}, null, null, sortOrder);
			if (cursor1.moveToFirst()){
				for (int i = 0; i < cursor1.getCount(); i++) {
					cursor1.moveToPosition(i);
					String nameString = cursor1.getString(cursor1
							.getColumnIndex("name"));
					String pwdString = cursor1.getString(cursor1
							.getColumnIndex("pwd"));
					System.out.println(nameString + "    " + pwdString);
				}
				
			}
			
			
			break;
		default:
			new IllegalArgumentException("Unkwon Uri:" + uri.toString());
		}
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		switch (MATCHER.match(uri)) {
		case CODE_1:
			database.update("info", arg1, arg2, arg3);
			break;
		case CODE_2:
			String nameString = uri.getPathSegments().get(1);
			ContentValues values = new ContentValues();
			values.put("pwd", "444");
			// String whereClause2 = "name = ?";
			// String[] whereArgs2 = new String[] { "wang" };
			database.update("info", values, "name = ?",
					new String[] { nameString });
			break;
		default:
			new IllegalArgumentException("Unkwon Uri:" + uri.toString());

		}
		return 0;

	}

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		switch (MATCHER.match(arg0)) {

		case CODE_1:
			database.delete("info", arg1, arg2);
			break;

		case CODE_2:
			String name = arg0.getPathSegments().get(1);
			database.delete("info", "name = ?", new String[] { name });
			break;
		default:
			new IllegalArgumentException("Unkwon Uri:" + arg0.toString());

		}
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		switch (MATCHER.match(arg0)) {
		case CODE_1:
			return "vnd.android.cursor.dir/info";

		default:
			new IllegalArgumentException("Unkwon Uri:" + arg0.toString());

		}
		return null;
	}

}
