package com.example.test.lottery.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by test on 2016/3/2.
 */
public class SecondUI extends BaseUI{

    private TextView textView;

    public SecondUI(Context context){
        super(context);
        init();//放在构造器里只用一次

    }

    //初始化：调用一次
    private void init(){
        textView =new TextView(context);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams =new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        textView.setLayoutParams(layoutParams);

        textView.setBackgroundColor(Color.RED);
        textView.setText("这是第二个界面");
    }

    public View getChild()
    {
        //简单界面


        return textView;
    }
}
