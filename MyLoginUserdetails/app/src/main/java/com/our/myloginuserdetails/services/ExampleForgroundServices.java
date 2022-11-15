package com.our.myloginuserdetails.services;

import static com.our.myloginuserdetails.App.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.our.myloginuserdetails.IAdditions;
import com.our.myloginuserdetails.R;

public class ExampleForgroundServices extends Service {
    public static final String TAG=ExampleForgroundServices.class.getName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate() method called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand() method called");

        String input = intent.getStringExtra("inputExtra");

        Intent notificationIntent = new Intent(this, ForegroundServices.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent,PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);
        Log.d(TAG,"startForeground() method called");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() method called");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG,"onBind() method return the ibinder object");
        return ibinder;
    }

    IAdditions.Stub ibinder= new IAdditions.Stub() {
        @Override
        public int add(int x, int y) throws RemoteException {
            Log.d(TAG,"onadd() method executed");
            return x+y;
        }

        @Override
        public int multi(int x, int y) throws RemoteException {
            Log.d(TAG,"multi() method executed");
            return x*y;
        }
    };
}