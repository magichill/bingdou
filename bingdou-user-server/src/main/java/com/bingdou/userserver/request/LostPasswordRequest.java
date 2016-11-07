package com.bingdou.userserver.request;

import com.bingdou.core.helper.BaseRequest;
import com.bingdou.tools.JsonUtil;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * �������루�ֻ��ź������һأ�������
 */
public class LostPasswordRequest extends BaseRequest {

    /**
     * �ֻ��Ż�������
     */
    @SerializedName("phone_or_email")
    private String phoneOrEmail;
    /**
     * ��֤��
     */
    @SerializedName("validation_code")
    private String validationCode;
    /**
     * ����
     */
    @SerializedName("password")
    private String password;

    public String getPhoneOrEmail() {
        return phoneOrEmail;
    }

    public void setPhoneOrEmail(String phoneOrEmail) {
        this.phoneOrEmail = phoneOrEmail;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected String getLoggerName() {
        return "LostPasswordRequest";
    }

    @Override
    protected BaseRequest setFields(String requestString) {
        LostPasswordRequest request = JsonUtil.jsonStr2Bean(requestString, LostPasswordRequest.class);
        this.phoneOrEmail = request.getPhoneOrEmail();
        this.validationCode = request.getValidationCode();
        this.password = request.getPassword();
        return request;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
