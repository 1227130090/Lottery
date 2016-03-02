package com.example.test.lottery.view.manager;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.example.test.lottery.R;
import com.example.test.lottery.view.BaseUI;

/**
 * 中间容器管理工具
 * Created by test on 2016/3/2.
 */
public class MiddleManager {

    private static MiddleManager instance = new MiddleManager();

    private MiddleManager() {
    }

    public static MiddleManager getInstance() {
        return instance;
    }

    private RelativeLayout middle;

    public void setMiddle(RelativeLayout middle) {
        this.middle = middle;
    }

    /**
     * 切换界面
     */
    public void changeUI(BaseUI ui) {
        //切换界面核心代码
        middle.removeAllViews();
        // FadeUtil.fadeOut(child1, 2000);
        View child = ui.getChild();
        middle.addView(child);
        child.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ia_view_change));
        // FadeUtil.fadeIn(child, 2000, 1000);

    }
    public Context getContext(){
        return middle.getContext();
    }
}
