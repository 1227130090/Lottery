package com.example.test.lottery.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.example.test.lottery.ConstantValue;


/**
 * import org.w3c.dom.Text;
 * <p/>
 * /**
 * 第一个 简单的界面
 */
public class FirstUI extends BaseUI {

    //传递上下文


    @Override
    public void setListener() {

    }

    @Override
    public void init() {

    }

    public FirstUI(Context content) {
        super(content);

    }

    //获取需要在中间容器加载的空间
    public View getChild() {

        //简单界面：
        TextView textView = new TextView(context);

        LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        textView.setLayoutParams(layoutParams);

        textView.setBackgroundColor(Color.BLUE);
        textView.setText("这是第一个界面");

        return textView;

    }

    @Override
    public int getID() {
        return ConstantValue.VIEW_FIRST;
    }

}
