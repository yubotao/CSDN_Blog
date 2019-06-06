package com.yubotao.autoSerial.model;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 11:51 2019/5/29
 * @Modified By:
 */
public class StrategySerial {
    private String strategy;  // 策略
    private String note; // 说明
    private String step; // 跨度
    private String prefix; // 前缀
    private String length;  //长度
    private String cacheSize;  // 缓存大小
    private String autoSerialModel;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(String cacheSize) {
        this.cacheSize = cacheSize;
    }

    public String getAutoSerialModel() {
        return autoSerialModel;
    }

    public void setAutoSerialModel(String autoSerialModel) {
        this.autoSerialModel = autoSerialModel;
    }
}
