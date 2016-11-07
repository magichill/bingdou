package com.bingdou.core.service.user;

import com.bingdou.core.model.SendCodeType;
import com.bingdou.core.repository.user.SmsSendRecordDao;
import com.bingdou.core.helper.LsmSmsResponse;
import com.bingdou.core.model.SmsSendRecord;
import com.bingdou.tools.JsonUtil;
import com.bingdou.tools.LogContext;
import com.bingdou.tools.ValidateUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;

/**
 * ���Ͷ��ŷ�����
 */
@Service
public class SmsSendService {

    /**
     * ���Ͷ���ͨ������:1:��������
     */
    private static String SEND_CHANNEL_TYPE = "1";
    /**
     * ����ͨ����׺(ǩ��)
     */
    private static final String SMS_SIGN = "������ֱ����";

    /**
     * luosimao���Ͷ��Žӿ�URL
     */
    private static final String LUOSIMAO_SEND_SMS_URL = "http://sms-api.luosimao.com/v1/send.json";

    /**
     * luosimao auth key
     */
    private static final String LUOSIMAO_AUTH_KEY = "key-d609b769db914a4d959bae3414ed1f7X";

    @Autowired
    private SmsSendRecordDao smsSendRecordDao;

    /**
     * ���Ͷ���
     */
    public boolean sendSMS(String mobile, String smsContent, SendCodeType sendCodeType,
                           String device, String ip) {
        if (StringUtils.isEmpty(smsContent) || sendCodeType == null
                || !ValidateUtil.isMobileNumber(mobile)) {
            LogContext.instance().error("���Ͷ��Ų�������");
            return false;
        }
        LogContext.instance().info("�������緢�Ͷ���");
        boolean isSuccess = sendLsmSMS(mobile, smsContent, sendCodeType, device, ip);

        if (!isSuccess) {
            LogContext.instance().error(SEND_CHANNEL_TYPE + "-���ŷ���ʧ��");
        }
        return isSuccess;
    }

    /**
     * Luosimao���Ͷ���
     */
    private boolean sendLsmSMS(String mobile,String smsContent,SendCodeType sendCodeType,
                               String device,String ip){
        boolean isSuccess = false;
        String messageId = "";
        smsContent = smsContent + SMS_SIGN;
        Client client = Client.create();
        try {
            client.addFilter(new HTTPBasicAuthFilter("api", LUOSIMAO_AUTH_KEY));
            WebResource webResource = client.resource(LUOSIMAO_SEND_SMS_URL);
            MultivaluedMapImpl formData = new MultivaluedMapImpl();
            formData.add("mobile", mobile);
            formData.add("message", smsContent);
            ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
                    post(ClientResponse.class, formData);
            String textEntity = response.getEntity(String.class);
            LsmSmsResponse lsmSmsResponse = JsonUtil.jsonStr2Bean(textEntity, LsmSmsResponse.class);
            LogContext.instance().info("���Ƿ���:"+textEntity);
            if(lsmSmsResponse.getError() == 0) {
                isSuccess = true;
                messageId = lsmSmsResponse.getBatchId();
            }
        }catch (Exception e){
            LogContext.instance().error(e, "���Ƕ��ŷ���ʧ��");
        }finally{

            client.destroy();
            smsSendRecordDao.insertRecord(buildRecord(mobile, smsContent, "lsm",
                    sendCodeType.getIndex(), isSuccess ? 1 : 0, messageId, device, ip));
        }
        return isSuccess;

    }

    private SmsSendRecord buildRecord(String mobile, String content, String channel,
                                      int sendType, int sendStatus, String messageId,
                                      String device, String ip) {
        SmsSendRecord record = new SmsSendRecord();
        record.setChannel(channel);
        record.setChannelMessageId(messageId);
        record.setContent(content);
        record.setMobile(mobile);
        record.setSendStatus(sendStatus);
        record.setSendType(sendType);
        record.setDevice(device);
        record.setIp(ip);
        return record;
    }

}
