package com.example.chunyu.animatorpro;

import android.animation.TypeEvaluator;

/**
 * Created by chunyu on 16/1/14.
 */
public class AlphaEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Alpha startAlpha = (Alpha) startValue;
        Alpha endAlpha = (Alpha) endValue;
        float alpha = startAlpha.getAlpha() + fraction * (endAlpha.getAlpha() - startAlpha.getAlpha());
        Alpha a = new Alpha(alpha);
        return a;
    }

}
