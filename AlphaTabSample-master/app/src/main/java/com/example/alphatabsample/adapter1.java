package com.example.alphatabsample;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class adapter1 extends ArrayAdapter<Project> {
    private List<Project> items;
    private int res;
    private LayoutInflater layoutInflater;

    public adapter1(Context context, int resource, List<Project> objects) {
        super(context, resource, objects);
        this.items = objects;
        this.res = resource;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView == null) {
            convertView = layoutInflater.inflate(this.res, parent, false);
            textView = (TextView) convertView.findViewById(R.id.p1);
            convertView.setTag(textView);
        }else{
            textView = (TextView) convertView.getTag();
        }

        Project item = items.get(position);
        textView.setText(item.getName());


        return convertView;
    }
}