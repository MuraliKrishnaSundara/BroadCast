package com.example.sendbroadcastbetweenapps2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiving broadcast from other app", Toast.LENGTH_SHORT).show();
    }
}
