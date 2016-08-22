package com.example.chunyu.android_httpasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    URLConnection urlConnect = url.openConnection();
                    InputStream iStream = urlConnect.getInputStream();
                    InputStreamReader isr = new InputStreamReader(iStream);
                    publishProgress("111","222");
                    BufferedReader br = new BufferedReader(isr);
                    String line;
                    StringBuilder builder = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        builder.append(line);
                    }
                    br.close();
                    isr.close();
                    iStream.close();
                    return builder.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPreExecute() {
                Log.i(TAG, "onPreExecute"+"");
            }

            @Override
            protected void onPostExecute(String s) {
               Log.i(TAG,"onPostExecute"+s);
            }

            @Override
            protected void onProgressUpdate(String... values) {
                Log.i(TAG,"onProgressUpdate:"+values[0]+"    "+values[1]);
            }
        }.execute("http://www.baidu.com");
    }

    public void click1 (View v)
    {
        new AsyncTask<String,String,String>(){
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection connection =  (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("POST");
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    out.writeBytes("username=chunyu");
                    InputStream is = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br  =  new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine())!=null)
                    {
                        sb.append(line);
                    }
                    br.close();
                    isr.close();
                    is.close();
                    return sb.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                Log.i(TAG,s);
            }
        }.execute("http://www.baidu.com");
    }
}
