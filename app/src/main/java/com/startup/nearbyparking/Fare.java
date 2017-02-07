package com.startup.nearbyparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



public class Fare extends AppCompatActivity {

    Databasehelper myDB;
    CheckBox hvscar, hvsbike;
    EditText et_fcar;
    EditText et_ncar;
    EditText et_fbike;
    EditText et_nbike;
    Button btnfinal;

    String fcar, ncar, fbike, nbike;

    int x = 0, y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);

        myDB = new Databasehelper(this);
        hvscar = (CheckBox) findViewById(R.id.checkbox_h_p_car);
        et_fcar = (EditText) findViewById(R.id.editText_fare_car);
        et_ncar = (EditText) findViewById(R.id.editText_noofcar);

        hvsbike = (CheckBox) findViewById(R.id.checkBox_have_space_bike);
        et_fbike = (EditText) findViewById(R.id.editText_fare_bike);
        et_nbike = (EditText) findViewById(R.id.editText_nofbike);

        et_fcar.setEnabled(false);
        et_fcar.setInputType(InputType.TYPE_NULL);
        et_ncar.setEnabled(false);
        et_ncar.setInputType(InputType.TYPE_NULL);
        //ncar.setFocusable(false);
        //fcar.setFocusable(false);

        et_nbike.setInputType(InputType.TYPE_NULL);
        et_fbike.setInputType(InputType.TYPE_NULL);
        et_fbike.setEnabled(false);
        et_nbike.setEnabled(false);

        btnfinal = (Button) findViewById(R.id.button_final_submission);

        hvscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (hvscar.isChecked()) {

                    et_fcar.setEnabled(true);
                    et_fcar.setInputType(InputType.TYPE_CLASS_TEXT);

                    et_ncar.setEnabled(true);
                    et_ncar.setInputType(InputType.TYPE_CLASS_TEXT);
                    // ncar.setFocusable(true);
                    //fcar.setFocusable(true);

                    //x = 1;
                } else {
                    et_fcar.setEnabled(false);
                    et_fcar.setInputType(InputType.TYPE_NULL);

                    et_ncar.setEnabled(false);
                    et_ncar.setInputType(InputType.TYPE_NULL);
                    //ncar.setFocusable(false);
                    //fcar.setFocusable(false)

                    //fcar = "NOT AVALIABLE";
                   // ncar = "NOT AVALIABLE";
                    //x = 0;
                }
            }
        });


        hvsbike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (hvsbike.isChecked()) {
                    et_fbike.setEnabled(true);
                    et_fbike.setInputType(InputType.TYPE_CLASS_TEXT);
                    et_nbike.setEnabled(true);
                    et_nbike.setInputType(InputType.TYPE_CLASS_TEXT);
                    // fbike.setFocusable(true);
                    //fbike.setVisibility(View.VISIBLE);
                    // nbike.setFocusable(true);
                    // fbike.setVisibility(View.VISIBLE);
                   // y = 1;
                } else {
                    et_nbike.setInputType(InputType.TYPE_NULL);
                    et_fbike.setInputType(InputType.TYPE_NULL);
                    et_fbike.setEnabled(false);
                    et_nbike.setEnabled(false);

                    //fbike = "NOT AVALIABLE";
                    //nbike = "NOT AVALIBLE";

                    //y = 0;
                   /*fbike.setEnabled(false);
                    fbike.setFocusable(false);
                    fbike.setVisibility(Vi‌​ew.GONE);
                    nbike.setEnabled(false);
                    nbike.setFocusable(false);*/
                }
            }
        });

        btnfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalsubmit();
            }
        });
    }

    public void finalsubmit() {
        initializes();
        if (!validate()) {
            Toast.makeText(Fare.this, "please fill the detail", Toast.LENGTH_SHORT).show();
        } else {
            AddFair();
            Intent i = new Intent(Fare.this, MainActivity.class);
            Toast.makeText(Fare.this, "THANK U FOR SIGN UP", Toast.LENGTH_LONG).show();
            startActivity(i);
        }
    }


    public void initializes() {
        fcar = et_fcar.getText().toString().trim();
        ncar = et_ncar.getText().toString().trim();
        fbike = et_fbike.getText().toString().trim();
        nbike = et_nbike.getText().toString().trim();
    }


    public boolean validate() {

        boolean valid = true;

        if (fcar.isEmpty()) {
            et_fcar.setError("this can't be empty");
            valid = false;
        }
        if (ncar.isEmpty()) {
            et_ncar.setError("this can't be empty");
            valid = false;
        }
        if (fbike.isEmpty()) {
            et_fbike.setError("this can't be empty");
            valid = false;
        }
        if (nbike.isEmpty()) {
            et_nbike.setError("this can't be empty");
            valid = false;
        }
        return valid;
    }

    public void AddFair() {
        boolean insertAdress = myDB.farePerHour(fcar, ncar, fbike, nbike);
        if (insertAdress) {
            Toast.makeText(Fare.this, "data inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Fare.this, "data  cannot be inserted", Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent(Fare.this, OwnerPage.class);
        startActivity(i);
    }

}





     /*   if (hvscar.isChecked()) {
            fcar.setEnabled(true);
            fcar.setInputType(InputType.TYPE_CLASS_TEXT);
            fcar.setFocusable(true);

            ncar.setEnabled(true);
            ncar.setInputType(InputType.TYPE_CLASS_TEXT);
            ncar.setFocusable(true);


        }



        if (hvsbike.isChecked()) {
            fbike.setEnabled(true);
            fbike.setInputType(InputType.TYPE_CLASS_TEXT);
            fbike.setFocusable(true);

            nbike.setEnabled(true);
            nbike.setInputType(InputType.TYPE_CLASS_TEXT);
            nbike.setFocusable(true);


        }


*/





/*
    public void EnableTheBike(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.hv_vechile:
                if (checked) {
                    fbike.setEnabled(true);
                    fbike.setInputType(InputType.TYPE_CLASS_TEXT);
                    fbike.setFocusable(true);

                    nbike.setEnabled(true);
                    nbike.setInputType(InputType.TYPE_CLASS_TEXT);
                    nbike.setFocusable(true);
                } else {
                    fbike.setEnabled(false);
                    fbike.setInputType(InputType.TYPE_NULL);
                    fbike.setFocusable(false);


                    nbike.setEnabled(false);
                    nbike.setInputType(InputType.TYPE_NULL);
                    nbike.setFocusable(false);
                }
                break;

        }


    }

    public void EnableTheCar(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.hv_pspace:
                if (checked)
                {
                    fcar.setEnabled(true);
                    fcar.setInputType(InputType.TYPE_CLASS_TEXT);
                    fcar.setFocusable(true);

                    ncar.setEnabled(true);
                    ncar.setInputType(InputType.TYPE_CLASS_TEXT);
                    ncar.setFocusable(true);
                }
                else
                {
                    ncar.setEnabled(false);
                    ncar.setInputType(InputType.TYPE_NULL);
                    ncar.setFocusable(false);


                    nbike.setEnabled(false);
                    nbike.setInputType(InputType.TYPE_NULL);
                    nbike.setFocusable(false);}
                break;

        }



    }
*/

