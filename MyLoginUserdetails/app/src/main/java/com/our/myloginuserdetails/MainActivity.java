package com.our.myloginuserdetails;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG=MainActivity.class.getName();
    /**
     * creating a variables our edit text and buttons.
     */
    protected EditText usernameEt,emailaddressEt,passwordEt;
    protected Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"oncreate() method called");

        setContentView(R.layout.activity_main);
        TextView tv=findViewById(R.id.idTVHeader);
        /**
         *   initializing our edit text  and buttons.
         */
        usernameEt = findViewById(R.id.idUserName);
        emailaddressEt = findViewById(R.id.idEmailAddress);
        passwordEt = findViewById(R.id.idPassword);
        login=findViewById(R.id.idBtnLogin);

        /**
         *   adding on click listener for our button.
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Login Button   pressed");

                /**
                 * on below line we are getting data from our edit text.
                 */

                String emailAddress = emailaddressEt.getText().toString().trim();
                String password = passwordEt.getText().toString().trim();
                /**
                 * checking if the entered text is empty or not.
                 */
                if (TextUtils.isEmpty(emailAddress) && TextUtils.isEmpty(password)) {

                    Toast.makeText(MainActivity.this, "Please Enter the email id and password", Toast.LENGTH_LONG).show();
                } else{
                    /**
                     * calling a method to login our user.
                     */
                    loginSuccess(emailAddress,password);

                    Log.d(TAG,"loginsucess () called");

                }


            }
        });
    }

    /**
     * creating loginSuccess function for validating the email id and password
     * @param email
     * @param password
     */
    private void loginSuccess( String email, String password ) {

        /**
         *  calling a method to login a user.
         */
        Loginvalidation loginresult=new Loginvalidation(email,password);
        int logincode=loginresult.loginCheck();

        /**
         * geting user name data from user name Edit Text view
         */
        String username = usernameEt.getText().toString().trim();

        if(logincode==1){
            Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,UserDetails.class);
            /**
             * passing the data using putExtra fun
             */
            i.putExtra("username",username);
            i.putExtra("emailAddress",email);
            startActivity(i);
            Log.d(TAG,"startActivity() services start");

        }
        else {
            Log.d(TAG,"User Enter Invalid email and password");
            Toast.makeText(this,"Please Enter the Valid login Details",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onstart() method called");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() method called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause() method called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onstop() method called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart() method called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() method called");

    }
}
