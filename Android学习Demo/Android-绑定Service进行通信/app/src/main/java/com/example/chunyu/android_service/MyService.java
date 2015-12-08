package com.example.chunyu.android_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.telecom.Call;

public class MyService extends Service {
    public MyService() {
    }

    private boolean runing = false;
    private String data = "测试数据";

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyService.Binder();
    }

    public class Binder extends android.os.Binder {
        public void setData(String data) {
            MyService.this.data = data;
        }

        public MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        runing = true;
        new Thread() {
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (runing) {
                    try {
                        String str = "操作" + i++;
                        if (callback != null) {
                            callback.onDataChange(str);
                        }
                        sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    private Callback callback = null;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }

    public static interface Callback {
        void onDataChange(String data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        runing = false;
    }
}
