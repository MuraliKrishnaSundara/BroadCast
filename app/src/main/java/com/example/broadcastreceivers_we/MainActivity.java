package com.example.broadcastreceivers_we;

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
    private TextView mTvData;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mBtnSend = findViewById(R.id.btnSend);
        mTvData = findViewById(R.id.tvData);
        registerLocalReceiver();
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.murali.broadcast");
                intent.putExtra("key", "Hello Masai School");
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
                String data = intent.getStringExtra("key");
                mTvData.setText(data);
            }
        }
    }
}