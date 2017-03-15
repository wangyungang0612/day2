package com.example.info;

import java.util.ArrayList;

public class Group {
	private String groupNameString;
	private ArrayList<Person> list;

	public Group(String groupNameString, ArrayList<Person> list) {
		super();
		this.groupNameString = groupNameString;
		this.list = list;
	}

	public String getGroupNameString() {
		return groupNameString;
	}

	public void setGroupNameString(String groupNameString) {
		this.groupNameString = groupNameString;
	}

	public ArrayList<Person> getList() {
		return list;
	}

	public void setList(ArrayList<Person> list) {
		this.list = list;
	}

}
