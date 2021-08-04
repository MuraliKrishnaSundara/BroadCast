package com.example.sendbroadcastwithintheappwithsecurityconsideration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvReceiveMessage;
    private LocalBroadcastManager localBroadcastManager;
    private BroadcastReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mTvReceiveMessage = findViewById(R.id.tvReceiveMessage);
        registerLocalReceiver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    private void registerLocalReceiver() {
        localReceiver = new BroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.murali.broadcast");
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    private class BroadcastReceiver extends android.content.BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String message = intent.getStringExtra("message");
                mTvReceiveMessage.setText(message);
            }
        }
    }
}