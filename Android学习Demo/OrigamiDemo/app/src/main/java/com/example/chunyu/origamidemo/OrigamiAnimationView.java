package com.example.chunyu.origamidemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

public class OrigamiAnimationView extends FrameLayout {

    private final SpringSystem springSystem;
    //删除冗余的Spring，
//    private final Spring popAnimationSpring;
    private final Spring popAnimationSpring;
    private final View layer;
    private boolean on = false;

    public OrigamiAnimationView(Context context) {
        this(context, null);
    }

    public OrigamiAnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrigamiAnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.origami_anim_layout,this,true);
        // Hook up variables to your views here
        layer = findViewById(R.id.myImage);//其实就是动画执行的对象
        //自己加的逻辑，控制动画的开启
        layer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                on = !on;//好让动画反复
                popAnimation(on);
            }
        });

        springSystem = SpringSystem.create();

        popAnimationSpring = springSystem.createSpring()
                //Rebound的0.38Api版本已经改名字，origami导出的还是老版本的API名
                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(10, 6))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setPopAnimationProgress((float) spring.getCurrentValue());
                    }
                });

//        popAnimationSpring = springSystem.createSpring()
//                .setSpringConfig(SpringConfig.withBouncinessAndSpeed(9, 20))
//                .addListener(new SimpleSpringListener() {
//                    @Override
//                    public void onSpringUpdate(Spring spring) {
//                        setPopAnimationProgress((float) spring.getCurrentValue());
//                    }
//                });
    }

    // popAnimation transition

    public void popAnimation(boolean on) {
        //setEndValue 内部有开启动画的逻辑，这里算是动画的开关
        popAnimationSpring.setEndValue(on ? 1 : 0);
    }

    public void setPopAnimationProgress(float progress) {
        //旋转360度，这些都是代码生成的
        float transition12 = transition(progress, 0f, 360f);
        layer.setRotation(transition12);
        //放缩倍数1->2,也是代码生成的
        float transition22 = transition(progress, 1f, 2f);
        layer.setScaleX(transition22);
        layer.setScaleY(transition22);
    }

//    // popAnimation transition
//
//    public void popAnimation(boolean on) {
//        popAnimationSpring.setEndValue(on ? 1 : 0);
//    }
//
//    public void setPopAnimationProgress(float progress) {
//        float reverse2 = transition(progress, 1f, 0f);
//    }

    // Utilities

    public float transition (float progress, float startValue, float endValue) {
        return (float) SpringUtil.mapValueFromRangeToRange(progress, 0, 1, startValue, endValue);
    }

}