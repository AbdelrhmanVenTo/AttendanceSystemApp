package com.example.attendancemanagementsystem.ViewActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Base.BaseActivity;
import com.example.attendancemanagementsystem.R;

public class ManageStudent extends BaseActivity implements View.OnClickListener {

    protected EditText Name;
    protected EditText code;
    protected EditText comment;
    protected Button delete;
    protected Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_manage_student);
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
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.delete) {

        } else if (view.getId() == R.id.done) {

        }
    }

    private void initView() {
        Name = (EditText) findViewById(R.id.Name);
        code = (EditText) findViewById(R.id.code);
        comment = (EditText) findViewById(R.id.comment);
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(ManageStudent.this);
        done = (Button) findViewById(R.id.done);
        done.setOnClickListener(ManageStudent.this);
    }
}
