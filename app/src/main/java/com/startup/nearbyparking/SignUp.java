package com.startup.nearbyparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {


    Databasehelper myDB;
    EditText et_name,et_pnumber,et_email,et_password;
    Button btnsignup;
    String name,pnumber,email,password;
    RadioButton r1;
    RadioGroup rg;
    TextView loginbtn;

//    public static final int RB1_ID = 1000;//first radio button id
  //  public static final int RB2_ID = 1001;//second radio button id



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        myDB = new Databasehelper(this);
        et_name=(EditText)findViewById(R.id.editText_pname);
        et_pnumber=(EditText)findViewById(R.id.editText_pnumber);
        et_password=(EditText)findViewById(R.id.editText_password);
        et_email=(EditText)findViewById(R.id.editText_email);
        btnsignup=(Button)findViewById(R.id.button_singup);
        loginbtn=(TextView)findViewById(R.id.textView_login);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SignUp.this,MainActivity.class);
                startActivity(i);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singup();
            }
        });
    }



    public void singup()
    {
        initializes();
             if(!validate()){
                 Toast.makeText(SignUp.this,"sigup can't be done",Toast.LENGTH_SHORT).show();
                } else {
                    rg = (RadioGroup) findViewById(R.id.radiogroup);
                    int selectOptId = rg.getCheckedRadioButtonId();
                    r1 = (RadioButton) findViewById(selectOptId);
                    Toast.makeText(getApplicationContext(), r1.getText(), Toast.LENGTH_SHORT).show();

                    if (r1.getText().equals( "Are_u_the_Owner")) {
                        boolean insertDataU = myDB.insertdataOwner(name, pnumber, password, email);
                        if (insertDataU) {
                            Toast.makeText(SignUp.this, "data inserted Owner", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUp.this, "data  cannot be inserted owner", Toast.LENGTH_SHORT).show();
                        }

                        Intent i = new Intent(SignUp.this, Fair.class);
                        startActivity(i);
                    }
                    else if (r1.getText().equals("Are_u_the_user")) {
                        boolean insertData = myDB.insertdataUser(name, pnumber, password, email);
                        //  boolean insertDataU = myDB.insertdataUser(name.getText().toString(), pnumber.getText().toString(), password.getText().toString(), email.getText().toString());
                        if (insertData) {
                            Toast.makeText(SignUp.this, "data inserted user", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUp.this, "data  cannot be user", Toast.LENGTH_SHORT).show();}

                        Intent i = new Intent(SignUp.this, MainActivity.class);
                        startActivity(i);
                    }
             }
    }




    public void initializes()
    {
        name=et_name.getText().toString().trim();
        pnumber=et_pnumber.getText().toString().trim();
        email=et_email.getText().toString().trim();
        password=et_password.getText().toString().trim();
    }

    public boolean validate()
    {
        boolean valid=true;

        if(pnumber.isEmpty()||pnumber.length()<10){
            et_pnumber.setError("please enter the valid phone number");
            valid=false;
        }
        if(password.isEmpty()||password.length()<7){
            et_password.setError(" password length 8");
            valid=false;
        }
        if(email.isEmpty()||!isValidEmail(email)) {
            et_name.setError("please enter the valid email");
            valid=false;
        }
        if(name.isEmpty()||name.length()<7) {
            et_name.setError("please enter the valid name");
            valid=false;
        }
        return valid;
    }


    public boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }





/*
    public void tab() {


        if (x == 1) {

            boolean inserData = myDB.insertdataOwner(name, pnumber, password, email);

            //  boolean insertDataU = myDB.insertdataUser(name.getText().toString(), pnumber.getText().toString(), password.getText().toString(), email.getText().toString());


            if (inserData)
                Toast.makeText(SignUp.this, "data inserted  owner", Toast.LENGTH_SHORT).show();
            else

                Toast.makeText(SignUp.this, "data  canot be inserted owner", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(SignUp.this, Address.class);
            startActivity(i);

        }
        if (x == 0) {

            boolean insertDataU = myDB.insertdataUser(name, pnumber, password, email);


            if (insertDataU)
                Toast.makeText(SignUp.this, "data inserted user", Toast.LENGTH_SHORT).show();
            else

                Toast.makeText(SignUp.this, "data  canot be inserted user", Toast.LENGTH_SHORT).show();


            Intent i = new Intent(SignUp.this, ListVeiw.class);
            startActivity(i);

        }
    }











        //function to add  owner detail
    public void adddataOwner(){

                        boolean inserData = myDB.insertdataOwner(name, pnumber, password, email);

                        //  boolean insertDataU = myDB.insertdataUser(name.getText().toString(), pnumber.getText().toString(), password.getText().toString(), email.getText().toString());





                        if (inserData)
                            Toast.makeText(SignUp.this, "data inserted  owner", Toast.LENGTH_SHORT).show();
                        else

                            Toast.makeText(SignUp.this, "data  canot be inserted owner", Toast.LENGTH_SHORT).show();

                    }




    //function to add  user detail
    public void adddatauser(){

                        boolean insertDataU = myDB.insertdataUser(name, pnumber, password, email);





                        if (insertDataU)
                            Toast.makeText(SignUp.this, "data inserted user", Toast.LENGTH_SHORT).show();
                        else

                            Toast.makeText(SignUp.this, "data  canot be inserted user", Toast.LENGTH_SHORT).show();

                    }












                if(r1.isChecked()){
                    x=1;
                }

                else
                {
                    x=0;
                }
System.out.printf(" "+x);

                if(x==1)
                {
                    AdddataOwner();
                }
                else
                {
                    Adddatauser();
                }


                int i=rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)rg.findViewById(i);


                if(rb.getText()=="")
                { AdddataOwner();}
                else
                { Adddatauser();}
*/

            }













/*
    // selection of the type of user
    public void TypeOfUser(View view)
    {
        boolean checked=((RadioButton) view).isChecked();


        switch (view.getId()){


            case R.id.:
                if(checked)
                    x=1;
                else
                    Toast.makeText(SignUp.this, "Select Any Of the option", Toast.LENGTH_LONG).show();
                break;

            case R.id.hv_vechile:
                if(checked)
                    x=0;
                else
                    Toast.makeText(SignUp.this, "Select Any Of the option", Toast.LENGTH_LONG).show();

                break;
        }

    }
*/



/*
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton_hv_v:
                if (checked)
                    x=1;
                break;
            case R.id.radioButton_hv_:
                if (checked)
                    x=0;
                break;
        }
    }

*/





   /*
    //function to owner detail
    public void AdddataOwner(){
        btnsignup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean inserData = myDB.insertdataOwner(name, pnumber, password, email);

                        //  boolean insertDataU = myDB.insertdataUser(name.getText().toString(), pnumber.getText().toString(), password.getText().toString(), email.getText().toString());





                        if (inserData == true)
                            Toast.makeText(SignUp.this, "data inserted owner", Toast.LENGTH_SHORT).show();
                        else

                            Toast.makeText(SignUp.this, "data  canot be inserted owner", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

    //function to add  user detail
    public void Adddatauser(){
        btnsignup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean insertDataU = myDB.insertdataUser(name, pnumber, password, email);





                        if (insertDataU==true)
                            Toast.makeText(SignUp.this, "data inserted user", Toast.LENGTH_SHORT).show();
                        else

                            Toast.makeText(SignUp.this, "data  canot be inserted user", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }


}

*/
/*
 r1.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         x=1;
     }
 });




        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=0;
            }
        });



        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId==R.id.hv)
                    x=1;

                if(checkedId==R.id.hv)
                    x=0;


            }
        });







        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((RadioButton) v).isChecked())
                {
                    x=1;
                }
                else
                {
                    x=0;
                }
            }
        });






rg.clearCheck();






        if(r2.isChecked()){
            x=1;
        }

        if(r1.isChecked())
        {
            x = 0;
        }

        Log.d("SignUp", "Value r2: " + Float.toString(x));*/



/*
//create the RadioButton
        RadioButton rb1 = new RadioButton(this);
//set an id
        rb1.setId(RB1_ID);

        RadioButton rb2 = new RadioButton(this);
//set an id
        rb2.setId(RB2_ID);


        int btn = rg.getCheckedRadioButtonId();
        switch (btn) {
            case :
                =1;
                break;
            case :
                =0;
                break;
            //other checks for the other RadioButtons ids from the RadioGroup
            case -1:
                // no RadioButton is checked inthe Radiogroup
                break;
        }



*/



