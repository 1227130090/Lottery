package com.example.test.lottery.engine;

import android.util.Xml;

import com.example.test.lottery.ConstantValue;
import com.example.test.lottery.bean.User;
import com.example.test.lottery.net.HttpClientUtil;
import com.example.test.lottery.net.protocal.Message;
import com.example.test.lottery.net.protocal.element.UserLoginElement;
import com.example.test.lottery.util.DES;

import org.apache.commons.codec.digest.DigestUtils;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.io.StringReader;

/**
 * Created by test on 2016/2/27.
 */
public class UserEngineInpl {
    public Message login(User user) {
        //第一步：获取登陆用xml
        //创建登陆用Element
        UserLoginElement element = new UserLoginElement();
        //设置用户数据
        element.getActpassword().setTagValue(user.getPassword());
        //Message.getXml（element）
        Message message = new Message();
        message.getHeader().getUsername().setTagValue(user.getUsername());
        String xml = message.getXml(element);


        //第二步：（代码不变）发送xml到服务器，等待回复
        //HttpClientUtil。sendXml
        //在这行代码前 没有判断网络类型
        HttpClientUtil util = new HttpClientUtil();
        InputStream is = util.sendXml(ConstantValue.LOTTERY_URI, xml);
        //判断输入流非空
        if (is != null) {

            Message result = new Message();

            //第三步：数据的校检（MD5数据校检）

            //timestamp+digest+body

            XmlPullParser parser = Xml.newPullParser();
            try {
                parser.setInput(is, ConstantValue.ENCONDING);

                int eventType = parser.getEventType();
                String name;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            name = parser.getName();
                            if ("timestamp".equals(name)) {
                                result.getHeader().getTimestamp().setTagValue(parser.nextText());
                            }
                            if ("digest".equals(name)) {
                                result.getHeader().getDigest().setTagValue(parser.nextText());
                            }
                            if ("body".equals(name)) {
                                result.getBody().setServicebodyInsideDESInfo(parser.nextText());
                            }
                            break;
                    }
                    eventType = parser.next();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            //原始数据还原：时间戳（解析）+密码（常量）+ body明文（解析+解密DES）
            //明文body
            DES des = new DES();
            String body = "<body>" + des.authcode(result.getBody().getServicebodyInsideDESInfo(), "ENCODE", ConstantValue.DES_PASSWORD) + "<body>";
            String orgInfo = result.getHeader().getTimestamp().getTagValue() + ConstantValue.AGENTER_PASSWORD + body;
            //利用工具生成手机端的MD5
            String md5Hex = DigestUtils.md5Hex(orgInfo);
            //将手机端与服务器进行比对
            if (md5Hex.equals(result.getHeader().getDigest().getTagValue())) {
                //第四步请求结果的数据处理
                //body部分的第二次解析，解析的明文内容
                parser = Xml.newPullParser();
                try {
                    parser.setInput(new StringReader(body));
                    int eventType = parser.getEventType();
                    String name;

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
                                break;
                        }
                        eventType = parser.next();
                    }
                    return result;
                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        }
        return null;

    }
}
