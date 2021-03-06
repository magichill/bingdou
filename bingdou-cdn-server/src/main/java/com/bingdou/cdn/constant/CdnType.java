package com.bingdou.cdn.constant;

/**
 * Created by gaoshan on 16-11-11.
 */
public enum CdnType {

    UPYUN("upyun",1),CHINANET("cnc",2);

    private int index;
    private String name;

    CdnType(String name, int index){
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CdnType getByIndex(int index) {
        for (CdnType cdnType : CdnType.values()) {
            if (index == cdnType.getIndex())
                return cdnType;
        }
        return null;
    }
}
