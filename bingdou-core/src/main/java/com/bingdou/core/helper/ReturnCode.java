package com.bingdou.core.helper;

/**
 * ����ֵ
 */
public enum ReturnCode {

    SUCCESS("1000"), ILLEGAL_REQUEST("1001"), SERVER_ERROR("1002"),
    TOKEN_EXPIRED("1003"), VOUCHER_EXPIRED("1004"), GUEST_LOGIN_UPDATED("1005");

    private String index;

    ReturnCode(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public void setTypeIndex(String index) {
        this.index = index;
    }

    public static ReturnCode getReturnCodeByIndex(String index) {
        for (ReturnCode returnCode : ReturnCode.values()) {
            if (returnCode.getIndex().equals(index))
                return returnCode;
        }
        return null;
    }
}
