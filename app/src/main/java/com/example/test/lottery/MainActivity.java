package com.example.test.lottery;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.test.lottery.util.FadeUtil;
import com.example.test.lottery.view.BaseUI;
import com.example.test.lottery.view.FirstUI;
import com.example.test.lottery.view.SecondUI;
import com.example.test.lottery.view.manager.BottomManager;
import com.example.test.lottery.view.manager.MiddleManager;
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
        MiddleManager.getInstance().setMiddle(middle);

        //3.建立观察者和被观察者之间的关系（标题和底部导航添加到观察者容器里）
        MiddleManager.getInstance().addObserver(TitleManager.getInstance());
        MiddleManager.getInstance().addObserver(BottomManager.getInstrance());

        MiddleManager.getInstance().changeUI(FirstUI.class);


        //当第一个界面加载完2秒钟后，第二个界面显示
//        handler.sendEmptyMessageDelayed(110, 2000);


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
        FadeUtil.fadeIn(child, 2000, 1000);
        //child.startAnimation(AnimationUtils.loadAnimation(this, R.anim.ia_view_change));
    }

    protected void changeUI(BaseUI ui) {
        //切换界面核心代码
        middle.removeAllViews();
        // FadeUtil.fadeOut(child1, 2000);
        View child = ui.getChild();
        middle.addView(child);
        child.startAnimation(AnimationUtils.loadAnimation(this, R.anim.ia_view_change));
        // FadeUtil.fadeIn(child, 2000, 1000);

    }

    //切换界面
    protected void changeUI() {
        //1.切换界面时清理上一个显示内容
        //切换界面和新方法一
        // middle.removeAllViews();//全删
        FadeUtil.fadeOut(child1, 2000);
        //middle.removeView(child1);//只删除一个
        loadSecondUI();

    }
    /**
     * a。用户 返回键捕捉
     * b。响应返回键--切换到历史界面
     * 记录一下用户操作历史
     * 频繁操作历史
     * 获取了栈顶
     * 有序集合
     *
     * LinkedList<String >-----AndroidStack
     * */

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            boolean result = MiddleManager.getInstance().goBakc();
            //返回键操作失败
            if (!result){
                Toast.makeText(MainActivity.this,"是否退出系统",Toast.LENGTH_LONG).show();
            }

            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
