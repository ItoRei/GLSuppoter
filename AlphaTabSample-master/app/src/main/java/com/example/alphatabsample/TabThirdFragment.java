package com.example.alphatabsample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alphatabsample.model.Item;

import java.util.ArrayList;

public class TabThirdFragment extends Fragment{
    private AlphaAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("方向付け", "10/16"));
        items.add(new Item("環境準備", "10/16"));
        items.add(new Item("共有・可視化", "10/16"));
        items.add(new Item("検査・計測", "10/16"));
        items.add(new Item("適応", "10/16"));
        items.add(new Item("リリース", "10/16"));
        items.add(new Item("終結", "10/16"));

        adapter = new AlphaAdapter(getActivity(), R.layout.alpha_items, items);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.alpha_tab_fragment, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.sample_list);
        listView.setAdapter(adapter);

        return rootView;
    }

}
