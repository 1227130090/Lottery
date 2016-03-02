package com.example.test.lottery.view.manager;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.test.lottery.R;

/**
 * 管理标题的工具
 */
public class TitleManager {
    //显示和隐藏

    private RelativeLayout commonContainer;
    private RelativeLayout loginContainer;
    private RelativeLayout unLoginContainer;

    private ImageView goback;//返回
    private ImageView help;//帮助
    private ImageView login;//登陆

    private TextView titleContent;//标题内容
    private TextView userInfo;//用户信息



    public void init (Activity activity){

        commonContainer= (RelativeLayout) activity.findViewById(R.id.ii_common_container);
        loginContainer= (RelativeLayout) activity.findViewById(R.id.ii_unlogin_title);
        unLoginContainer= (RelativeLayout) activity.findViewById(R.id.ii_login_title);

        goback= (ImageView) activity.findViewById(R.id.ii_title_goback);
        help= (ImageView) activity.findViewById(R.id.ii_title_help);
        login= (ImageView) activity.findViewById(R.id.ii_title_login);

        titleContent= (TextView) activity.findViewById(R.id.ii_title_content);
        userInfo= (TextView) activity.findViewById(R.id.ii_top_user_info);

        setListener();
    }
    private void setListener(){
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("返回键");
            }
        });
    }
    private void initTitle() {
        commonContainer.setVisibility(View.GONE);
        loginContainer.setVisibility(View.GONE);
        unLoginContainer.setVisibility(View.GONE);
    }

    //显示通用标题

    public void showCommonTitle() {

        initTitle();
        commonContainer.setVisibility(View.VISIBLE);
    }
    //显示未登录的标题

    public void showUnloginTitle() {

        initTitle();
        loginContainer.setVisibility(View.VISIBLE);
    }

    //显示登陆的标题
    public void showLoginTitle() {

        initTitle();
        unLoginContainer.setVisibility(View.VISIBLE);
    }
    public void changeTitle(String title){
        titleContent.setText(title);
    }
}
