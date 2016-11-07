package com.bingdou.userserver.request;

import com.bingdou.core.helper.BaseRequest;
import com.bingdou.tools.JsonUtil;
import com.google.gson.annotations.SerializedName;

/**
 * ���䡢�����·���֤��������
 */
public class SendCodeRequest extends BaseRequest {

    /**
     * �ֻ���������
     */
    @SerializedName("phone_or_email")
    private String phoneOrEmail;
    /**
     * ��������:1:��,2:��������,3:�ֻ���ע��
     */
    @SerializedName("type")
    private int type;
    /**
     * �û��˺�,�������û���¼������CPID,�����ͱ��봫
     */
    @SerializedName("account")
    private String account;

    @Override
    protected String getLoggerName() {
        return "SendCodeRequest";
    }

    @Override
    protected BaseRequest setFields(String requestString) {
        SendCodeRequest request = JsonUtil.jsonStr2Bean(requestString, SendCodeRequest.class);
        this.phoneOrEmail = request.getPhoneOrEmail();
        this.type = request.getType();
        this.account = request.getAccount();
        return request;
    }

    public String getPhoneOrEmail() {
        return phoneOrEmail;
    }

    public void setPhoneOrEmail(String phoneOrEmail) {
        this.phoneOrEmail = phoneOrEmail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
