package com.example.attendancemanagementsystem.Model.DatesModel;

import com.google.gson.annotations.SerializedName;

public class DatesResponse {

	@SerializedName("dates")
	//private List<String> dates;
	private String[] dates;



//	public void setDates(List<String> dates){
//		this.dates = dates;
//	}
//
//	public List<String> getDates(){
//		return dates;
//	}

	public void setDates(String[] dates){
		this.dates = dates;
	}

	public String[] getDates(){
		return dates;
	}

	@Override
 	public String toString(){
		return 
			"DatesResponse{" + 
			"dates = '" + dates + '\'' + 
			"}";
		}
}