package com.example.sendbroadcastbetweenapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ReceiverBroadcast receiverBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiverBroadcast = new ReceiverBroadcast();
        IntentFilter intentFilter = new IntentFilter("com.murali.broadcast2");
        registerReceiver(receiverBroadcast, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiverBroadcast);
    }
}