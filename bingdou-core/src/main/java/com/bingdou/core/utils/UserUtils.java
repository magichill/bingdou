package com.bingdou.core.utils;


import com.bingdou.core.constants.UserConstants;
import com.bingdou.core.helper.BaseRequest;
import com.bingdou.core.helper.DeviceInfo;
import com.bingdou.core.model.Os;
import com.bingdou.core.model.User;
import com.bingdou.tools.DateUtil;
import com.bingdou.tools.LogContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 *
 */
public class UserUtils {

    private UserUtils() {
    }

    public static String getUserCustomServiceNo() {
        try {
            String[] serviceNoArray = UserConstants.USER_CUSTOM_SERVICE_NO.split(",");
            Random random = new Random(System.currentTimeMillis());
            int index = random.nextInt(serviceNoArray.length);
            return "QQ " + serviceNoArray[index];
        } catch (Exception e) {
            LogContext.instance().error(e, "��ȡ�û���ؿͷ�����ʧ��");
        }
        return UserConstants.PAY_CUSTOM_SERVICE_NO;
    }

    public static int getSafeLevel(User user) {
        if (user == null)
            return UserConstants.SAFE_LEVEL_LOW;
        int safeLevel = UserConstants.SAFE_LEVEL_LOW;
        if (StringUtils.isNotEmpty(user.getMobile())) {
            safeLevel = UserConstants.SAFE_LEVEL_HIGH;
        } else if (StringUtils.isNotEmpty(user.getEmail())
                || StringUtils.isNotEmpty(user.getPassword())) {
            safeLevel = UserConstants.SAFE_LEVEL_MEDIUM;
        }
        return safeLevel;
    }

    public static String getOldUid4Client(BaseRequest baseRequest) {
        if (baseRequest == null || baseRequest.getDeviceInfo() == null)
            return "";
        String result = "";
        try {
            DeviceInfo deviceInfo = baseRequest.getDeviceInfo();
            String udidOrImei = "";
            String openUdid = "";
            String androidIdOrIDFA = "";
            String androidSerialNumberOrIDFV = "";
            if (Os.IOS.getIndex() == deviceInfo.getOs()) {
                udidOrImei = deviceInfo.getIosInfo().getUdid();
                openUdid = deviceInfo.getIosInfo().getOpenUdid();
                androidIdOrIDFA = deviceInfo.getIosInfo().getIdfa();
                androidSerialNumberOrIDFV = deviceInfo.getIosInfo().getIdfv();
            } else if (Os.ANDROID.getIndex() == deviceInfo.getOs()) {
                udidOrImei = deviceInfo.getImei();
                androidIdOrIDFA = deviceInfo.getAndroidInfo().getAndroidId();
                androidSerialNumberOrIDFV = deviceInfo.getAndroidInfo().getAndroidSerialNumber();
            }
            result = deviceInfo.getMac() + "_&" +
                    udidOrImei + "_&" +
                    openUdid + "_&" +
                    androidIdOrIDFA + "_&" +
                    androidSerialNumberOrIDFV + "_&_&";
        } catch (Exception e) {
            LogContext.instance().error(e, "��ȡ�Ϸ���UID�ַ�������");
        }
        return result;
    }

    public static String getOldUa4Client(BaseRequest baseRequest) {
        if (baseRequest == null || baseRequest.getDeviceInfo() == null)
            return "";
        String result = "";
        try {
            DeviceInfo deviceInfo = baseRequest.getDeviceInfo();
            String osName = "";
            if (deviceInfo.getOs() == Os.IOS.getIndex()) {
                osName = Os.IOS.getName();
            } else if (deviceInfo.getOs() == Os.ANDROID.getIndex()) {
                osName = Os.ANDROID.getName();
            }
            result = deviceInfo.getBrand() + "_&" +
                    deviceInfo.getModel() + "_&" +
                    osName + "_&" +
                    deviceInfo.getOsVersion() + "_&" +
                    deviceInfo.getBaseBand() + "_&" +
                    deviceInfo.getKernel() + "_&" +
                    deviceInfo.getLac() + "_&" +
                    deviceInfo.getCellId();
        } catch (Exception e) {
            LogContext.instance().error(e, "��ȡ�Ϸ���UA�ַ�������");
        }
        return result;
    }

//    public static SearchConfigMessageDTO buildSearchConfigMessageDTO(BaseRequest baseRequest, TrayIcon.MessageType messageType,
//                                                                     Os os, String clientIp,
//                                                                     List<ConfigMessageStrategyType> strategyTypeList,
//                                                                     ConfigMessageBoxType configMessageBoxType, User user) {
//        if (baseRequest == null)
//            return new SearchConfigMessageDTO();
//        SearchConfigMessageDTO dto = new SearchConfigMessageDTO();
//        dto.setConfigMessageStrategyTypeList(strategyTypeList);
//        dto.setConfigMessageBoxType(configMessageBoxType);
//        dto.setUser(user);
//        if (baseRequest.getDeviceInfo() != null) {
//            if (Os.IOS.equals(os) && baseRequest.getDeviceInfo().getIosInfo() != null) {
//                dto.setDeviceNo(baseRequest.getDeviceInfo().getIosInfo().getIdfa());
//                dto.setPhoneModel(baseRequest.getDeviceInfo().getModel());
//            } else if (Os.ANDROID.equals(os) && baseRequest.getDeviceInfo().getAndroidInfo() != null) {
//                dto.setDeviceNo(baseRequest.getDeviceInfo().getAndroidInfo().getAndroidId());
//            }
//        }
//        if (baseRequest.getOtherInfo() != null) {
//            dto.setAppId(baseRequest.getOtherInfo().getAppId());
//            dto.setChannel(baseRequest.getOtherInfo().getChannel());
//        }
//        dto.setMessageType(messageType);
//        if (user != null)
//            dto.setVipLevelId(user.getVipLevel());
//        if (os != null)
//            dto.setOsIndex(os.getIndex());
//        dto.setBaseRequest(baseRequest);
//        dto.setClientIp(clientIp);
//        return dto;
//    }

    /**
     * �����֤���Ƿ���Ч
     */
    public static boolean isValidationCodeValid(String validationCodeInput, String validationCodeReal, long validationCodeTime) {
        return StringUtils.isNotEmpty(validationCodeInput)
                && StringUtils.isNotEmpty(validationCodeReal)
                && validationCodeInput.toLowerCase().equals(validationCodeReal.toLowerCase())
                && DateUtil.getCurrentTimeSeconds() - validationCodeTime < UserConstants.VALIDATION_CODE_EXPIRE_SECONDS;
    }

}