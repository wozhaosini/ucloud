/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.ucloud.usermanage.common;

/**
 * 角色枚举类
 * 
 * @author luojie 2014年9月21日 下午10:44:55
 */
public enum RoleEnum {
    STUDENT(1, "学生"),
    TEACHER(2, "教师"),
    ADMIN(3, "管理员");

    private int    status;
    private String desc;

    private RoleEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
