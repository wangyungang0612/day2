package com.example.adapter;


import java.util.ArrayList;

import com.example.day2.R;
import com.example.info.Group;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExAdapter  extends BaseExpandableListAdapter {
	Context context;
	ArrayList<Group> groups;

	
	public ExAdapter(Context context, ArrayList<Group> groups){
		this.context = context;
		this.groups = groups;
		
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return groups.get(arg0).getList().get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return arg1;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		// TODO Auto-generated method stub
		arg3 = LayoutInflater.from(context).inflate(com.example.day2.R.layout.item_listview,
				null);
		TextView textView1 = (TextView) arg3.findViewById(com.example.day2.R.id.textView1);
		TextView textView2 = (TextView) arg3.findViewById(com.example.day2.R.id.textView2);
		
		textView1.setText(groups.get(arg0).getList().get(arg1).getNameString());
		textView2.setText(groups.get(arg0).getList().get(arg1)
				.getNumberString());

		return arg3;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return groups.get(arg0).getList().size();
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return groups.get(arg0);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return  groups.size();
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		// TODO Auto-generated method stub
		arg2 = LayoutInflater.from(context).inflate(R.layout.item_file, null);
		TextView textView = (TextView) arg2.findViewById(R.id.myfilename);
		textView.setText(groups.get(arg0).getGroupNameString());
		return arg2;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
