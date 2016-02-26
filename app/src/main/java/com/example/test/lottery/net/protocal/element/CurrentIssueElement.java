package com.example.test.lottery.net.protocal.element;

import com.example.test.lottery.net.protocal.Element;
import com.example.test.lottery.net.protocal.Leaf;

import org.xmlpull.v1.XmlSerializer;

/**
 * Created by test on 2016/2/26.
 */
public class CurrentIssueElement extends Element {
    //获取当前销售期的请求
    //<lotteryid>118</lotteryid>
    private Leaf lotteryid = new Leaf("lotteryid");
    //<issues>1</issues>
    private Leaf issues = new Leaf("issues", "1");


    @Override
    public void serializerElement(XmlSerializer serializer) {
        try {


            serializer.startTag(null, "element");

            lotteryid.serializerLeaf(serializer);
            issues.serializerLeaf(serializer);

            serializer.endTag(null, "element");
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @Override
    public String getTransactionType() {

        return "12002";
    }

    public Leaf getLotteryid() {
        return lotteryid;
    }
}
