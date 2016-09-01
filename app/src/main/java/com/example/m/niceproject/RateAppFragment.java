package com.example.m.niceproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class RateAppFragment extends Fragment implements  View.OnClickListener, RatingBar.OnRatingBarChangeListener{

    private RatingBar ratingBar;
    private TextView txtRatingValue;




    public RateAppFragment() {
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

        Button btnSubmit;
        Context context;

        //Pass your layout xml to the inflater and assign it to rootView.
        View rootView = inflater.inflate(R.layout.rate_app_fragment, container, false);
        context = rootView.getContext(); // Assign your rootView to context

        btnSubmit = (Button) rootView.findViewById(R.id.btnSubmit);
        ratingBar = (RatingBar) rootView.findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) rootView.findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(this);
        btnSubmit.setOnClickListener(this);

        //Getting information from the user
        String ratingValue = txtRatingValue.getText().toString();

        //System.out.println("value: " + ratingValue);

        return rootView;

    }

    // RATE APP METHODS

    public void onRatingChanged(RatingBar ratingBar, float rating,
                                boolean fromUser) {

        txtRatingValue.setText(String.valueOf(rating) );

    }

    @Override
    public void onClick(View v) {

        Toast.makeText(getContext(),
                String.valueOf(ratingBar.getRating()),
                Toast.LENGTH_SHORT).show();

        /* This code assumes you are inside an activity */
        final Uri uri = Uri.parse("market://details?id=" + getActivity().getApplicationContext().getPackageName());
        final Intent rateAppIntent = new Intent(Intent.ACTION_VIEW, uri);

        if (getActivity().getPackageManager().queryIntentActivities(rateAppIntent, 0).size() > 0)
        {
            startActivity(rateAppIntent);
        }
        else
        {
            /* handle your error case: the device has no way to handle market urls */

            Toast.makeText(getContext(),
                    String.valueOf("The device has no way to handle market urls"),
                    Toast.LENGTH_SHORT).show();
        }



    }


}
