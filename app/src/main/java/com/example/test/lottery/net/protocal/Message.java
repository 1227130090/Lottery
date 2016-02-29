package com.example.test.lottery.net.protocal;

import android.util.Xml;

import com.example.test.lottery.ConstantValue;

import org.xmlpull.v1.XmlSerializer;

import java.io.StringWriter;

/**
 * 协议的封装 2016/2/26.
 */
public class Message {
    private Header header =new Header();
    private Body body =new Body();

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }
//序列化协议

    public void serializerMessage (XmlSerializer serializer){

        try{
            serializer.startTag(null,"message");
            serializer.attribute(null, "version", "1.0");

            header.serializerHeader(serializer, body.getWholeBody());//获取完整的body


        //
        //    body.serializerBody(serializer);

            serializer.startTag(null,"body");
            serializer.text(body.getBodyInsideDESInfo());
            serializer.endTag(null,"body");

            serializer.endTag(null,"message");


        }catch ( Exception e){
            e.printStackTrace();
        }
    }
    //获取 请求的Xml 文件
    public String getXml(Element element) {

        if (element==null){
            throw  new IllegalArgumentException("element is null ");
        }

        header.getTransactiontype().setTagValue(element.getTransactionType());

        body.getElements().add(element);




        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer =new StringWriter();

        try{
            serializer.setOutput(writer);
            serializer.startDocument(ConstantValue.ENCONDING, null);


            this.serializerMessage(serializer);
            serializer.endDocument();
            return writer.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
