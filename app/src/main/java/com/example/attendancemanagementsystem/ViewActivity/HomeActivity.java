package com.example.attendancemanagementsystem.ViewActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Base.BaseActivity;
import com.example.attendancemanagementsystem.R;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    protected CardView attendance;
    protected CardView manage;
    protected CardView setting;
    protected CardView report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar myToolbar = findViewById(R.id.app_bar);
        setSupportActionBar(myToolbar);
        TextView Title = myToolbar.findViewById(R.id.toolbar_title);
        Title.setText("Home");
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayShowTitleEnabled(false);
        getUser();
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Attendance) {
            startActivity(new Intent(HomeActivity.this, Attendance.class));
        } else if (view.getId() == R.id.manage) {
            startActivity(new Intent(HomeActivity.this, ManageListChooseCourse.class));
        } else if (view.getId() == R.id.setting) {
            startActivity(new Intent(HomeActivity.this, Settings.class));
        } else if (view.getId() == R.id.report) {
            startActivity(new Intent(HomeActivity.this, Report.class));
        }
    }

    private void initView() {
        attendance = findViewById(R.id.Attendance);
        attendance.setOnClickListener(HomeActivity.this);
        manage =  findViewById(R.id.manage);
        manage.setOnClickListener(HomeActivity.this);
        setting =  findViewById(R.id.setting);
        setting.setOnClickListener(HomeActivity.this);
        report =  findViewById(R.id.report);
        report.setOnClickListener(HomeActivity.this);
    }
}
