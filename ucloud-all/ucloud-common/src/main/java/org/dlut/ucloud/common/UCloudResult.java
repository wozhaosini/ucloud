/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.ucloud.common;

/**
 * 类UCloudResult.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年9月22日 下午11:49:05
 */
public class UCloudResult<T> {

    protected boolean success;

    protected T       model;

    protected String  msgCode;

    protected String  msgInfo;

    public UCloudResult() {

    }

    public UCloudResult(boolean success, String msgCode, String msgInfo) {
        this.success = success;
        this.msgCode = msgCode;
        this.msgInfo = msgInfo;
    }

    public static <T> UCloudResult<T> successResult(T t) {
        UCloudResult<T> result = new UCloudResult<T>();
        result.setSuccess(true);
        result.setModel(t);
        return result;
    }

    public static <T> UCloudResult<T> failedResult(String msgCode, String msgInfo) {
        UCloudResult<T> result = new UCloudResult<T>();
        result.setSuccess(false);
        result.setMsgCode(msgCode);
        result.setMsgInfo(msgInfo);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

}
