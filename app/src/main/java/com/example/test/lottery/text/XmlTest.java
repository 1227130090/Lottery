package com.example.test.lottery.text;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.example.test.lottery.net.protocal.Message;
import com.example.test.lottery.net.protocal.element.CurrentIssueElement;


/**
 * Created by test on 2016/2/26.
 */
public class XmlTest extends InstrumentationTestCase {
    private static final String TAG = "XmlTest";

    public void testcreateXML()
    {
        Message message =new Message();

        CurrentIssueElement element=new CurrentIssueElement();
        element.getLotteryid().setTagValue("118");
        String xml=message.getXml(element);

        Log.i(TAG, xml);
    }
}
