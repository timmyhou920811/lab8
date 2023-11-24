package com.example.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.security.Provider;

public class MyService extends Service {

    public void onCreate(){
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                    Intent intent = new Intent(MyService.this, MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyService.this.startActivity(intent);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        stopSelf();
    }
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent,flags,startId);
        return START_STICKY;
    }

    public void onDestroy(){super.onDestroy();}

    public IBinder onBind(Intent intent){
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
