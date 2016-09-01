package com.example.m.niceproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

// implements View.OnClickListener
public class TabHomeFragment extends Fragment {

    Button chronometerButton;
    Button calculateButton;

    Context context;

    //private WebView webView;

    public TabHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Pass your layout xml to the inflater and assign it to rootView.
        View rootView = inflater.inflate(R.layout.tab_home_fragment, container, false);
        context = rootView.getContext(); // Assign your rootView to context

        chronometerButton =(Button)rootView.findViewById(R.id.chronometerButton);
        chronometerButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent= new Intent(context,AndroidChronometerActivity.class);
                startActivity(intent);
            }
        });


        calculateButton =(Button)rootView.findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent= new Intent(context,BodyMassIndexActivity.class);
                startActivity(intent);
            }
        });

        return rootView;

    }


}
