package com.example.chunyu.animatorpro;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chunyu on 16/1/14.
 */
public class MyAnimView extends View {
    public static final float RADIUS = 50f;
    private Point currentPoint;
    private Paint mPaint;


    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);

        } else {
            drawCircle(canvas);
        }
    }

    void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    void startAnimation() {
        Point startPoint = new Point(RADIUS, RADIUS);
        Point endPoint = new Point(300, 300);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });


        Alpha startAlpha = new Alpha(1);
        Alpha endAlpha = new Alpha(0);
        Alpha endAlpha1 = new Alpha(1);
        ValueAnimator alphaAnim = ValueAnimator.ofObject(new AlphaEvaluator(), startAlpha, endAlpha,endAlpha1);
        alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Alpha alpha = (Alpha)animation.getAnimatedValue();
                mPaint.setAlpha((int)(alpha.getAlpha()*256));
                invalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(anim).with(alphaAnim);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }
}
