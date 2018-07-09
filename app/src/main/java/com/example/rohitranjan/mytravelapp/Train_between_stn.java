package com.example.rohitranjan.mytravelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Train_between_stn extends AppCompatActivity {
EditText source,dest,date;
String strsrc,strdes,strdate,findtrainurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_between_stn);

        source = findViewById(R.id.etsource);
        dest = findViewById(R.id.etdest);
        date = findViewById(R.id.etdate);





    }

    public void gettrain(View view)
    {
        strsrc = source.getText().toString();
        strdes = dest.getText().toString();
        strdate = date.getText().toString();
        findtrainurl = "https://api.railwayapi.com/v2/between/source/" + strsrc + "/dest/" + strdes + "/date/" + strdate + "/apikey/wwforlfiy6/";

        Intent intent = new Intent(this,GetTrainDisplay.class);
        intent.putExtra("findtrainurl",findtrainurl);
        startActivity(intent);

    }

}
