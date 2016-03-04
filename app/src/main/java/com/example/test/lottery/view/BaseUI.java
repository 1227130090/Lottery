package com.example.test.lottery.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by test on 2016/3/2.
 */
public abstract class BaseUI implements View.OnClickListener {

    protected Context context;

    protected ViewGroup showInMiddle;//显示到中间容器

    //设置监听
    public abstract void setListener();

    //初始化
    public abstract void init();

    public BaseUI(Context context) {
        this.context = context;
        init();//初始化
        setListener();
    }

    /**
     * 获取需要在中间容器加载的内容
     */
    public View getChild() {
        //设置layout参数
        //root=null
        // showInMiddle.getLayoutParams()=null;
        //root!=null
        //return root
        if (showInMiddle.getLayoutParams() == null) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            showInMiddle.setLayoutParams(params);

            //设置layout参数

        }
        return showInMiddle;
    }

    //获取每个界面的标识--容器联动的比对依据

    public abstract int getID();

    @Override
    public void onClick(View v) {

    }

    public View findViewById(int id){
        return showInMiddle.findViewById(id);
    }
}
