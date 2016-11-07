package com.bingdou.core.cache;

import com.bingdou.core.constants.RedisDBConstants;
import com.bingdou.core.constants.UserConstants;
import com.bingdou.core.model.UserToken;
import com.bingdou.tools.LogContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * �û�������
 */
@Component
public class UserJedisCacheManager extends JedisManager implements IUserCacheManager {

    private static final String REDIS_USER_TOKEN_NAME = "user_token";
    private static final String REDIS_USER_VALIDATE_TOKEN_NAME = "user_validate_token";

    @Override
    public UserToken getUserToken(int userId) {
        if (userId <= 0) {
            return null;
        }
        String tokenKey = REDIS_USER_TOKEN_NAME + ":" + userId;
        UserToken userToken = null;
        try {
            Map<String, String> map = hgetAll(RedisDBConstants.USER_TOKEN_DB_INDEX, tokenKey);
            if (map != null && !map.isEmpty()) {
                userToken = new UserToken();
                userToken.setRequestSource(map.get("request_source"));
                userToken.setDevice(map.get("device"));
                userToken.setToken(map.get("token"));
            }
        } catch (Exception e) {
            LogContext.instance().error(e, "�ӻ����л�ȡ�û�tokenʧ��");
        }
        return userToken;
    }

    @Override
    public String getUserValidateToken(int userId) {
        if (userId <= 0) {
            return "";
        }
        String tokenKey = REDIS_USER_VALIDATE_TOKEN_NAME + ":" + userId;
        String token = "";
        try {
            get(RedisDBConstants.USER_TOKEN_DB_INDEX, tokenKey);
        } catch (Exception e) {
            LogContext.instance().error(e, "�ӻ����л�ȡ�û���֤tokenʧ��");
        }
        return token;
    }

    @Override
    public boolean setUserToken(int userId, String userToken, String device, String requestSource) {
        if (userId <= 0 || StringUtils.isEmpty(userToken)) {
            return false;
        }
        String tokenKey = REDIS_USER_TOKEN_NAME + ":" + userId;
        boolean result = false;
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("token", userToken);
            map.put("device", device);
            map.put("request_source", requestSource);
            hmset(RedisDBConstants.USER_TOKEN_DB_INDEX, tokenKey,
                    map, UserConstants.USER_TOKEN_EXPIRE_SECONDS);
            result = true;
        } catch (Exception e) {
            LogContext.instance().error(e, "�����û�token����ʧ��");
        }
        return result;
    }

    @Override
    public boolean setUserValidateToken(int userId, String userValidateToken) {
        if (userId <= 0 || StringUtils.isEmpty(userValidateToken)) {
            return false;
        }
        String tokenKey = REDIS_USER_VALIDATE_TOKEN_NAME + ":" + userId;
        boolean result = false;
        try {
            set(RedisDBConstants.USER_TOKEN_DB_INDEX, tokenKey, userValidateToken,
                    UserConstants.USER_VALIDATE_TOKEN_EXPIRE_SECONDS);
            result = true;
        } catch (Exception e) {
            LogContext.instance().error(e, "�����û���֤token����ʧ��");
        }
        return result;
    }

    @Override
    public boolean deleteUserToken(int userId) {
        if (userId <= 0) {
            return false;
        }
        String tokenKey = REDIS_USER_TOKEN_NAME + ":" + userId;
        boolean result = false;
        try {
            del(RedisDBConstants.USER_TOKEN_DB_INDEX, tokenKey);
            result = true;
        } catch (Exception e) {
            LogContext.instance().error(e, "ɾ���û�token����ʧ��");
        }
        return result;
    }

    @Override
    public boolean deleteUserValidateToken(int userId) {
        if (userId <= 0) {
            return false;
        }
        String tokenKey = REDIS_USER_VALIDATE_TOKEN_NAME + ":" + userId;
        boolean result = false;
        try {
            del(RedisDBConstants.USER_TOKEN_DB_INDEX, tokenKey);
            result = true;
        } catch (Exception e) {
            LogContext.instance().error(e, "ɾ���û���֤token����ʧ��");
        }
        return result;
    }

}
