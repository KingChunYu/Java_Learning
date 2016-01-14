package com.example.chunyu.animatorpro;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    MyAnimView myAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = (TextView)findViewById(R.id.myTextView);
        myAnimView = (MyAnimView)findViewById(R.id.myAnimView);
        myAnimView.startAnimation();

    }

    void animatorWithObjectEvaluator(TextView textView) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(300, 300);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), p1, p2);
        anim.setDuration(5000);
    }
}
