package com.example.rohitranjan.mytravelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class get_pnr_input extends AppCompatActivity {
EditText pnr ;
int length;
String pnrname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pnr_input);



    }

    public void pnr_check(View v)
    {
        pnr = (EditText) findViewById(R.id.pnr);
        pnrname = pnr.getText().toString();
        length = pnrname.length();
        if(length!=10)
        {
            Toast.makeText(this,"wrong input",Toast.LENGTH_SHORT).show();
        }

    }
}
