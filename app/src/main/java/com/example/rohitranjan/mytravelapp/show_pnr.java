package com.example.rohitranjan.mytravelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show_pnr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pnr);
        Intent intent = getIntent();
        String pnrnumber = intent.getStringExtra("pnrnum");
        TextView tv = findViewById(R.id.tv1);
        tv.setText(pnrnumber);
    }
}
