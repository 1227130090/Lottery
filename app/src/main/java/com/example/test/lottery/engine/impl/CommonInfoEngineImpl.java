package com.example.test.lottery.engine.impl;

import android.util.Xml;

import com.example.test.lottery.ConstantValue;
import com.example.test.lottery.engine.BaseEngine;
import com.example.test.lottery.engine.CommonInfoEngine;
import com.example.test.lottery.net.protocal.Message;
import com.example.test.lottery.net.protocal.element.CurrentIssueElement;
import com.example.test.lottery.util.DES;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;

/**
 * Created by test on 2016/3/5.
 */
public class CommonInfoEngineImpl extends BaseEngine implements CommonInfoEngine {
    @Override
    public Message getCurrentIssueInfo(Integer lotteryId) {
        // 获取Xml

        CurrentIssueElement element = new CurrentIssueElement();
        element.getLotteryid().setTagValue(lotteryId.toString());
        Message message = new Message();
        String xml = message.getXml(element);


        Message result = super.getresult(xml);
        if (result != null) {

            //第四步请求结果的数据处理
            //body部分的第二次解析，解析的明文内容
            XmlPullParser parser = Xml.newPullParser();
            try {
                DES des = new DES();
                String body = "<body>" + des.authcode(result.getBody().getServicebodyInsideDESInfo(), "ENCODE", ConstantValue.DES_PASSWORD) + "<body>";

                parser.setInput(new StringReader(body));
                int eventType = parser.getEventType();
                String name;

                CurrentIssueElement resultElement = null;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            name = parser.getName();
                            if ("errorcode".equals(name)) {
                                result.getBody().getOelemet().setErrorcode(parser.nextText());
                            }
                            if ("errormsg".equals(name)) {
                                result.getBody().getOelemet().setErrormsg(parser.nextText());

                            }
                            //判断是否含有 element 标签 ，如果有穿件 resultElement
                            if ("element".equals(name)) {
                                resultElement = new CurrentIssueElement();
                                result.getBody().getElements().add(resultElement);
                            }
                            //解析特殊数据
                            if ("issue".equals(name)) {
                                if (resultElement != null) {
                                    resultElement.setIssue(parser.nextText());
                                }

                            }
                            if ("lasttime".equals(name)) {
                                if (resultElement != null) {
                                    resultElement.setLasstime(parser.nextText());
                                }
                            }

                            break;
                    }
                    eventType = parser.next();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();

            }

        }
        return null;
    }

}

