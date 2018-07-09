package com.example.rohitranjan.mytravelapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetTrainDisplay extends AppCompatActivity {

    ListView lview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_train_display);
        Intent in = getIntent();
        String path = in.getStringExtra("findtrainurl");

        lview = (ListView) findViewById(R.id.lview);
        path = "https://api.railwayapi.com/v2/between/source/gkp/dest/jat/date/09-07-2018/apikey/wwforlfiy6/";
        new MyTask().execute(path);
        Toast.makeText(this, path, Toast.LENGTH_LONG).show();
    }

    class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... str) {
            String path = str[0];
            String json = "";
            try{
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(connection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder builder = new StringBuilder();
                String line = "";
                while((line = reader.readLine()) != null){
                    builder.append(line);
                }
                json = builder.toString();
                Toast.makeText(getApplicationContext(), "Data: " + json, Toast.LENGTH_LONG).show();
            }catch (Exception e){}

            return json;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getApplicationContext(), "JSON:- " + s, Toast.LENGTH_LONG).show();
            try {
                JSONObject object = new JSONObject(s);
                JSONArray array = object.getJSONArray("trains");
                List<LocationFindTrain> events = new ArrayList<>();
                for(int i = 0; i < array.length(); i++){
                    JSONObject ob = array.getJSONObject(i);

                    String a, b;
                    int c = ob.getInt("number");
                    a = ob.getString("name");
                    b = ob.getString("travel_time");


                    LocationFindTrain e = new LocationFindTrain(a, b, c);
                    events.add(e);
                }
                TrainAdapter adapter = new TrainAdapter(getApplicationContext(), events);
                lview.setAdapter(adapter);

            }catch (Exception e){}
        }
    }
}
