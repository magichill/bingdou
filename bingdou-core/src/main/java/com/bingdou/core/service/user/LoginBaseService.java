package com.bingdou.core.service.user;

import com.bingdou.core.repository.user.LoginDao;
import com.bingdou.tools.LogContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBaseService {

    @Autowired
    private LoginDao loginDao;

    public void clearLoginError(int userId) {
        LogContext.instance().info("��¼�����������");
        if (userId <= 0)
            return;
        loginDao.clearLoginError(userId);
    }

    public void setLoginError(int userId, int errorCount) {
        LogContext.instance().info("���µ�¼������Ϣ");
        if (userId <= 0)
            return;
        loginDao.setLoginError(userId, errorCount);
    }

    public void setLastLoginInfo(int userId, String ip, String oldUid, String oldUa) {
        LogContext.instance().info("��������¼��Ϣ");
        if (userId <= 0)
            return;
        loginDao.setLastLoginInfo(userId, ip, oldUid, oldUa);
    }
}
