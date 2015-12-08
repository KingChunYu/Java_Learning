package com.example.chunyu.android_actibity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    TextView tv = null;
    EditText editText = null;
    Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        //检验通过Intent传递过来的数据
//        result1();
        //检验通过 Bundle传递过来的数据
//          result2();
        //检查通过Parclelabe传递过来的值对象方法
//        result3();
        //测试从另一activity传回数据
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("data", editText.getText().toString());
                setResult(1, i);
                finish();
            }
        });

    }

    // 获取Intent数据
    public void result1() {
        Intent i = getIntent();
        tv.setText(i.getStringExtra("data"));
    }

    // 获取Bundle传递过来的数据

    public void result2() {
        Intent i = getIntent();
        Bundle bundle = i.getBundleExtra("bundle");
        tv.setText(bundle.getString("data"));
    }

    // 获取通过Parcelable 传递来的值对象方法
    public void result3() {
        Intent i = getIntent();
        User user = i.getParcelableExtra("user");
        tv.setText(user.getName());
    }
}
