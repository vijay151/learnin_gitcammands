package com.our.myloginuserdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.our.myloginuserdetails.services.StartServices;


public class UserDetails extends AppCompatActivity {
    public static final String TAG=UserDetails.class.getName();
    /**
     * Creating varibles for our user details text view
     *Button for back sreen and logout
     */
    private TextView username,emailAdress;
    private Button backbtn,logoutbtn, startServicesbtn;

    /**
     *   initializing our variables
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate() method start");

        setContentView(R.layout.activity_user_details);
        /**
         * initializing our variables
         */
        username=findViewById(R.id.usernameview);
        emailAdress=findViewById(R.id.userEmailaddress);
        backbtn=findViewById(R.id.idBtnBack);
        logoutbtn=findViewById(R.id.idlogoutbtn);
        startServicesbtn=findViewById(R.id.idstartServicebtn);
        /**
         * getting data from intent
         */

        String name=getIntent().getStringExtra("username");
        String email=getIntent().getStringExtra("emailAddress");

        /**
         * setting data to our text view
         */
        username.setText(name);
        emailAdress.setText(email);
        /**
         * setting back button
         * when the user click back button it will go to mainactivity class
         *
         */
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Back Button pressed ");
                Intent intent=new Intent(UserDetails.this,MainActivity.class);
                startActivity(intent);

                Toast.makeText(UserDetails.this,"Login Page",Toast.LENGTH_LONG).show();
            }
        });


        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Logout Button pressed");
                finish();
                Toast.makeText(UserDetails.this,"Log out Success",Toast.LENGTH_LONG).show();
            }
        });

        startServicesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(UserDetails.this, StartServices.class);
                Log.d(TAG,"Start services Button pressed");
                startActivity(i);

            }
        });

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
        Log.d(TAG,"onStop() method called");

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