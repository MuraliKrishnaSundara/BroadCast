package com.example.receivenameandimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnSend;
    private TextView mTvName;
    private TextView mTvAge;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mBtnSend = findViewById(R.id.btnSend);
        mTvName = findViewById(R.id.tvName);
        mTvAge = findViewById(R.id.tvAge);
        registerLocalReceiver();
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.murali.broadcast");
                intent.putExtra("name", "Murali Krishna");
                intent.putExtra("age", "23 years");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    private void registerLocalReceiver() {
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.murali.broadcast");
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    private class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String name = intent.getStringExtra("name");
                mTvName.setText(name);
                String age = intent.getStringExtra("age");
                mTvAge.setText(age);
            }
        }
    }
}