package com.example.test.lottery.net.protocal;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

/**
 * 简单叶子
 */
public class Leaf {
    private String tagName;

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    private String tagValue;

    public Leaf(String tagName) {
        super();
        this.tagName=tagName;
    }

    public Leaf(String tagName,String tagValue){
        super();
        this.tagName=tagName;
        this.tagValue =tagValue;

    }



    public void serializerLeaf (XmlSerializer serializer){


        try {
            serializer.startTag(null,tagName);
            if(tagValue==null){
                tagValue=" ";
            }
            serializer.text(tagValue);
            serializer.endTag(null,tagName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
