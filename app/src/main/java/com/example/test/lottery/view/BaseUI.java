package com.example.test.lottery.view;

import android.content.Context;
import android.view.View;

/**
 * Created by test on 2016/3/2.
 */
public abstract class BaseUI {

    protected Context context;

    public BaseUI (Context context){
        this.context=context;
    }
    /**
     * 获取需要在中间容器加载的内容
     *
     * */
    public abstract View getChild();
}