package com.example.chunyu.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.view.View;

import com.example.chunyu.databinding.BR;


/**
 * Created by chunyu on 16/1/12.
 */
public class DemoData{
   public final ObservableField <String>  text = new ObservableField<>();
    View.OnClickListener mOnClickListener;
    public DemoData(View.OnClickListener onClickListener) {
         this.mOnClickListener = onClickListener;
    }
    public void setOnClickListener(View.OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }
}
