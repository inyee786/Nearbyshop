package com.startup.nearbyparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Databasehelper myDB;
    EditText et_email, et_password;
    String email, password;
    Button btadd;
     TextView gotsignup;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new Databasehelper(this);

        et_email = (EditText) findViewById(R.id.editText_email);
        et_password = (EditText) findViewById(R.id.editText_psword);
        btadd = (Button) findViewById(R.id.button_login);
        gotsignup = (TextView) findViewById(R.id.nwsignup);

        session = new Session(this);

        gotsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

    }





    public void Login() {
        initialize();

        if (!validate()) {
            Toast.makeText(this, "login failed", Toast.LENGTH_LONG).show();
        } else {
            if(myDB.getUser(email,password)){
                session.setLoggedin(true);
            } else{
                Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
            }
        }

        if(session.loggedin()){
            Intent i=new Intent(MainActivity.this, List.class);
            startActivity(i);}
    }


    public boolean validate() {
        boolean valid = true;

        if (password.isEmpty()) {
            et_password.setError("please enter the password");
            valid = false;
        }
        if (email.isEmpty()||!isValidEmail(email)) {
            et_email.setError("please enter valid email id");
            valid=false;
            //|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()||
        }
        return valid;
    }



    public void initialize(){
        email=et_email.getText().toString().trim();
        password=et_password.getText().toString().trim();
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }




//Function to move from mainactivity to singup activity
/*    public void TkSignUp()
    {

        gotsignup = (TextView)findViewById(R.id.nwsignup);
        gotsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });


    }


*/


/*
    public void Adddata(){
        btadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       boolean inserData = myDB.insertdataOwner(psname.getText().toString(), pnumber.getText().toString(),password.getText().toString(), email.getText().toString());

                        if(inserData==true)
                            Toast.makeText(MainActivity.this,"data inserted",Toast.LENGTH_LONG).show();
                        else

                            Toast.makeText(MainActivity.this,"data  canot be inserted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
