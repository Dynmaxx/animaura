package com.example.animora.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animora.R;

public class foodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getSupportActionBar().hide();
    }
}