package com.example.chunyu.qqmusictest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
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
    private ImageView mTarget;
    private ImageView mTop;
    private ImageView mBotton;
    private SpringSystem springSystem;
    private Spring popAnimationSpring;
    boolean on = false;

    private float mPlayIconStartX;
    private float mPlayIconStartY;
    private float mRealPlayIconEndX;
    private float mRealPlayIconEndY;

    private float mTopStartY;
    private float mBottomStartY;
    private Animation mUpAnim, mDownAnim;

    private Long ANIMATION_DURATION = 300L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayIcon = (ImageView) findViewById(R.id.myPlayIcon);
        mPlayView = findViewById(R.id.myPlayView);
        mPlayIcon.setOnClickListener(this);
        mRealImage = (ImageView) findViewById(R.id.myRealPlayImage);
        mTop = (ImageView) findViewById(R.id.myTop);
        mTarget = (ImageView) findViewById(R.id.myTarget);
        mBotton = (ImageView) findViewById(R.id.myBottom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int[] a = new int[]{0, 0};
                int[] b = new int[]{0, 0};

                int[] c = new int[]{0, 0};
                int[] d = new int[]{0, 0};
                mPlayIcon.getLocationOnScreen(a);
                mPlayIconStartX = a[0];
                mPlayIconStartY = a[1];
                Log.i("chunyutest", "mPlayIconStartX:" + mPlayIconStartX + "    mPlayIconStartY:" + mPlayIconStartY);
                mTarget.getLocationOnScreen(b);
                mRealPlayIconEndX = b[0];
                mRealPlayIconEndY = b[1];
                Log.i("chunyutest", "mRealPlayIconEndX:" + mRealPlayIconEndX + "    mRealPlayIconEndY:" + mRealPlayIconEndY);

                mTop.getLocationOnScreen(c);
                Log.i("chunyutest", "mTopEndtY:" + mTopStartY);
                mTopStartY = c[1];
                mBotton.getLocationOnScreen(d);
                mBottomStartY = d[1];
            }
        }, 1000);
        initAnimSystem();
        initAnim();
    }

    private void initAnim() {
        if (mUpAnim == null) {
            mUpAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
            mUpAnim.setDuration(300L);
            mUpAnim.setFillAfter(true);
        }
        if (mDownAnim == null) {
            mDownAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
            mDownAnim.setDuration(300L);
        }
    }

    @Override
    public void onClick(View view) {
        popAnimation();
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

    public void popAnimation() {
        on = !on;
        popAnimationSpring.setEndValue(on ? 1.0 : 0.0);
        mTop.startAnimation(on ? mUpAnim : mDownAnim);
        mPlayView.setAlpha(on ? 1.0f : 0.0f);
    }


    public void setPopAnimationProgress(float progress) {
        float realx = transition(progress, 0, mRealPlayIconEndX - mPlayIconStartX);
        float realy = transition(progress, 0, mRealPlayIconEndY - mPlayIconStartY);
        float scalex = transition(progress, 1.0f, 5.0f);
        float scaley = transition(progress, 1.0f, 5.0f);
//        float topy = transition(progress, 0, mTopStartY + 200);
        float bottomy = transition(progress, mBottomStartY, -300);
        mRealImage.setTranslationX(realx);
        mRealImage.setTranslationY(realy);
        mRealImage.setScaleY(scaley);
        mRealImage.setScaleX(scalex);
//        mTop.setTranslationY(topy);
        mBotton.setTranslationY(bottomy);

    }

    // Utilities
    public float transition(float progress, float startValue, float endValue) {
        return (float) SpringUtil.mapValueFromRangeToRange(progress, 0, 1, startValue, endValue);
    }

}
