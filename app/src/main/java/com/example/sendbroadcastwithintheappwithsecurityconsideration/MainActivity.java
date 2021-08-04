package com.example.sendbroadcastwithintheappwithsecurityconsideration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnSend;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mBtnSend = findViewById(R.id.btnSendMessage);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.murali.broadcast");
                intent.putExtra("message", "Hello from First Activity");
                localBroadcastManager.sendBroadcast(intent);
                Intent intentStart = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentStart);
            }
        });
    }

}