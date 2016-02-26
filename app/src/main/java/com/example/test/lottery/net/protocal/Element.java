package com.example.test.lottery.net.protocal;

import org.xmlpull.v1.XmlSerializer;

/**
 * Created by test on 2016/2/26.
 */
public abstract class Element {
    //Element将作为所有请请求的代表
    //公共部分
    //1 每个请求都要序列化自己

    public abstract void serializerElement(XmlSerializer serializer);
    //2 每个请求都有自己的标识

    public abstract String getTransactionType();





/*    private Leaf lotteryid = new Leaf("lotteryid");

    private Leaf issues = new Leaf("issues", "1");


    public Leaf getLotteryid() {
        return lotteryid;

    }*/

    //序列化请求

//    public void serializerElement(XmlSerializer serializer) {
//        try {
//
//
//            serializer.startTag(null, "element");
//
//            lotteryid.serializerLeaf(serializer);
//            issues.serializerLeaf(serializer);
//
//            serializer.endTag(null, "element");
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//    }
/*

    //获取请求的标识
    public String getTransactionType() {
        return "12002";

    }
*/

}
