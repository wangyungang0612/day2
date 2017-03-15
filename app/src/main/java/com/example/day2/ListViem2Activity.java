package com.example.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViem2Activity extends Activity {
	public ListView listView;
	public SimpleAdapter simpleAdapter;
	public ArrayList<HashMap<String, String>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_viem2);

		listView = (ListView) ListViem2Activity.this
				.findViewById(R.id.mysecondlistview);
		list = createData();

		// 参数1：当前的上下文对象
		// 参数2：数据
		// 参数3：子布局
		// 参数4:map的key
		// 参数5：key的值对应的控件

		simpleAdapter = new SimpleAdapter(ListViem2Activity.this, list,
				R.layout.item_listview, new String[] { "name", "num" },
				new int[] { R.id.textView1, R.id.textView2 });
		listView.setAdapter(simpleAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(ListViem2Activity.this, arg2 + "",
						Toast.LENGTH_SHORT).show();
			}

		});
	}

	private ArrayList<HashMap<String, String>> createData() {
		list = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < 30; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", i + "");
			map.put("num", new Random().nextInt(99999) + "");
			list.add(map);

		}
		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_viem2, menu);
		return true;
	}

}
