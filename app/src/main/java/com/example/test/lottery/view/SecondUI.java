package com.example.test.lottery.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import android.widget.TextView;

/**
 * Created by test on 2016/3/2.
 */
public class SecondUI {

    private Context context;
    public SecondUI(Context context){
        super();
        this.context= context;
    }


    public View getChild()
    {
        //简单界面
        TextView textView =new TextView(context);
        LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams =new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        textView.setLayoutParams(layoutParams);

        textView.setBackgroundColor(Color.RED);
        textView.setText("这是第二个界面");

        return textView;
    }
}
