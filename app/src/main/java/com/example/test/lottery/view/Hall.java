package com.example.test.lottery.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test.lottery.ConstantValue;
import com.example.test.lottery.R;

/**
 * Created by test on 2016/3/3.
 */
public class Hall extends BaseUI {

    //第一步；加载layout（布置参数设置）
    //第二步；初始化layout中控件
    //第三步；设置监听


    private TextView ssqIssue;
    private ImageView ssqBet;

    public Hall(Context context) { //构造
        super(context);

    }


    public void init() {
        showInMiddle = (LinearLayout) View.inflate(context, R.layout.il_hall, null);
        ssqIssue = (TextView)findViewById(R.id.ii_hall_ssq_summary);//初始化
        ssqBet = (ImageView) findViewById(R.id.ii_hall_ssq_bet);
    }

    @Override
    public int getID() {
        return ConstantValue.VIEW_HALL;
    }

    public void setListener() {
        ssqBet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    }

}
