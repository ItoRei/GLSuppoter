package com.example.alphatabsample;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class FirstActivity extends Activity {
    private adapter1 adapter;
    private ArrayList<Project> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        list = new ArrayList<Project>();
        list.add(new Project(1,"プロジェクト1"));
        list.add(new Project(2,"プロジェクト2"));
        list.add(new Project(3,"プロジェクト3"));

        adapter = new adapter1(this,R.layout.list_layout,list);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new ListItemClickListener());
        listView.setAdapter(adapter);


    }

    class ListItemClickListener implements OnItemClickListener {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
            long num = list.get(position).getNumber();

            Intent objIntent = new Intent(getApplicationContext(),AlphaTabActivity.class);
            objIntent.putExtra("Project_result", num);
            startActivity(objIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}