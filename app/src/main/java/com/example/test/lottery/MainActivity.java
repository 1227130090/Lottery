package com.example.test.lottery;

import android.app.Activity;
import android.os.Bundle;

import com.example.test.lottery.view.manager.BottomManager;
import com.example.test.lottery.view.manager.TitleManager;

public class MainActivity extends Activity {

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
    }
}
