package com.study;


import com.study.sdk.java_sdk.WXPayUtil;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        TreeMap paramMap = new TreeMap();
        paramMap.put("appid", "wx2a0f9f8c288435cf");//公众账号ID
        paramMap.put("nonce_str", "I9Bl1Iewg99DpQLX" );//随机字符串
        paramMap.put("package", "prepay_id=wx14231236180409bbc67653231497628828");//用户标识
        paramMap.put("sign_type", "MD5");//签名类型
        paramMap.put("timeStamp", "1544800356");//用户标识

        try {
            paramMap.put("sign",WXPayUtil.createSign( "UTF-8",paramMap));//签名
            System.out.println(WXPayUtil.GetMapToXML(paramMap));
            //WXPayUtil.httpOrder(WXPayUtil.GetMapToXML(paramMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}