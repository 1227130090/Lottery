package com.example.test.lottery;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.example.test.lottery.util.FadeUtil;
import com.example.test.lottery.view.BaseUI;
import com.example.test.lottery.view.FirstUI;
import com.example.test.lottery.view.SecondUI;
import com.example.test.lottery.view.manager.BottomManager;
import com.example.test.lottery.view.manager.TitleManager;


public class MainActivity extends Activity {

    private RelativeLayout middle;//中间站着位置的容器

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //changeUI();//加载第二个界面
            changeUI(new SecondUI(MainActivity.this));

            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    private void init() {
        TitleManager manager = TitleManager.getInstance();
        manager.init(this);
        manager.showUnLoginTitle();

        BottomManager.getInstrance().init(this);
        BottomManager.getInstrance().showCommonBottom();

        middle = (RelativeLayout) findViewById(R.id.ii_middle);
        loadFirstUI();
        //当第一个界面加载完2秒钟后，第二个界面显示
        handler.sendEmptyMessageDelayed(110, 2000);


    }

    View child1;

    private void loadFirstUI() {
        FirstUI firstUI = new FirstUI(this);
        child1 = firstUI.getChild();
        middle.addView(child1);
    }
    //当第一个界面加载完2秒钟后，第二个界面显示

    private void loadSecondUI() {
        SecondUI secondUI = new SecondUI(this);
        View child = secondUI.getChild();
        //切换界面核心方法二
        middle.addView(child);//中间容器加载

        //执行切换动画
        FadeUtil.fadeIn(child,2000,1000);
        //child.startAnimation(AnimationUtils.loadAnimation(this, R.anim.ia_view_change));
    }

    protected void changeUI(BaseUI ui)
    {
        //切换界面核心代码

        middle.removeAllViews();
        View child =ui.getChild();
        middle.addView(child);
        child.startAnimation(AnimationUtils.loadAnimation(this,R.anim.ia_view_change));

    }

    //切换界面
    protected void changeUI() {
        //1.切换界面时清理上一个显示内容
        //切换界面和新方法一
       // middle.removeAllViews();//全删
        FadeUtil.fadeOut(child1,2000);
        //middle.removeView(child1);//只删除一个
        loadSecondUI();

    }
}
