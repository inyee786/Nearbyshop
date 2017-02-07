package com.startup.nearbyparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.NullPointerException;
public class Address extends AppCompatActivity {


    Databasehelper myDB;
    EditText et_psname, et_street, et_town, et_city, et_landmark, et_distric, et_state, et_pincode;
    String psname, street, town, city, landmark, distric, state, pincode;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);


        myDB = new Databasehelper(this);
        et_psname = (EditText) findViewById(R.id.editText_psname);
        et_street = (EditText) findViewById(R.id.editText_street);
        et_city = (EditText) findViewById(R.id.editText_city);
        et_town = (EditText) findViewById(R.id.editText_town);
        et_landmark = (EditText) findViewById(R.id.editText_landmark);
        et_distric = (EditText) findViewById(R.id.editText_district);
        et_state = (EditText) findViewById(R.id.editText_state);
        et_pincode = (EditText) findViewById(R.id.editText_pincode);
        btnsubmit = (Button) findViewById(R.id.button_address);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // submitAddress();

                //initializes();


                psname=et_psname.getText().toString().trim();
                street=et_street.getText().toString().trim();
                town=et_town.getText().toString().trim();
                city=et_city.getText().toString().trim();
                distric=et_distric.getText().toString().trim();
                state=et_state.getText().toString().trim();
                pincode = et_pincode.getText().toString().trim();
                landmark=et_landmark.getText().toString().trim();




                if (!validate()) {
                    Toast.makeText(Address.this, "Address cant be added", Toast.LENGTH_SHORT).show();
                } else {
//        AddAddress();

                    boolean insertAddress = myDB.address(psname, street, town, city,landmark, distric, state, pincode);

                    if (insertAddress) {
                        Toast.makeText(Address.this, "data inserted Owner ", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(Address.this, Fare.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Address.this, "data  cannot be inserted ", Toast.LENGTH_SHORT).show();
                    }




                }






            }
        });




    }


    public void submitAddress() {

        initializes();

        if (!validate()) {
            Toast.makeText(Address.this, "Address cant be added", Toast.LENGTH_SHORT).show();
        } else {
//        AddAddress();

            boolean insertAddress = myDB.address(psname, street, town, city,landmark, distric, state, pincode);

            if (insertAddress) {
                Toast.makeText(Address.this, "data inserted user", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Address.this, Fare.class);
                startActivity(i);
            } else {
                Toast.makeText(Address.this, "data  cannot be inserted user", Toast.LENGTH_SHORT).show();
            }




        }


}




    public void initializes(){
        psname=et_psname.getText().toString().trim();
        street=et_street.getText().toString().trim();
        town=et_town.getText().toString().trim();
        city=et_city.getText().toString().trim();
        distric=et_distric.getText().toString().trim();
        state=et_state.getText().toString().trim();
        pincode=et_pincode.getText().toString().trim();
        landmark=et_landmark.getText().toString().trim();
    }


    public boolean validate()
    {
        boolean valid=true;
        if(psname.isEmpty()||psname.length()<5)
        {
            Toast.makeText(Address.this,"fill the psname",Toast.LENGTH_LONG).show();
            et_psname.setError("enter the name of parking space");
            valid=false;
        }
        if(street.isEmpty()||street.length()<5)
        {
            et_psname.setError("enter the valid street");
         valid=false;
        }
        if(town.isEmpty()||town.length()<5)
        {
            et_town.setError("enter the valid Town name");
            valid=false;
        }
        if(city.isEmpty()||city.length()<5)
        {
            et_city.setError("enter the valid city name");
            valid=false;
        }
        if(distric.isEmpty()||distric.length()<5)
        {
            et_distric.setError("enter the valid Distict name");
            valid=false;
        }

        if(state.isEmpty()||state.length()<5)
        {
            et_state.setError("enter the valid state name");
            valid=false;
        }
        if (pincode.isEmpty() || pincode.length() < 6 || pincode.length()>6)
        {
            et_psname.setError("enter the valid stree");
            valid=false;
        }
        if(landmark.isEmpty()||landmark.length()<6)
        {
            et_landmark.setError("enter the valid stree");
            valid=false;
        }

return valid;
    }


    public void AddAddress(){
        boolean insertAddress = myDB.address(psname, street, town, city,landmark, distric, state, pincode);

        if (insertAddress) {
            Toast.makeText(Address.this, "data inserted user", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(Address.this, Fare.class);
            startActivity(i);
        } else {
            Toast.makeText(Address.this, "data  cannot be inserted user", Toast.LENGTH_SHORT).show();
        }

    }




}
