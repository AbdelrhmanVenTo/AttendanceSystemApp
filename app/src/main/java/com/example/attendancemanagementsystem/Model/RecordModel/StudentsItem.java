package com.example.attendancemanagementsystem.Model.RecordModel;

import com.google.gson.annotations.SerializedName;

public class StudentsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("sid")
	private int sid;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSid(int sid){
		this.sid = sid;
	}

	public int getSid(){
		return sid;
	}

	@Override
 	public String toString(){
		return 
			"StudentsItem{" + 
			"name = '" + name + '\'' + 
			",sid = '" + sid + '\'' + 
			"}";
		}
}