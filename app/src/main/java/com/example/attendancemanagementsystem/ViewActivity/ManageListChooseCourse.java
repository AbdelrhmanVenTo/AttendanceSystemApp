package com.example.attendancemanagementsystem.ViewActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Adapters.CourseListAdapter;
import com.example.attendancemanagementsystem.Base.BaseActivity;
import com.example.attendancemanagementsystem.DataHolder;
import com.example.attendancemanagementsystem.Model.ProfessorModel.CoursesItem;
import com.example.attendancemanagementsystem.R;
import com.example.attendancemanagementsystem.SessionManager;
import com.example.attendancemanagementsystem.ViewModel.ManageViewModel;


import java.util.List;

public class ManageListChooseCourse extends BaseActivity {

    protected RecyclerView manageRecycler;
    RecyclerView.LayoutManager layoutManager;
    CourseListAdapter adapter ;
    ManageViewModel manageViewModel;
    private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_choose_course);

        //Adding a tool bar with button Back
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        TextView Title = myToolbar.findViewById(R.id.toolbar_title);
        Title.setText("Manage");
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        myToolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.buttonColor), PorterDuff.Mode.SRC_ATOP);
        session = new SessionManager(activity);
        initView();
        adapter = new CourseListAdapter(null);
        layoutManager = new LinearLayoutManager(activity);
        manageRecycler.setAdapter(adapter);
        manageRecycler.setLayoutManager(layoutManager);

        manageViewModel= ViewModelProviders.of(this)
                .get(ManageViewModel.class);

        manageViewModel.getCourses(session.getUserName(), session.getPassword_TAG());

        manageViewModel.getProfessorResponseGetCourses().observe(this, new Observer<List<CoursesItem>>() {
                    @Override
                    public void onChanged(@Nullable List<CoursesItem> coursesItems) {
                        adapter = new CourseListAdapter(coursesItems);
                        manageRecycler.setAdapter(adapter);
                        adapter.setOnItemClickListener(new CourseListAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int pos, CoursesItem courses) {
                                DataHolder.course = courses;
                                Intent intent=new Intent(activity,ManageDates.class);
                                startActivity(intent);
                            }
                        });

                    }
                });



    }

    private void initView() {
        manageRecycler = findViewById(R.id.courseListRecycler);
    }
}
