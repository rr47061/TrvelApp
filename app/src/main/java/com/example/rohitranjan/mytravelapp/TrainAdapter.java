package com.example.rohitranjan.mytravelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class TrainAdapter extends BaseAdapter {
    Context context;
    List<LocationFindTrain> events;
    TrainAdapter(Context context, List<LocationFindTrain> events){
        this.context = context;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.signlerow, parent, false);
        TextView tv1, tv2, tv3;
        Button b1;
        tv1 = (TextView) v.findViewById(R.id.tv_title);
        tv2 = (TextView) v.findViewById(R.id.tv_seats);
        tv3 = (TextView) v.findViewById(R.id.tv_detail);
       // b1 = (Button) v.findViewById(R.id.btnedit);

        final LocationFindTrain e = events.get(position);
        tv1.setText(e.getName());
        tv2.setText(e.getNumber() + "");
        tv3.setText(e.getTime());
        return v;
    }
}
