package com.example.chunyu.qqmusictest;

import android.media.Image;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mPlayIcon;
    private View mPlayView;
    private ImageView mRealImage;
    private ImageView mTop;
    private ImageView mBotton;
    private SpringSystem springSystem;
    private Spring popAnimationSpring;
    boolean on = false;

    private float mPlayIconStartX;
    private float mPlayIconStartY;
    private float mRealPlayIconStartX;
    private float mRealPlayIconStartY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayIcon = (ImageView) findViewById(R.id.myPlayIcon);
        mPlayView = findViewById(R.id.myPlayView);
        mPlayView.setOnClickListener(this);

        mRealImage = (ImageView) findViewById(R.id.myRealPlayImage);
        mTop = (ImageView) findViewById(R.id.myTop);
        mBotton = (ImageView) findViewById(R.id.myBottom);

        mPlayIconStartX = mPlayIcon.getX();
        mPlayIconStartY = mPlayIcon.getY();
        Log.i("chunyutest", "mPlayIconStartX:" + mPlayIconStartX + "    mPlayIconStartY:" + mPlayIconStartY);

        mRealPlayIconStartX = mRealImage.getX();
        mRealPlayIconStartY = mRealImage.getY();
        Log.i("chunyutest", "mRealPlayIconStartX:" + mRealPlayIconStartX + "    mRealPlayIconStartY:" + mPlayIconStartY);
    }


    @Override
    public void onClick(View view) {

    }


    private void initAnimSystem() {
        springSystem = SpringSystem.create();
        popAnimationSpring = springSystem.createSpring()
                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(15, 12))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setPopAnimationProgress((float) spring.getCurrentValue());
                    }
                });


    }

    public void popAnimation(boolean on) {

    }


    public void setPopAnimationProgress(float progress) {
        float realx = transition(progress,mPlayIconStartX,mRealPlayIconStartX);
    }

    // Utilities
    public float transition(float progress, float startValue, float endValue) {
        return (float) SpringUtil.mapValueFromRangeToRange(progress, 0, 1, startValue, endValue);
    }

}
