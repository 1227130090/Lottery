package com.example.test.lottery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.test.lottery.view.FirstUI;
import com.example.test.lottery.view.manager.BottomManager;
import com.example.test.lottery.view.manager.TitleManager;

public class MainActivity extends Activity {

    private RelativeLayout middle;//中间站着位置的容器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }
    private void init(){
        TitleManager manager = TitleManager.getInstance();
        manager.init(this);
        manager.showUnLoginTitle();

        BottomManager.getInstrance().init(this);
        BottomManager.getInstrance().showCommonBottom();

        middle= (RelativeLayout) findViewById(R.id.ii_middle);
        FirstUI firstUI =new FirstUI(this);
        View child=firstUI.getChild();
        middle.addView(child);
    }
}
