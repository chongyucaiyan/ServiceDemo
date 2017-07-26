package com.github.cyc.lifecycle;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private LocalService mLocalService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected()");
            mLocalService = ((LocalService.LocalBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected()");
            mLocalService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContentView();
    }

    private void initContentView() {
        findViewById(R.id.btn_start_service).setOnClickListener(this);
        findViewById(R.id.btn_stop_service).setOnClickListener(this);
        findViewById(R.id.btn_bind_service).setOnClickListener(this);
        findViewById(R.id.btn_unbind_service).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_service:
                Intent startIntent = new Intent(this, LocalService.class);
                startService(startIntent);
                break;

            case R.id.btn_stop_service:
                Intent stopIntent = new Intent(this, LocalService.class);
                stopService(stopIntent);
                break;

            case R.id.btn_bind_service:
                Intent bindIntent = new Intent(this, LocalService.class);
                bindService(bindIntent, mServiceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btn_unbind_service:
                unbindService(mServiceConnection);
                break;

            default:
                break;
        }
    }
}
