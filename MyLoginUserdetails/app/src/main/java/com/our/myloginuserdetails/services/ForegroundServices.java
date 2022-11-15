package com.our.myloginuserdetails.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.our.myloginuserdetails.R;

public class ForegroundServices extends AppCompatActivity {
    public static final String TAG=ForegroundServices.class.getName();
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate() method called");
        setContentView(R.layout.activity_foreground_services);
        editTextInput = findViewById(R.id.edit_text_input);
    }
    public void startForegroundService(View v) {
        String input = editTextInput.getText().toString();

        Intent serviceIntent = new Intent(this, ExampleForgroundServices.class);
        serviceIntent.putExtra("inputExtra", input);

        ContextCompat.startForegroundService(this, serviceIntent);
        Log.d(TAG,"startServices()  method called");
        Toast.makeText(this,"Foreground Services Started",Toast.LENGTH_LONG).show();
    }

    public void stopForegroundService(View v) {
        Intent serviceIntent = new Intent(this,ExampleForgroundServices.class);
        stopService(serviceIntent);
        Log.d(TAG,"stopService() method called");
        Toast.makeText(this,"Foreground Services Stopped",Toast.LENGTH_LONG).show();

    }
    public void backButton(View view){
        finish();
        Log.d(TAG,"stop the foregroundServices Activity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"stop the foregroundServices Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"stop the foregroundServices Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
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
