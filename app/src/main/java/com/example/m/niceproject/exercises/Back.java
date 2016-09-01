package com.example.m.niceproject.exercises;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.m.niceproject.MainActivity;
import com.example.m.niceproject.R;

public class Back extends ListFragment implements AdapterView.OnItemClickListener {

    View headerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exercises_back, container, false);

        headerView = inflater.inflate(R.layout.exercises_back_header, null);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.BACK, android.R.layout.simple_list_item_1);

        if (headerView != null)
            getListView().addHeaderView(headerView);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {


        ((MainActivity)getActivity()).replaceBackFragment(position);

    }

    @Override
    public void onDestroyView() {

        setListAdapter(null);
        super.onDestroyView();
    }

}
