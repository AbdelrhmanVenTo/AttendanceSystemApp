package com.example.attendancemanagementsystem.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.attendancemanagementsystem.API.ApiManager;
import com.example.attendancemanagementsystem.Model.DatesModel.DatesResponse;
import com.example.attendancemanagementsystem.Model.ProfessorModel.CoursesItem;
import com.example.attendancemanagementsystem.Model.ProfessorModel.ProfessorResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageViewModel extends AndroidViewModel {

    MutableLiveData<DatesResponse> datesResponseViewModel;
    MutableLiveData<List<CoursesItem>> professorResponseGetCourses;

    public MutableLiveData<DatesResponse> getDatesResponseViewModel() {
        return datesResponseViewModel;
    }

    public MutableLiveData<List<CoursesItem>> getProfessorResponseGetCourses() {
        return professorResponseGetCourses;
    }

    public ManageViewModel(@NonNull Application application) {
        super(application);
        datesResponseViewModel = new MutableLiveData<>();
        professorResponseGetCourses = new MutableLiveData<>();
    }

    public void getDates (String userName ,String password , String cid){
        ApiManager.getAPIs().getDates(userName, password, cid).enqueue(new Callback<DatesResponse>() {
            @Override
            public void onResponse(Call<DatesResponse> call, Response<DatesResponse> response) {
                datesResponseViewModel.postValue(response.body());

            }

            @Override
            public void onFailure(Call<DatesResponse> call, Throwable t) {
                Log.e("log",t.getLocalizedMessage());
            }
        });

    }

    public void getCourses(String userName ,String password) {
        ApiManager.getAPIs().professorAuth(userName, password).enqueue(new Callback<ProfessorResponse>() {
            @Override
            public void onResponse(Call<ProfessorResponse> call, Response<ProfessorResponse> response) {
                professorResponseGetCourses.postValue(response.body().getCourses());
            }

            @Override
            public void onFailure(Call<ProfessorResponse> call, Throwable t) {

            }
        });
    }


}
