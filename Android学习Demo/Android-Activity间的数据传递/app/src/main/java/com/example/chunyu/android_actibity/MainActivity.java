package com.example.chunyu.android_actibity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        textView1 = (TextView) findViewById(R.id.textView2);
        TextView textView = (TextView) findViewById(R.id.text1);
        textView.setText("点我呀！");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //测试从Intent传递数据
//              test1();
                //测试从Bundle传递数据
//                test2();
                //测试传递值对象方法利用Parcelable
//                test3();
                Intent i = new Intent(MainActivity.this, OtherActivity.class);
                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView1.setText(data.getStringExtra("data"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //通过intent传递数据
    public void test1() {
        Intent i = new Intent(MainActivity.this, OtherActivity.class);
        i.putExtra("data", "我是传递过来的数据");
        startActivity(i);
    }

    //通过Bundle传递数据
    public void test2() {
        Intent i = new Intent(MainActivity.this, OtherActivity.class);
        Bundle b = new Bundle();
        b.putString("data", "我是通过Bundle传递过来的");
        i.putExtra("bundle", b);
        startActivity(i);
    }
    //通过测试传递值对象

    public void test3() {
        Intent i = new Intent(MainActivity.this, OtherActivity.class);
        User user = new User("xiaoyu", 22);
        i.putExtra("user", user);
        startActivity(i);

    }

}
