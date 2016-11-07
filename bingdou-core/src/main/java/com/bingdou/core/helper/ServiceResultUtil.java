package com.bingdou.core.helper;

import com.bingdou.tools.JsonUtil;
import com.google.gson.JsonElement;

/**
 */
public class ServiceResultUtil {

    private ServiceResultUtil() {
    }

    /**
     * ����tokenʧЧ���
     */
    public static ServiceResult tokenExpired() {
        return new ServiceResult(ReturnCode.TOKEN_EXPIRED, "���Ƽ��ʧ��");
    }

    /**
     * �������ȯ���ڽ��
     */
    public static ServiceResult voucherExpired() {
        return new ServiceResult(ReturnCode.VOUCHER_EXPIRED, "����ȯ����");
    }

    /**
     * �����ο��˺��Ѿ��������
     */
    public static ServiceResult guestLoginUpdated(JsonElement result) {
        return new ServiceResult(ReturnCode.GUEST_LOGIN_UPDATED, result, "�ο��˺�������,��ʹ�������¼");
    }

    /**
     * ����Ƿ�������
     */
    public static ServiceResult illegal(String msg) {
        return new ServiceResult(ReturnCode.ILLEGAL_REQUEST, msg);
    }

    /**
     * ����ɹ�������
     */
    public static ServiceResult success(JsonElement result) {
        return new ServiceResult(result);
    }

    /**
     * ����ɹ�������
     */
    public static ServiceResult success(Object responseBean) {
        return success(JsonUtil.bean2JsonTree(responseBean));
    }

    /**
     * ����ɹ�������
     */
    public static ServiceResult success() {
        return new ServiceResult();
    }

    /**
     * ����������쳣���
     */
    public static ServiceResult serverError(String msg) {
        return new ServiceResult(ReturnCode.SERVER_ERROR, msg);
    }

}
