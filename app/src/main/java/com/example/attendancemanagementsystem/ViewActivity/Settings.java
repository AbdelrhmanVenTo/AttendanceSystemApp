package com.example.attendancemanagementsystem.ViewActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Base.BaseActivity;
import com.example.attendancemanagementsystem.R;

public class Settings extends BaseActivity implements View.OnClickListener {

    protected Button changePassword;
    protected Button changeLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_settings);
        Toolbar myToolbar = findViewById(R.id.app_bar);
        setSupportActionBar(myToolbar);
        TextView Title = myToolbar.findViewById(R.id.toolbar_title);
        Title.setText("Settings");
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
        if (view.getId() == R.id.changePassword) {

        } else if (view.getId() == R.id.changeLanguage) {

        }
    }

    private void initView() {
        changePassword = (Button) findViewById(R.id.changePassword);
        changePassword.setOnClickListener(Settings.this);
        changeLanguage = (Button) findViewById(R.id.changeLanguage);
        changeLanguage.setOnClickListener(Settings.this);
    }
}
