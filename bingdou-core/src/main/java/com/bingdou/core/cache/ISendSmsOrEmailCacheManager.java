package com.bingdou.core.cache;

/**
 * ���Ͷ��ź��ʼ��ļ�¼��������
 */
public interface ISendSmsOrEmailCacheManager {

    int getSendCount(String deviceNo);

    boolean updateSendCount(String deviceNo);

}