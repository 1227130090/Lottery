package com.example.test.lottery.text;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.example.test.lottery.bean.User;
import com.example.test.lottery.engine.UserEngine;
import com.example.test.lottery.engine.impl.UserEngineInpl;
import com.example.test.lottery.net.protocal.Message;
import com.example.test.lottery.net.protocal.element.CurrentIssueElement;
import com.example.test.lottery.util.BeanFactory;


/**
 * Created by test on 2016/2/26.
 */
public class XmlTest extends InstrumentationTestCase {
    private static final String TAG = "XmlTest";

    public void testcreateXML() {
        Message message = new Message();

        CurrentIssueElement element = new CurrentIssueElement();
        element.getLotteryid().setTagValue("118");
        String xml = message.getXml(element);

        Log.i(TAG, xml);
    }

    public void testUserLogin() {
//        UserEngineInpl impl = new UserEngineInpl();
//        User user = new User();
//        user.setUsername("13200000000");
//        user.setPassword("000000");
//        Message login = impl.login(user);
//        Log.i(TAG, login.getBody().getOelemet().getErrorcode());
        UserEngine engine= BeanFactory.getImpl(UserEngine.class);
    }
}