package com.example.m.niceproject;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BodyMassIndexActivity extends AppCompatActivity {

    TextView resultText1;
    TextView resultText2;
    TextView bmiText;

    float bmiValue;
    String bmiInterpretation;

    float weight;
    float height;

    EditText weightText;
    EditText heightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_mass_index);


        // get the references to the widgets
        weightText = (EditText)findViewById(R.id.myWeight);
        heightText = (EditText)findViewById(R.id.myHeight);


        resultText1 = (TextView)findViewById(R.id.resultLabel1);
        resultText2 = (TextView)findViewById(R.id.resultLabel2);

        bmiText = (TextView)findViewById(R.id.bmiLabel);





        final Button buttonCalculate = (Button)findViewById(R.id.calculateButton);

        buttonCalculate.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( (heightText.getText().toString().trim().length() == 0) && (weightText.getText().toString().trim().length() == 0) ){

                    Toast.makeText(getApplicationContext(),
                            "Write your weight and height!",
                            Toast.LENGTH_LONG).show();
                }
                else if (heightText.getText().toString().trim().length() == 0){

                    Toast.makeText(getApplicationContext(),
                            "Write your height!",
                            Toast.LENGTH_LONG).show();

                }
                else if ( weightText.getText().toString().trim().length() == 0){

                    Toast.makeText(getApplicationContext(),
                            "Write your weight!",
                            Toast.LENGTH_LONG).show();
                }
                else {

                    // get the users values from the widget references
                    weight = Float.parseFloat(weightText.getText().toString());
                    height = Float.parseFloat(heightText.getText().toString());


                    // calculate the bmi value
                    bmiValue = calculateBMI(weight, height);

                    // interpret the meaning of the bmi value
                    bmiInterpretation = interpretBMI(bmiValue);

                    // set string - bmi
                    bmiText.setText("Your BMI:");
                    // now set the value in the result text
                    resultText1.setText(String.valueOf(bmiValue));
                    resultText2.setText(bmiInterpretation);


                    //hides the keyboard
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(buttonCalculate.getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);

                    //inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);





                }





            }

        });
    }



    // the formula to calculate the BMI index
    // check for http://en.wikipedia.org/wiki/Body_mass_index
    private float calculateBMI (float weight, float height) {

        return ( (weight / (height * height) ) * 10000 );
    }


    // interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";

        } else if (bmiValue < 18.5) {

            return "Underweight";

        } else if (bmiValue < 25) {

            return "Normal";

        } else if (bmiValue < 30) {

            return "Overweight";

        } else {

            return "Obese";
        }

    }
}


