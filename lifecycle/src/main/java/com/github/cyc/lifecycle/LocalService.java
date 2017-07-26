package com.github.cyc.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class LocalService extends Service {
    private static final String TAG = "LocalService";

    private final IBinder mBinder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate(), current thread: " + Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand(), current thread: " + Thread.currentThread().getName());
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind(), current thread: " + Thread.currentThread().getName());
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind(), current thread: " + Thread.currentThread().getName());
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy(), current thread: " + Thread.currentThread().getName());
    }

    public class LocalBinder extends Binder {

        public LocalService getService() {
            return LocalService.this;
        }
    }
}
