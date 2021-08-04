package com.example.sendbroadcastbetweenapps1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mBtnSend;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mBtnSend = findViewById(R.id.btnSendBroadcast);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.murali.broadcast2");
                sendBroadcast(intent);
                Intent intent2 = new Intent();
                intent2.setAction("android.murali.myownaction");
                intent2.setType("plain/text");
                intent2.putExtra("key", "Hello from App 1");

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> list = packageManager.queryIntentActivities(intent,0);
                if (list != null && list.size() >= 1){
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,"No apps found to open intent" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}