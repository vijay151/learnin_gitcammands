package com.our.myloginuserdetails.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.our.myloginuserdetails.R;
import com.our.myloginuserdetails.boundedservices.BoundedServices;

public class StartServices extends AppCompatActivity {
    public static final String TAG=StartServices.class.getName();
 Button forgroung ,background, aidlservice ,backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_services);
        forgroung=findViewById(R.id.foregrndbtn);
        background=findViewById(R.id.backgroundbtn);
        aidlservice=findViewById(R.id.calculationBoundbtn);
        backButton=findViewById(R.id.backBtn);

        forgroung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartServices.this,ForegroundServices.class);
                startActivity(intent);
                Log.d(TAG,"ForegroundServices Activity started ");
            }
        });

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartServices.this, BoundedServices.class);
                startActivity(i);
            }
        });

        aidlservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(StartServices.this, Calculation_Aidl.class);
                startActivity(i);

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}