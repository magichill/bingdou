package com.bingdou.core.constants;

/**
 */
public class UserConstants {

    private UserConstants() {
    }

    /**
     * VIP��ߵȼ�
     */
    public static final int TOP_VIP_LEVEL_ID = 12;
    /**
     * TOKEN����ʱ��7��
     */
    public static final int USER_TOKEN_EXPIRE_SECONDS = 604800;
    /**
     * CP TOKEN����ʱ�� 1����
     */
    public static final int USER_VALIDATE_TOKEN_EXPIRE_SECONDS = 60;
    /**
     * ��֤�����ʱ�䣨�룩
     */
    public static final int VALIDATION_CODE_EXPIRE_SECONDS = 1800;
    /**
     * ������֤�뷢��ʱ�������룩
     */
    public static final int VALIDATION_CODE_SEND_INTERVAL_SECONDS = 60;
    /**
     * ��ʼ���������Ӧ���̵곬ʱʱ��(����)
     */
    public static final int INIT_CALL_RESOURCE_APP_STORE_TIME_OUT = 1500;
    /**
     * ��ͨ�û�
     */
    public static final int NORMAL_USER_TYPE_INDEX_4_STATISTICS = 0;
    /**
     * �����û�
     */
    public static final int NEW_USER_TYPE_INDEX_4_STATISTICS = 1;
    /**
     * ��Ծ�û�
     */
    public static final int ACTIVE_USER_TYPE_INDEX_4_STATISTICS = 2;
    /**
     * cpidǰ׺
     */
    public static final String CP_PREFIX = "cpd";
    /**
     * �˻���ȫ��Ӧ�߼��� �ο����
     */
    public static final int SECURE_LEVEL_0 = 0;
    /**
     * �˻���ȫ��Ӧ�߼��� �˺ŵ�½
     */
    public static final int SECURE_LEVEL_1 = 1;
    /**
     * �˻���ȫ��Ӧ�߼�����������
     */
    public static final int SECURE_LEVEL_2 = 2;
    /**
     * �˻���ȫ��Ӧ�߼��� �����ֻ���
     */
    public static final int SECURE_LEVEL_3 = 3;
    /**
     * �˻���ȫ��Ӧ�߼��� �����ֻ��ź�����
     */
    public static final int SECURE_LEVEL_4 = 4;
    /**
     * �˻���ȫ��Ӧ�߼�:��������Ȩ
     */
    public static final int SECURE_LEVEL_5 = 5;
    /**
     * ���ŷ�����֤��ģ��
     */
    public static final String SEND_CODE_TEMPLATE_4_SMS = "�������������֤�룬30��������Ч���뼰ʱʹ�ã������֪���ˡ�";
    /**
     * �ʼ�������֤��ģ��
     */
    public static final String SEND_CODE_TEMPLATE_4_EMAIL = SEND_CODE_TEMPLATE_4_SMS + "������ֱ����";

    /**
     * ��¼����ʾ�Ŀͷ���ϵ��ʽ
     */
    public static final String USER_CUSTOM_SERVICE_NO = "1928175732,3065861697,2782722855";
    /**
     * ��ֵ��֧��������ʾ�Ŀͷ���ϵ��ʽ
     */
    public static final String PAY_CUSTOM_SERVICE_NO = "QQ 3065861697";
    /**
     * �û���ȫ�ȼ�:��
     */
    public static final int SAFE_LEVEL_LOW = 0;
    /**
     * �û���ȫ�ȼ�:��
     */
    public static final int SAFE_LEVEL_MEDIUM = 1;
    /**
     * �û���ȫ�ȼ�:��
     */
    public static final int SAFE_LEVEL_HIGH = 2;
    /**
     * �ο���������
     */
    public static final int ACCOUNT_UPDATE_TYPE_GUEST = 0;
    /**
     * �������˻���������
     */
    public static final int ACCOUNT_UPDATE_TYPE_THIRD = 1;
    /**
     * һ����ͬ�豸���Ͷ��Ż����ʼ������ƴ���
     */
    public static final int SEND_SMS_OR_EMAIL_COUNT_EVERY_DAY = 15;
    /**
     * һ����ͬ�豸��¼�������ƴ���
     */
    public static final int DEVICE_LOGIN_ERROR_COUNT_EVERY_DAY = 10;
    /**
     * �豸��¼������δ����״̬
     */
    public static final int DEVICE_LOGIN_BLACK_LIST_NO_STATUS = 0;
    /**
     * �豸��¼����������״̬
     */
    public static final int DEVICE_LOGIN_BLACK_LIST_YES_STATUS = 1;

    /**
     * ������֤������-����
     */
    public static final int SEND_CODE_SMS_TYPE = 1;
    /**
     * ������֤������-����
     */
    public static final int SEND_CODE_EMAIL_TYPE = 2;

}
