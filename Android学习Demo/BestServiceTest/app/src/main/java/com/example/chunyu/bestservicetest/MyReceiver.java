package com.example.chunyu.bestservicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by chunyu on 16/8/22.
 */
public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("chunyutest", "onReceive");
        Intent intent1 = new Intent(context, MyService.class);
        context.startService(intent1);
    }
}
