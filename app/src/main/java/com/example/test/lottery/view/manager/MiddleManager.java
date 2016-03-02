package com.example.test.lottery.view.manager;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.example.test.lottery.R;
import com.example.test.lottery.view.BaseUI;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 中间容器管理工具
 * Created by test on 2016/3/2.
 */
public class MiddleManager {

    private static final String TAG = "MiddleManager";
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

    //存储 创建过 的集合  用来存储
    private Map<String, BaseUI> VIEWCACHE = new HashMap<String, BaseUI>();//K:唯一标识BaseUI子类

    /**
     * 切换界面: 解决问题：“在标题容器中每次点击都在创建一个目标界面”
     */
    public void changeUI(Class<? extends BaseUI> targetClazz) {
        BaseUI targetUI=null;
        //一旦创建过，重用
        //判断是否创建了——曾经创建过的界面需要存储
        String key = targetClazz.getSimpleName();
        if (VIEWCACHE.containsKey(key)) {
         //创建了，重用
            targetUI=VIEWCACHE.get(key);
        }else {
            //否则，创建

            Constructor<? extends BaseUI> constructor;
            try {
                constructor = targetClazz.getConstructor(Context.class);
                targetUI=constructor.newInstance(getContext());
                VIEWCACHE.put(key,targetUI);
            } catch (Exception e) {
               throw new RuntimeException("constructor new instance error");
            }
        }
        Log.i(TAG,targetUI.toString());
        //切换界面核心代码
        middle.removeAllViews();
        // FadeUtil.fadeOut(child1, 2000);
        View child = targetUI.getChild();
        middle.addView(child);
        child.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ia_view_change));
        // FadeUtil.fadeIn(child, 2000, 1000);

    }

    public void changeUI1(BaseUI ui) {
        //切换界面核心代码
        middle.removeAllViews();
        // FadeUtil.fadeOut(child1, 2000);
        View child = ui.getChild();
        middle.addView(child);
        child.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ia_view_change));
        // FadeUtil.fadeIn(child, 2000, 1000);

    }

    public Context getContext() {
        return middle.getContext();
    }
}
