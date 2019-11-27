package com.example.attendancemanagementsystem.ViewActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Adapters.ManageDatesAdapter;
import com.example.attendancemanagementsystem.Base.BaseActivity;
import com.example.attendancemanagementsystem.DataHolder;
import com.example.attendancemanagementsystem.Model.DatesModel.DatesResponse;
import com.example.attendancemanagementsystem.R;
import com.example.attendancemanagementsystem.ViewModel.ManageViewModel;



public class ManageDates extends BaseActivity {

    protected RecyclerView datesListRecycler;
    RecyclerView.LayoutManager layoutManager;
    ManageDatesAdapter adapter;
    ManageViewModel manageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_manage_dates);
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
        String user = "m.sameh";
        String password = "password";
        adapter = new ManageDatesAdapter(null);
        layoutManager = new LinearLayoutManager(activity);
        datesListRecycler.setAdapter(adapter);
        datesListRecycler.setLayoutManager(layoutManager);
        manageViewModel =ViewModelProviders.of(this)
                .get(ManageViewModel.class);

        manageViewModel.getDatesResponseViewModel().observe(this, new Observer<DatesResponse>() {
                    @Override
                    public void onChanged(@Nullable DatesResponse datesResponse) {
                        adapter = new ManageDatesAdapter(datesResponse);
                        datesListRecycler.setAdapter(adapter);
                    }
                });


                manageViewModel.getDates(user, password, DataHolder.course.getCid());

    }



    private void initView() {
        datesListRecycler =  findViewById(R.id.datesListRecycler);
    }
}
