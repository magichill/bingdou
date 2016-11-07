package com.bingdou.core.model;

/**
 */
public enum UserStatus {

    VALID(1, "����"),
    INVALID(0, "δ����"),
    PAUSE(2, "����ͣ"),
    DENY(5, "�ѽ���");

    private int status;
    private String name;

    UserStatus(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public static UserStatus valueOf(int value) {
        for (UserStatus us : UserStatus.values()) {
            if (us.getStatus() == value) {
                return us;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }
}
