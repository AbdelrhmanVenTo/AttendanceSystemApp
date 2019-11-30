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
import com.example.attendancemanagementsystem.Model.RecordModel.RecordResponse;
import com.example.attendancemanagementsystem.Model.RecordModel.StudentsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageViewModel extends AndroidViewModel {

    MutableLiveData<DatesResponse> datesResponseViewModel;
    MutableLiveData<List<CoursesItem>> professorResponseGetCourses;
    MutableLiveData<List<StudentsItem>> getStudentLiveData;
    protected MutableLiveData<String> errorMassage;



    public ManageViewModel(@NonNull Application application) {
        super(application);
        datesResponseViewModel = new MutableLiveData<>();
        professorResponseGetCourses = new MutableLiveData<>();
        getStudentLiveData = new MutableLiveData<>();
        errorMassage = new MutableLiveData<>();


    }


    public MutableLiveData<DatesResponse> getDatesResponseViewModel() {
        return datesResponseViewModel;
    }

    public MutableLiveData<List<CoursesItem>> getProfessorResponseGetCourses() {
        return professorResponseGetCourses;
    }

    public MutableLiveData<List<StudentsItem>> getGetStudentLiveData() {
        return getStudentLiveData;
    }

    public MutableLiveData<String> getErrorMassage() {
        return errorMassage;
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

    public void getRecordOfStudents(String date ,String pid ,String cid){
        ApiManager.getAPIs().getRecord(date, pid, cid).enqueue(new Callback<RecordResponse>() {
            @Override
            public void onResponse(Call<RecordResponse> call, Response<RecordResponse> response) {
                if (response.isSuccessful()){
                        getStudentLiveData.postValue(response.body().getStudents());
                }

            }

            @Override
            public void onFailure(Call<RecordResponse> call, Throwable t) {
                errorMassage.postValue(t.getLocalizedMessage());
            }
        });
    }


}
