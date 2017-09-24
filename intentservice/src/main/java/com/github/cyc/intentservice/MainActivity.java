package com.github.cyc.intentservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContentView();
    }

    private void initContentView() {
        findViewById(R.id.btn_main_start_service1).setOnClickListener(this);
        findViewById(R.id.btn_main_start_service2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_start_service1:
                // 启动Service
                Intent intent1 = new Intent(this, MyIntentService.class);
                intent1.setAction(MyIntentService.ACTION_DO_TASK1);
                startService(intent1);
                break;

            case R.id.btn_main_start_service2:
                // 启动Service
                Intent intent2 = new Intent(this, MyIntentService.class);
                intent2.setAction(MyIntentService.ACTION_DO_TASK2);
                startService(intent2);
                break;

            default:
                break;
        }
    }
}
