package com.example.test.lottery.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;


/**
 * import org.w3c.dom.Text;
 * <p/>
 * /**
 * 第一个 简单的界面
 */
public class FirstUI {

    //传递上下文
    private Context content;

    public FirstUI(Context content) {
        super();
        this.content = content;
    }

    //获取需要在中间容器加载的空间
    public View getChild() {

        //简单界面：
        TextView textView = new TextView(content);

        LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        textView.setLayoutParams(layoutParams);

        textView.setBackgroundColor(Color.BLUE);
        textView.setText("这是第一个界面");

        return textView;

    }

}
