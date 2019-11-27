package com.example.attendancemanagementsystem.API;


import com.example.attendancemanagementsystem.Model.DatesModel.DatesResponse;
import com.example.attendancemanagementsystem.Model.ProfessorModel.ProfessorResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APICalls {

    @GET("API/auth")
    Call<ProfessorResponse> professorAuth(@Query("username") String userName,
                                          @Query("password") String Password);

    @GET("API/get_dates")
    Call<DatesResponse> getDates(@Query("username") String userName,
                                 @Query("password") String Password, @Query("cid") String cid);


    @GET("API/get_record")
    Call<DatesResponse> getRecord(@Query("username") String userName,
                                 @Query("password") String Password, @Query("cid") String cid);


}
