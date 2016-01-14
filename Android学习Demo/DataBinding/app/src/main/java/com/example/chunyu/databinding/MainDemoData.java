package com.example.chunyu.databinding;


import android.view.View;
import android.widget.CompoundButton;

/**
 * Created by chunyu on 16/1/12.
 */
public class MainDemoData {
    public DemoData demoData;
    static  int i = 0;
    public MainDemoData() {
          initDemoData();
    }

    public DemoData getDemoData() {
        return demoData;
    }

    public void setDemoData(DemoData demoData) {
        this.demoData = demoData;

    }
    void initDemoData()
    {
        demoData = new DemoData();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoData.text.set("hello"+i++);
            }
        };
        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println(isChecked);
            }
        };
        demoData.text.set("hello");
        demoData.setOnCheckListener(checkedChangeListener);
        demoData.setOnClickListener(onClickListener);
    }
}
