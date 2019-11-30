package com.example.attendancemanagementsystem.Model.RecordModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RecordResponse{

	@SerializedName("date")
	private String date;

	@SerializedName("professor")
	private Professor professor;

	@SerializedName("course")
	private Course course;

	@SerializedName("students")
	private List<StudentsItem> students;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setProfessor(Professor professor){
		this.professor = professor;
	}

	public Professor getProfessor(){
		return professor;
	}

	public void setCourse(Course course){
		this.course = course;
	}

	public Course getCourse(){
		return course;
	}

	public void setStudents(List<StudentsItem> students){
		this.students = students;
	}

	public List<StudentsItem> getStudents(){
		return students;
	}

	@Override
 	public String toString(){
		return 
			"RecordResponse{" + 
			"date = '" + date + '\'' + 
			",professor = '" + professor + '\'' + 
			",course = '" + course + '\'' + 
			",students = '" + students + '\'' + 
			"}";
		}
}