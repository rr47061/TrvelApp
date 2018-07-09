package com.example.rohitranjan.mytravelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

public class get_pnr_input extends AppCompatActivity {
EditText pnr ;
int length;
String pnrname;
    HttpURLConnection connection;
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
        else
        {
            fun(pnrname);
            

        }

    }

    public void fun(String pnrname)
    {
       /* try {
            URL url = new URL("https://api.railwayapi.com/v2/pnr-status/pnr/pnrname/apikey/wwforlfiy6");
            connection = (HttpURLConnection)url.openConnection();
            connection.connect();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        */
        Intent intentshow = new Intent(this,show_pnr.class);
        intentshow.putExtra("pnrnum",pnrname);
        startActivity(intentshow);


    }

}
