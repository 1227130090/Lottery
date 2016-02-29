package com.example.test.lottery.net;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.example.test.lottery.GlobalParams;

/**
 * Created by test on 2016/2/27.
 */
public class NetUtil {
    //检查用户网络
    public static boolean checkNet(Context content) {

        //判断  wifi 链接没
        boolean isWIFI = isWIFIConnection(content);
        //判断 Mobile 链接没
        boolean isMOBILE = isMOBILEConnection(content);

        //如果mobile 在链接，判断是哪个apn 被选中le
        if (isMOBILE) {
            readAPN(content);//判断是哪个APN 被选中
        }
        //坚持被选中的APN 的代理信息是否有内容，如果有 wap 方式，
        if (!isMOBILE && !isWIFI) {
            return false;
        }


        return true;
    }

    private static void readAPN(Context content) {
        Uri PREFERRED_APN_URI = Uri.parse("content://telepgony/carriers/preferapn");
        //操作联系人
        ContentResolver resolver = content.getContentResolver();
        //判断哪个被选中
        Cursor curson = resolver.query(PREFERRED_APN_URI, null, null, null, null);
        if (curson != null && curson.moveToFirst()) {
            GlobalParams.PROXY = curson.getString(curson.getColumnIndex("proxy"));
            GlobalParams.PORT = curson.getInt(curson.getColumnIndex("port"));
        }

    }

    private static boolean isMOBILEConnection(Context content) {
        ConnectivityManager manager = (ConnectivityManager) content.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }

        return false;
    }

    private static boolean isWIFIConnection(Context content) {
        ConnectivityManager manager = (ConnectivityManager) content.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }


}
