package com.our.myloginuserdetails.boundedservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExampleMyServices extends Service {
    ScheduledExecutorService myscheduler_excutor;

    private IBinder mbinder=new Binder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        myscheduler_excutor= Executors.newScheduledThreadPool(1);
        myscheduler_excutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
               BoundedServices.textView.setText("current date"+new Date());
            }
        },1,1, TimeUnit.SECONDS);
        return mbinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        myscheduler_excutor.shutdown();
        return super.onUnbind(intent);
    }
}
