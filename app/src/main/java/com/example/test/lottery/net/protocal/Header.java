package com.example.test.lottery.net.protocal;

import com.example.test.lottery.ConstantValue;

import org.apache.commons.codec.digest.DigestUtils;
import org.xmlpull.v1.XmlSerializer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by test on 2016/2/25.
 */
public class Header {


    private Leaf agenterid = new Leaf("agenterid", ConstantValue.AGENTERID);

    private Leaf source = new Leaf("source",ConstantValue.SOURCE);

    private Leaf compress = new Leaf("compress",ConstantValue.COMPRESS);

    private Leaf messengerid = new Leaf("messengerid");

    private Leaf timestamp = new Leaf("timestamp");

    private Leaf digest = new Leaf("digest");

    private Leaf transactiontype = new Leaf("transactiontype");

    private Leaf username = new Leaf("username");

    public void serializerHeader(XmlSerializer serializer, String body) {
        //将第二部分  timestamp  messengerid  difest
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format.format(new java.util.Date());
        timestamp.setTagValue(time);
        //messengerid: 时间戳+6位随机数
        Random random = new Random();
        int num = random.nextInt(999999) + 1;//[0,n).[1.999999]
        DecimalFormat decimalFormat = new DecimalFormat("000000");
        messengerid.setTagValue(time + decimalFormat.format(num));
        //digest：时间戳+代理商密码+完整的body（明文）
        String orgInfo = time + ConstantValue.AGENTER_PASSWORD + body;
        String md5Hex = DigestUtils.md5Hex(orgInfo);
        digest.setTagValue(md5Hex);


        try {



            serializer.startTag(null, "header");

            agenterid.serializerLeaf(serializer);

            source.serializerLeaf(serializer);

            compress.serializerLeaf(serializer);

            messengerid.serializerLeaf(serializer);

            timestamp.serializerLeaf(serializer);

            digest.serializerLeaf(serializer);

            transactiontype.serializerLeaf(serializer);

            username.serializerLeaf(serializer);


            serializer.endTag(null, "haeder");
        } catch (Exception e) {
            e.printStackTrace();

        }



    }

    public Leaf getUsername() {
        return username;
    }

    public Leaf getTransactiontype() {
        return transactiontype;
    }
  /*******************************处理服务器端回复********************************************/
    public Leaf getTimestamp() {
        return timestamp;
    }

    public Leaf getDigest() {
        return digest;
    }
}
