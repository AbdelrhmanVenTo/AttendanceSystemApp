package com.example.attendancemanagementsystem.ViewActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Base.BaseActivity;
import com.example.attendancemanagementsystem.R;

public class ManageRecordStudent extends BaseActivity {

    protected RecyclerView datesRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_manage_record_student);
        Toolbar myToolbar = findViewById(R.id.app_bar);
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

    private void initView() {
        datesRecycler =  findViewById(R.id.datesRecycler);
    }
}
