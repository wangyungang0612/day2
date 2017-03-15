package com.example.day2;

import java.security.PublicKey;

import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.amap.api.maps.model.MyTrafficStyle;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.Activity;

public class MapActivity extends Activity implements OnItemSelectedListener,
		OnClickListener {
	private MapView mapView;
	private AMap aMap;
	private OnLocationChangedListener mListener;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		/*
		 * �������ߵ�ͼ�洢Ŀ¼�����������ߵ�ͼ���ʼ����ͼ����; ʹ�ù����п���������, ���������������ߵ�ͼ�洢��·����
		 * ����Ҫ�����ߵ�ͼ���غ�ʹ�õ�ͼҳ�涼����·������
		 */
		// Demo��Ϊ�������������ʹ�����ص����ߵ�ͼ��ʹ��Ĭ��λ�ô洢���������Զ�������
		// MapsInitializer.sdcardDir =OffLineMapUtils.getSdCacheDir(this);

		mapView = (MapView) findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);// �˷���������д

		init();
	}

	/**
	 * ��ʼ��AMap����
	 */
	private void init() {
		if (aMap == null) {
			aMap = mapView.getMap();
			
		}
		
		
		CheckBox traffic = (CheckBox) MapActivity.this
				.findViewById(R.id.traffic);
		traffic.setOnClickListener(this);
		Spinner spinner = (Spinner) findViewById(R.id.layers_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.layers_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		MyTrafficStyle myTrafficStyle = new MyTrafficStyle();
		myTrafficStyle.setSeriousCongestedColor(0xff92000a);
		myTrafficStyle.setCongestedColor(0xffea0312);
		myTrafficStyle.setSlowColor(0xffff7508);
		myTrafficStyle.setSmoothColor(0xff00a209);
		aMap.setMyTrafficStyle(myTrafficStyle);
	}



	/**
	 * ����������д
	 */
	@Override
	protected void onResume() {
		super.onResume();
		mapView.onResume();

	}

	/**
	 * ����������д
	 */
	@Override
	protected void onPause() {
		super.onPause();
		mapView.onPause();
	}

	/**
	 * ����������д
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

	/**
	 * ����������д
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		if (aMap != null) {
			setLayer((String) parent.getItemAtPosition(position));
		}
	}

	/**
	 * ѡ��ʸ����ͼ/���ǵ�ͼ/ҹ����ͼ�¼�����Ӧ
	 */
	private void setLayer(String layerName) {
		if (layerName.equals(getString(R.string.normal))) {
			aMap.setMapType(AMap.MAP_TYPE_NORMAL);// ʸ����ͼģʽ
		} else if (layerName.equals(getString(R.string.satellite))) {
			aMap.setMapType(AMap.MAP_TYPE_SATELLITE);// ���ǵ�ͼģʽ
		} else if (layerName.equals(getString(R.string.night_mode))) {
			aMap.setMapType(AMap.MAP_TYPE_NIGHT);// ҹ����ͼģʽ
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
	}

	/**
	 * ��ѡ���Ƿ���ʾ��ͨ״���¼�����Ӧ
	 */
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.traffic) {
			aMap.setTrafficEnabled(((CheckBox) v).isChecked());// ��ʾʵʱ��ͨ״��
		}
	}
}
