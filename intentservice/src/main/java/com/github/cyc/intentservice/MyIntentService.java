package com.github.cyc.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by cyc on 2017/9/24.
 */

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";

    // Action
    public static final String ACTION_DO_TASK1 = "com.github.cyc.intentservice.MyIntentService.do_task1";
    public static final String ACTION_DO_TASK2 = "com.github.cyc.intentservice.MyIntentService.do_task2";

    public MyIntentService() {
        // 指定HandlerThread线程名
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate(), current thread is " + Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand(), current thread is " + Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Log.i(TAG, "onHandleIntent(), current thread is " + Thread.currentThread().getName());
            if (ACTION_DO_TASK1.equals(intent.getAction())) {
                // 执行任务1
                doTask1();
            } else if (ACTION_DO_TASK2.equals(intent.getAction())) {
                // 执行任务2
                doTask2();
            }
        }
    }

    private void doTask1() {
        Log.i(TAG, "doTask1(), start");

        // 模拟耗时任务
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "doTask1(), end");
    }

    private void doTask2() {
        Log.i(TAG, "doTask2(), start");

        // 模拟耗时任务
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "doTask2(), end");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy(), current thread is " + Thread.currentThread().getName());
    }
}
