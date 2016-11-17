package com.bingdou.cdn.service;

import com.bingdou.cdn.constant.CdnType;
import com.bingdou.cdn.constant.UpYunConstant;
import com.bingdou.cdn.request.CreateLiveRequest;
import com.bingdou.cdn.response.CreateLiveResponse;
import com.bingdou.core.helper.BaseRequest;
import com.bingdou.core.helper.ServiceResult;
import com.bingdou.core.helper.ServiceResultUtil;
import com.bingdou.core.model.User;
import com.bingdou.core.service.BaseService;
import com.bingdou.tools.LogContext;
import com.bingdou.tools.NumberUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaoshan on 16-11-11.
 * 又拍云cdn服务类
 *
 */
@Service
public class UpYunService extends BaseService implements ICdnService{

    @Override
    public String getCdnName() {
        return CdnType.UPYUN.getName();
    }

    @Override
    public ServiceResult createCdnLive(BaseRequest baseRequest) {
        LogContext.instance().info("创建又拍云直播流");
//        Map<String,String> headerMap = new HashMap<String, String>();
//        headerMap.put("Authorization", UpYunConstant.REQUEST_HEADER);
//        UpYunRequest request = new UpYunRequest();
//        List<String> streams = new ArrayList<String>();
        CreateLiveRequest createLiveRequest = (CreateLiveRequest) baseRequest;
        String streamName = String.valueOf(System.currentTimeMillis())+createLiveRequest.getLiveId();
//        streams.add(streamName);
//        request.setStream(streams);
//        request.setApp(UpYunConstant.APP_NAME_PREFIX+streamName);
//        System.out.println(request.toString());
//        try {
//            HttpClientUtil.doPostJsonOrXmlHttpClient("createUpYunStream", UpYunConstant.CREATE_LIVE_URL,request.toString(),false,headerMap,3000,3000);
//        } catch (Exception e) {
//            LogContext.instance().error(e,"创建又拍云直播流异常");
//            return ServiceResultUtil.serverError("创建又拍云直播流异常");
//        }
        CreateLiveResponse response = buildCreateLiveResponse(streamName);
        return ServiceResultUtil.success(response);
    }

    @Override
    public BaseRequest getBaseRequest(HttpServletRequest request) throws Exception {
        CreateLiveRequest createLiveRequest = new CreateLiveRequest();
        createLiveRequest.parseRequest(request);
        return createLiveRequest;
    }

    @Override
    public boolean checkUser() {
        return false;
    }

    @Override
    public User getUser(BaseRequest baseRequest) {
        return null;
    }

    private CreateLiveResponse buildCreateLiveResponse(String streamName){
        CreateLiveResponse response = new CreateLiveResponse();
        String pushUrl = UpYunConstant.UPYUN_PUSH_URL+UpYunConstant.UPYUN_APP_NAME+"/"+streamName;
        String playUrl = UpYunConstant.UPYUN_PLAY_URL+UpYunConstant.UPYUN_APP_NAME+"/"+streamName+UpYunConstant.FLV_SUFFIX;
        response.setPushUrl(pushUrl);
        response.setPlayUrl(playUrl);
        return response;
    }
}
