/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package com.dlut.ucloud.web.obj;

import org.dlut.ucloud.common.enums.RoleEnum;

/**
 * 类LoginUser.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年9月21日 下午11:12:47
 */
public class LoginUser {
    private String   userName;
    private long     userId;
    private RoleEnum role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

}
