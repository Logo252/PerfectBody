package com.example.m.niceproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class ProfileFragment extends Fragment implements View.OnClickListener{



    RadioButton maleButton;
    Boolean male;
    RadioButton femaleButton;
    Boolean female;

    EditText height;
    String heightText;
    EditText weight;
    String weightText;

    EditText date;
    String dateText;

    public ProfileFragment() {
        super();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        if (maleButton != null){
            male = maleButton.isChecked();
            outState.putBoolean("maleButton", male);
        }

        if (femaleButton != null){
            female = femaleButton.isChecked();
            outState.putBoolean("femaleButton", female);
        }



        if (date != null){
            dateText = date.getText().toString();
            outState.putString("date", dateText);
        }
        if (height != null){
            heightText = height.getText().toString();
            outState.putString("height", heightText);
        }
        if (weight != null){
            weightText = weight.getText().toString();
            outState.putString("weight", weightText);
        }



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.profile_fragment, container, false);

        //-----------------------------
        date = (EditText) rootView.findViewById(R.id.dateText);
        date.setInputType(InputType.TYPE_NULL);

        maleButton = (RadioButton)rootView.findViewById(R.id.maleButton);
        femaleButton = (RadioButton)rootView.findViewById(R.id.femaleButton);

        height = (EditText)rootView.findViewById(R.id.myHeight);
        weight = (EditText)rootView.findViewById(R.id.myWeight);

        if (savedInstanceState != null){

            maleButton.setChecked(savedInstanceState.getBoolean("maleButton") );
            femaleButton.setChecked(savedInstanceState.getBoolean("femaleButton") );

            date.setText(savedInstanceState.getString("date") );

            height.setText(savedInstanceState.getString("height") );
            weight.setText(savedInstanceState.getString("weight") );

        }
        //---------------------------------------------------------------
        //          Radio Buttons Clicks
        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femaleButton.setChecked(false);

            }
        });

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleButton.setChecked(false);

            }
        });
        //---------------------------------------------------------------

        date.setOnClickListener(this);


        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePickerDialog(v);
                }
            }

        });



        return rootView;
    }



    @Override
    public void onClick(View v) {

        showDatePickerDialog(v);
    }

    public void showDatePickerDialog(View v) {

        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");

    }


}
