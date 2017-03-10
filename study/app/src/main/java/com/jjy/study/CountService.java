package com.jjy.study;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Random;

public class CountService extends Service {

    private static final String TAG = CountService.class.getSimpleName();
    private int mCurNum = 0;
    private Thread mCountThread = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        //Log.d(TAG, "onStartCommand count:" + mCurNum++);

        Intent notiIntent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, notiIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Notification noti = new NotificationCompat.Builder(this)
                .setContentTitle("Count Service")
                .setContentText("Running Count Service")
                .setContentIntent(pIntent)
                .build();
        // ====================================================================

        // 2. 포그라운드 서비스 설정 (지각할 수 있는 서비스가 된다.)
        // ====================================================================
        startForeground(new Random(), noti);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "i:" + i);
                }
            }
        }).start();

        return START_STICKY;
    }
}
