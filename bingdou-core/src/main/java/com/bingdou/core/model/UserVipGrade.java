package com.bingdou.core.model;

import com.bingdou.tools.NumberUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * �û�VIP�ȼ�����ϵ
 */
public class UserVipGrade {

    /**
     * �û���ǰ��ֵ���(Ԫ)
     */
    private Float money = 0f;
    /**
     * �û���ǰʵ�ʵ�VIP�ȼ�
     */
    private Integer userLevelId = 0;
    /**
     * �û���ǰӦ��Ӧ��VIP�ȼ��ܹ���Ҫ��ֵ�Ľ��(Ԫ)
     */
    private Float rechargeAmount = 0f;
    /**
     * ��һ�ȼ�(���rechargeAmount)�ܹ���Ҫ��ֵ�Ľ��(Ԫ)
     */
    private Float nextLevelRechargeAmount = 0f;
    /**
     * ��һ�ȼ�(���rechargeAmount)����Ҫ��ֵ�Ľ��(Ԫ)
     */
    private Float nextLevelNeedRechargeAmount = 0f;
    /**
     * �Ƿ��ں�������
     */
    private boolean isInBlackList = false;
    /**
     * �Ƿ����µ�VIP�û�
     */
    private boolean isNewVipUser = false;

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(Integer userLevelId) {
        this.userLevelId = userLevelId;
    }

    public Float getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Float rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Float getNextLevelRechargeAmount() {
        return NumberUtil.formatFloat(nextLevelRechargeAmount) ;
    }

    public void setNextLevelRechargeAmount(Float nextLevelRechargeAmount) {
        this.nextLevelRechargeAmount = nextLevelRechargeAmount;
    }

    public Float getNextLevelNeedRechargeAmount() {
        return NumberUtil.formatFloat(nextLevelNeedRechargeAmount);
    }

    public void setNextLevelNeedRechargeAmount(Float nextLevelNeedRechargeAmount) {
        this.nextLevelNeedRechargeAmount = nextLevelNeedRechargeAmount;
    }

    public boolean isInBlackList() {
        return isInBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        isInBlackList = inBlackList;
    }

    public boolean isNewVipUser() {
        return isNewVipUser;
    }

    public void setNewVipUser(boolean newVipUser) {
        isNewVipUser = newVipUser;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
