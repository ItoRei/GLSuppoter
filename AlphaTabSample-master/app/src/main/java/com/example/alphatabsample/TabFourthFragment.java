package com.example.alphatabsample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alphatabsample.model.Item;

import java.util.ArrayList;

public class TabFourthFragment extends Fragment{
    private AlphaAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("結成", "10/16"));
        items.add(new Item("全員参加", "10/16"));
        items.add(new Item("情報共有", "10/16"));
        items.add(new Item("協力", "10/16"));
        items.add(new Item("適応", "10/16"));
        items.add(new Item("自己組織化", "10/16"));
        items.add(new Item("休止", "10/16"));

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
