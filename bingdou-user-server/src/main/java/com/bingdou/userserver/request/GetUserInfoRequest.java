package com.bingdou.userserver.request;

import com.bingdou.core.helper.BaseRequest;
import com.bingdou.tools.JsonUtil;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * ��ȡ�û���Ϣ������
 */
public class GetUserInfoRequest extends BaseRequest {

    /**
     * �û��˺�,�������û�����������ֻ��Ż�CP ID
     */
    @SerializedName("account")
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    protected String getLoggerName() {
        return "GetUserInfoRequest";
    }

    @Override
    protected BaseRequest setFields(String requestString) {
        GetUserInfoRequest request = JsonUtil.jsonStr2Bean(requestString, GetUserInfoRequest.class);
        this.account = request.getAccount();
        return request;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
