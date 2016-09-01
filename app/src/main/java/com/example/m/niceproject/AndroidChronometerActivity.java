package com.example.m.niceproject;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AndroidChronometerActivity extends Activity {

    private TextView textTimer;

    private long startTime = 0L;
    private Handler myHandler = new Handler();
    long timeInMillies = 0L;
    long timeSwap = 0L;
    long finalTime = 0L;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_chronometer);

        Button startButton;
        Button pauseButton;
        Button resetButton;

        textTimer = (TextView) findViewById(R.id.textTimer);

        startButton = (Button) findViewById(R.id.btnStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                startTime = SystemClock.uptimeMillis();
                myHandler.postDelayed(updateTimerMethod, 0);

            }
        });

        pauseButton = (Button) findViewById(R.id.btnPause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                timeSwap += timeInMillies;
                myHandler.removeCallbacks(updateTimerMethod);

            }
        });

        resetButton = (Button) findViewById(R.id.btnReset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                startTime = SystemClock.uptimeMillis();
                timeInMillies = 0L;
                timeSwap = 0L;
                finalTime = 0L;




                timeInMillies = SystemClock.uptimeMillis() - startTime;
                finalTime = timeSwap + timeInMillies;

                int seconds = (int) (finalTime / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                int milliseconds = (int) (finalTime % 1000);

                textTimer.setText("" + minutes + ":"
                        + String.format("%02d", seconds) + ":"
                        + String.format("%03d", milliseconds) );





                myHandler.removeCallbacks(updateTimerMethod);





            }
        });

    }

    private Runnable updateTimerMethod = new Runnable() {

        public void run() {
            timeInMillies = SystemClock.uptimeMillis() - startTime;
            finalTime = timeSwap + timeInMillies;

            int seconds = (int) (finalTime / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            int milliseconds = (int) (finalTime % 1000);

            textTimer.setText("" + minutes + ":"
            + String.format("%02d", seconds) + ":"
            + String.format("%03d", milliseconds) );

            myHandler.postDelayed(this, 0);
        }

    };



}
