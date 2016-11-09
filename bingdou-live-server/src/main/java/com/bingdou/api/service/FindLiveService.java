package com.bingdou.api.service;

import com.bingdou.api.request.FindLiveRequest;
import com.bingdou.core.helper.BaseRequest;
import com.bingdou.core.helper.ServiceResult;
import com.bingdou.core.helper.ServiceResultUtil;
import com.bingdou.core.model.User;
import com.bingdou.core.service.BaseService;
import com.bingdou.core.service.IMethodService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 直播列表服务类
 * Created by gaoshan on 16-11-4.
 */
@Service
public class FindLiveService extends BaseService implements IMethodService {

    @Override
    public BaseRequest getBaseRequest(HttpServletRequest request) throws Exception {
        FindLiveRequest findLiveRequest = new FindLiveRequest();
        findLiveRequest.parseRequest(request);
        return findLiveRequest;
    }

    @Override
    public boolean checkUser() {
        return false;
    }

    @Override
    public User getUser(BaseRequest baseRequest) {
        return null;
    }

    @Override
    public String getMethodName() {
        return "find_live";
    }

    @Override
    public ServiceResult execute4Server(HttpServletRequest request, BaseRequest baseRequest, User user) throws Exception {
        FindLiveRequest findLiveRequest = (FindLiveRequest) baseRequest;
        return dealRegister(findLiveRequest,request);
    }

    @Override
    public ServiceResult execute4Client(HttpServletRequest request, BaseRequest baseRequest, User user) throws Exception {
        FindLiveRequest findLiveRequest = (FindLiveRequest) baseRequest;
        return dealRegister(findLiveRequest,request);
    }

    private ServiceResult dealRegister(FindLiveRequest findLiveRequest, HttpServletRequest request) throws Exception {
        return ServiceResultUtil.success();
    }

}
