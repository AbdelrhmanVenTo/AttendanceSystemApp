package com.example.attendancemanagementsystem.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.attendancemanagementsystem.API.ApiManager;
import com.example.attendancemanagementsystem.Model.ProfessorModel.ProfessorResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInViewModel  extends AndroidViewModel {

    MutableLiveData<ProfessorResponse> professorViewModel ;

    public MutableLiveData<ProfessorResponse> getProfessorViewModel() {
        return professorViewModel;
    }

    public SignInViewModel(@NonNull Application application) {
        super(application);
        professorViewModel = new MutableLiveData<>();

    }


    public void professorLogin (String userName , String password){
        ApiManager.getAPIs().professorAuth(userName, password).enqueue(new Callback<ProfessorResponse>() {
            @Override
            public void onResponse(Call<ProfessorResponse> call, Response<ProfessorResponse> response) {
                professorViewModel.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ProfessorResponse> call, Throwable t) {

            }
        });
    }
}
