package com.example.attendancemanagementsystem.ViewActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.attendancemanagementsystem.Base.BaseActivity;
import com.example.attendancemanagementsystem.Model.ProfessorModel.ProfessorResponse;
import com.example.attendancemanagementsystem.R;
import com.example.attendancemanagementsystem.SessionManager;
import com.example.attendancemanagementsystem.ViewModel.SignInViewModel;

public class Sign_in extends BaseActivity implements View.OnClickListener {

    protected Button login;
    protected EditText userName;
    protected EditText password;
    private boolean CheckEditText;
    SignInViewModel signInViewModel;
    String userNameHolder;
    String passwordHolder;
    private SessionManager session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        session = new SessionManager(activity);
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(Sign_in.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        initView();
        //initialize view model object
        signInViewModel= ViewModelProviders.of(this)
                .get(SignInViewModel.class);

        signInViewModel.getProfessorViewModel()
                .observe(this, new Observer<ProfessorResponse>() {
                    @Override
                    public void onChanged(@Nullable ProfessorResponse professorResponse) {
                        hideProgressBar();
                        if(professorResponse==null){
                            showMessageInt(R.string.error,R.string.user_name_or_password_not_valid,R.string.ok);
                        }else {
                            //start activity home
                            session.setLogin(true,professorResponse.getPid());
                            session.setUserName(userNameHolder);
                            session.setPassword_TAG(passwordHolder);
                            Log.e("user_Password",session.getPassword_TAG()+session.getUserName()+session.getUserId());
                            Intent intent = new Intent(activity,HomeActivity.class);
                            startActivity(intent);
                    }
                }

         });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            userNameHolder = userName.getText().toString();
            passwordHolder = password.getText().toString();
            CheckEditText = true;
            if (TextUtils.isEmpty(userNameHolder)) {
                CheckEditText = false;
                userName.setError("Enter Your User Name");
            }
            if (TextUtils.isEmpty(passwordHolder)) {
                CheckEditText = false;
                password.setError("Enter Your Password");
            }
            showProgressBar(R.string.please_wait,R.string.loading);
            signInViewModel.professorLogin(userNameHolder,passwordHolder);



        }
    }




    private void initView() {
        login = findViewById(R.id.login);
        login.setOnClickListener(Sign_in.this);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
    }
}

