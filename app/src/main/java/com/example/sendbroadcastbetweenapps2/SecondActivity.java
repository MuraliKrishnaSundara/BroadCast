package com.example.sendbroadcastbetweenapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTvData = findViewById(R.id.tvData);
        Intent intent = getIntent();
        String data = intent.getStringExtra("key");
        mTvData.setText(data);
    }
}