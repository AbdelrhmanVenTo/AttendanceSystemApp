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

import com.example.attendancemanagementsystem.Adapters.StudentRecordAdapter;
import com.example.attendancemanagementsystem.Base.BaseActivity;
import com.example.attendancemanagementsystem.DataHolder;
import com.example.attendancemanagementsystem.Model.RecordModel.StudentsItem;
import com.example.attendancemanagementsystem.R;
import com.example.attendancemanagementsystem.SessionManager;
import com.example.attendancemanagementsystem.ViewModel.ManageViewModel;

import java.util.List;

public class ListOfStudent extends BaseActivity {

    protected RecyclerView studentListRecycler;
    RecyclerView.LayoutManager layoutManager;
    StudentRecordAdapter adapter;
    ManageViewModel manageViewModel;
    private SessionManager session;
    String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_list_of_student);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        TextView Title = myToolbar.findViewById(R.id.toolbar_title);
        Title.setText("Manage");
        // Get a support ActionBar corresponding to this toolbar
        final ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        myToolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.buttonColor), PorterDuff.Mode.SRC_ATOP);
        session = new SessionManager(activity);
        initView();
        date = getIntent().getStringExtra("date");
        manageViewModel = ViewModelProviders.of(this)
                .get(ManageViewModel.class);
        adapter = new StudentRecordAdapter(null);
        layoutManager = new LinearLayoutManager(activity);
        studentListRecycler.setAdapter(adapter);
        studentListRecycler.setLayoutManager(layoutManager);
        manageViewModel.getRecordOfStudents(date,String.valueOf(session.getUserId()), DataHolder.course.getCid());

        manageViewModel.getGetStudentLiveData().observe(this, new Observer<List<StudentsItem>>() {
            @Override
            public void onChanged(@Nullable List<StudentsItem> studentsItems) {
                adapter = new StudentRecordAdapter(studentsItems);
                studentListRecycler.setAdapter(adapter);
                adapter.setOnItemClickListener(new StudentRecordAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int pos, StudentsItem studentsItem) {
                        Intent intent=new Intent(activity,ListOfStudent.class);
                        intent.putExtra("date",list.get(pos).toString());
                        startActivity(intent);
                    }
                });
            }
        });

    }

    private void initView() {
        studentListRecycler = (RecyclerView) findViewById(R.id.studentListRecycler);
    }
}
