package com.example.attendancemanagementsystem.Model.ProfessorModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProfessorResponse{

	@SerializedName("courses")
	private List<CoursesItem> courses;

	@SerializedName("name")
	private String name;

	@SerializedName("pid")
	private int pid;

	public void setCourses(List<CoursesItem> courses){
		this.courses = courses;
	}

	public List<CoursesItem> getCourses(){
		return courses;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPid(int pid){
		this.pid = pid;
	}

	public int getPid(){
		return pid;
	}

	@Override
 	public String toString(){
		return 
			"ProfessorResponse{" + 
			"courses = '" + courses + '\'' + 
			",name = '" + name + '\'' + 
			",pid = '" + pid + '\'' + 
			"}";
		}
}