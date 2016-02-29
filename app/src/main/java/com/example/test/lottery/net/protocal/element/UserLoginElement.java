package com.example.test.lottery.net.protocal.element;

import com.example.test.lottery.net.protocal.Element;
import com.example.test.lottery.net.protocal.Leaf;

import org.xmlpull.v1.XmlSerializer;

/**
 * //用户登录用请求
 */
public class UserLoginElement extends Element {


    private Leaf actpassword=new Leaf ("actpassword");

    @Override
    public void serializerElement(XmlSerializer serializer) {
        try{
            serializer.startTag(null,"element");
            actpassword.serializerLeaf(serializer);
            serializer.endTag(null,"element");
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    @Override
    public String getTransactionType() {
        return "14001";
    }

    public Leaf getActpassword() {
        return actpassword;
    }
}
