package com.example.chunyu.databinding;

import android.databinding.ObservableField;
import android.view.View;
import android.widget.CompoundButton;



/**
 * Created by chunyu on 16/1/12.
 */
public class DemoData{
    public final ObservableField <String>  text = new ObservableField<>();
    View.OnClickListener mOnClickListener;
    CompoundButton.OnCheckedChangeListener mOnCheckListener;
    public void setOnClickListener(View.OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }

    public CompoundButton.OnCheckedChangeListener getOnCheckListener() {
        return mOnCheckListener;
    }

    public void setOnCheckListener(CompoundButton.OnCheckedChangeListener mOnCheckListener) {
        this.mOnCheckListener = mOnCheckListener;
    }
}
