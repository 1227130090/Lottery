package com.example.test.lottery.net.protocal;

import android.util.Xml;

import com.example.test.lottery.ConstantValue;
import com.example.test.lottery.util.DES;

import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlSerializer;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 2016/2/26.
 */

public class Body {
    //消息体节点封装


    @SuppressWarnings("CanBeFinal")
    private final List<Element> elements = new ArrayList<Element>();

    public List<Element> getElements() {
        return elements;
    }

    public void serializerBody(XmlSerializer serializer) {
        try {
            serializer.startTag(null, "body");
            serializer.startTag(null, "elements");

            for (Element item : elements) {
                item.serializerElement(serializer);
            }


            serializer.endTag(null, "elements");
            serializer.endTag(null, "body");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getWholeBody() {

        StringWriter writer = new StringWriter();

        XmlSerializer temp = Xml.newSerializer();
        try {
            temp.setOutput(writer);
            this.serializerBody(temp);
            temp.flush();
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getBodyInsideDESInfo() {

        //加密数据

        String wholeBody = getWholeBody();
        String orgDesInfo = StringUtils.substringBetween(wholeBody, "<body>", "</body>");

        //加密
        //加密代码好写调试 不好
        //加密的算法实现不同
        //加密的原始数据不同（回车）
        DES des=new DES();
        return  des.authcode(orgDesInfo,"DECODE", ConstantValue.DES_PASSWORD);
    }
}
