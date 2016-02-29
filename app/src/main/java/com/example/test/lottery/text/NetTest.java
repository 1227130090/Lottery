package com.example.test.lottery.text;

import android.test.AndroidTestCase;

import com.example.test.lottery.net.NetUtil;

/**
 * Created by test on 2016/2/27.
 */
public class NetTest extends AndroidTestCase {
    public  void testNetTy(){
        NetUtil.checkNet(getContext());
    }
}
