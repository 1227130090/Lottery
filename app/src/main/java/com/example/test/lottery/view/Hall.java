package com.example.test.lottery.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.example.test.lottery.ConstantValue;
import com.example.test.lottery.R;

/**
 * Created by test on 2016/3/3.
 */
public class Hall extends BaseUI{

    private LinearLayout showInMiddle;
    public Hall(Context context) { //构造
        super(context);
        init();//初始化
    }

    private void init() {
        showInMiddle= (LinearLayout) View.inflate(context, R.layout.il_hall,null);
        //root=null
//        showInMiddle.getLayoutParams()=null;
        //root!=null
        //return root
        if (showInMiddle.getLayoutParams()==null){
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            showInMiddle.setLayoutParams(params);
        }
    }

    @Override
    public View getChild() {

        return showInMiddle;
    }

    @Override
    public int getID() {
        return ConstantValue.VIEW_HALL;
    }
}
