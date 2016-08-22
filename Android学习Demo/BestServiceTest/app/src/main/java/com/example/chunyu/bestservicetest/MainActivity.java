package com.example.chunyu.bestservicetest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    MyService.MyBinder myBinder;


    Button mBtn;
    Button mBtn2;
    private ServiceConnection MyServiceconnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("chunyutest:", componentName.getClassName());
            myBinder = (MyService.MyBinder) iBinder;
            myBinder.play();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.mBtn);
        mBtn.setOnClickListener(this);
        mBtn2 = (Button)findViewById(R.id.mBtn2);
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mBtn:
                Intent intent = new Intent(this, MyService.class);
                bindService(intent, MyServiceconnection, BIND_AUTO_CREATE);
                break;
            case R.id.mBtn2:
               NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(this);
                mBuilder.setSmallIcon(R.drawable.anchor_type_star)
                        .setContentText("My notification")
                        .setContentTitle("Hello World");
                Intent resultIntent = new Intent(this,MainActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                stackBuilder.addNextIntent(resultIntent);

                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1,mBuilder.build());


                break;


        }
    }

}
