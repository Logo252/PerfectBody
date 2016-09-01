package com.example.m.niceproject.exercises.abdominalExercises;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m.niceproject.R;

/**
 * Created by arnas on 03/12/15.
 */
public class BentKneeHitRaise extends Fragment{

    public BentKneeHitRaise() {
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
        return inflater.inflate(R.layout.abdominal_bent_knee_hip_raise, container, false);
    }

}
