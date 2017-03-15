package com.example.day2;

import java.util.jar.Attributes.Name;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
	public CheckBox checkBox1;
	public CheckBox checkBox2;
	public Editor editor;
	private EditText nameText, passwdText;
	private SharedPreferences sp;
	public ImageView imageView;
	private static final int IMAGE = 9999;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		checkBox1 = (CheckBox) LoginActivity.this.findViewById(R.id.checkBox1);
		checkBox2 = (CheckBox) LoginActivity.this.findViewById(R.id.checkBox2);
		nameText = (EditText) LoginActivity.this.findViewById(R.id.editname);
		passwdText = (EditText) LoginActivity.this.findViewById(R.id.editmima);

		sp = LoginActivity.this.getSharedPreferences("Log_text", 777);
		editor = sp.edit();

		checkBox1.setChecked(sp.getBoolean("checkBox1", false));
		checkBox2.setChecked(sp.getBoolean("checkBox2", false));
		nameText.setText(sp.getString("nameText", ""));
		passwdText.setText(sp.getString("passwdText", ""));

		if (checkBox2.isChecked()) {
			dologin();
		}

		checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if (arg1 == false && checkBox2.isChecked() == true) {
					checkBox2.setChecked(false);

				}

			}
		});

		checkBox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				// TODO Auto-generated method stub
				if (arg1 == true && checkBox1.isChecked() == false) {
					checkBox1.setChecked(true);
				}

			}
		});
	}

	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button25:
			dologin();
			// editor.putBoolean("checkBox1", checkBox1.isChecked());
			// editor.putBoolean("checkBox2", checkBox2.isChecked());
			// editor.putString("textname", textname.getText().toString());
			// editor.putString("textmima", textmima.getText().toString());
			// editor.commit();
			//
			// if(docheck()){
			// Intent intent = new Intent();
			// intent.setClass(LoginActivity.this, MainActivity2.class);
			// LoginActivity.this.startActivity(intent);
			// }

			break;

		default:
			break;
		}
	}

	private boolean docheck() {
		// TODO Auto-generated method stub
		return true;
	}

	private void dologin() {
		editor.putBoolean("checkBox1", checkBox1.isChecked());
		editor.putBoolean("checkBox2", checkBox2.isChecked());
		editor.putString("nameText", nameText.getText().toString());
		editor.putString("passwdText", passwdText.getText().toString());
		editor.commit();

		if (docheck()) {
			
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, MainActivity2.class);
			LoginActivity.this.startActivity(intent);
		}

	}

}
