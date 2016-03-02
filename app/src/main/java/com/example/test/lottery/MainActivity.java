package com.example.test.lottery;

import android.app.Activity;
import android.os.Bundle;

import com.example.test.lottery.view.manager.TitleManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }
    private void init(){
        TitleManager manager =new TitleManager();
        manager.init(this);
        manager.showUnloginTitle();
    }
}
