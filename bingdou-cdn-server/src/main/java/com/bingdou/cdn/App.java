package com.bingdou.cdn;

import com.bingdou.cdn.constant.UpYunConstant;
import com.bingdou.cdn.request.UpYunRequest;
import com.bingdou.tools.HttpClientUtil;
import com.bingdou.tools.NumberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoshan on 16-11-12.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Map<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("Authorization",UpYunConstant.REQUEST_HEADER);
        UpYunRequest request = new UpYunRequest();
        List<String> streams = new ArrayList<String>();
        String streamName = String.valueOf(System.currentTimeMillis())+NumberUtil.getRandomNum(1000,9999);
        streams.add(streamName);
        request.setStream(streams);
        request.setApp("bingdou_live");
        System.out.println(request.toString());
        HttpClientUtil.doPostJsonOrXmlHttpClient("createLive", UpYunConstant.CREATE_LIVE_URL,request.toString(),false,headerMap,3000,3000);

    }
}
