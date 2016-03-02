package com.example.test.lottery.util;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;



/**
 * 淡入淡出的切换
 */
public class FadeUtil {
    //当前正在展示的淡出，动画的执行时间
    //在执行过程中，第二个界面处于等待状态
    //第二个界面淡入，动画的执行时间

    private static Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            View view = (View) msg.obj;

            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);

        }

    };

    //淡出
    //      view       执行动画的界面
    //      duration   执行的时间
    public static void fadeOut(final View view, long duration) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(duration);

        //动画执行完之后，做删除view 的操作
        //增加动画执行完之后的监听
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // 做删除view 的操作

                //获取view 父容器 —— RelativeLayout ，removeView
//                ViewGroup parent = (ViewGroup) view.getParent();
//                parent.removeView(view);
                //2.3模拟器，抛异常  4.0 可以

                Message msg = Message.obtain();
                msg.obj=view;
                handler.sendMessage(msg);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(alphaAnimation);
    }

    //淡入
    // view  执行动画的界面
    // delay 等待的时间（淡出的界面执行动画时间相等）
    // deation  执行时间
    public static void fadeIn(View view, long delay, long duration) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);

        //设置延时时间
        alphaAnimation.setStartOffset(delay);

        alphaAnimation.setDuration(duration);
        view.startAnimation(alphaAnimation);

    }

}
