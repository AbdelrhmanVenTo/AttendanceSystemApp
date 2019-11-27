package com.example.attendancemanagementsystem.Model.ProfessorModel;


import com.google.gson.annotations.SerializedName;

public class CoursesItem{

	@SerializedName("name")
	private String name;

	@SerializedName("cid")
	private String cid;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCid(String cid){
		this.cid = cid;
	}

	public String getCid(){
		return cid;
	}

	@Override
 	public String toString(){
		return 
			"CoursesItem{" + 
			"name = '" + name + '\'' + 
			",cid = '" + cid + '\'' + 
			"}";
		}
}