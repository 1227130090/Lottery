package com.example.test.lottery.text;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.example.test.lottery.net.protocal.Element;
import com.example.test.lottery.net.protocal.Message;


/**
 * Created by test on 2016/2/26.
 */
public class XmlText extends InstrumentationTestCase {
    private static final String TAG = "XmlTest";

    public void testcreateXML()
    {
        Message message =new Message();
        Element element =new Element();
        String xml=message.getXml(element);

        Log.i(TAG, xml);
    }
}
