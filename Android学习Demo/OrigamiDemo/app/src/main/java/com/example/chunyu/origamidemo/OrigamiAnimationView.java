package com.example.chunyu.origamidemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

public class OrigamiAnimationView extends FrameLayout {

    private final SpringSystem springSystem;
    private final Spring popAnimationSpring;
    private final Spring popAnimationSpring;
    private final View layer;

    public OrigamiAnimationView(Context context) {
        this(context, null);
    }

    public OrigamiAnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrigamiAnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // Hook up variables to your views here
        layer = null;

        springSystem = SpringSystem.create();

        popAnimationSpring = springSystem.createSpring()
                .setSpringConfig(SpringConfig.withBouncinessAndSpeed(10, 6))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setPopAnimationProgress((float) spring.getCurrentValue());
                    }
                });

        popAnimationSpring = springSystem.createSpring()
                .setSpringConfig(SpringConfig.withBouncinessAndSpeed(9, 20))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setPopAnimationProgress((float) spring.getCurrentValue());
                    }
                });
    }

    // popAnimation transition

    public void popAnimation(boolean on) {
        popAnimationSpring.setEndValue(on ? 1 : 0);
    }

    public void setPopAnimationProgress(float progress) {
        float transition12 = transition(progress, 0f, 360f);
        layer.setRotation(transition12);

        float transition22 = transition(progress, 1f, 2f);
        layer.setScaleX(transition22);
        layer.setScaleY(transition22);
    }

    // popAnimation transition

    public void popAnimation(boolean on) {
        popAnimationSpring.setEndValue(on ? 1 : 0);
    }

    public void setPopAnimationProgress(float progress) {
        float reverse2 = transition(progress, 1f, 0f);
    }

    // Utilities

    public float transition (float progress, float startValue, float endValue) {
        return (float) SpringUtil.mapValueFromRangeToRange(progress, 0, 1, startValue, endValue);
    }

}